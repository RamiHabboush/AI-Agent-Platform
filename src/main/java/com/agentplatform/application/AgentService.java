package com.agentplatform.application;

import com.agentplatform.domain.Agent;
import com.agentplatform.domain.AgentState;
import com.agentplatform.infrastructure.llm.LLMClient;
import com.agentplatform.infrastructure.tools.ToolRegistry;
import com.agentplatform.domain.memory.Memory;

public class AgentService {

    private Reasoner reasoner;
    private Planner planner;
    private Executor executor;
    private AgentStateRepository stateRepository;

    public AgentService(LLMClient llm,
                    ToolRegistry toolRegistry,
                    AgentStateRepository stateRepository) {
        this.reasoner = new Reasoner(llm, toolRegistry);
        this.planner = new Planner();
        this.executor = new Executor(toolRegistry);
        this.stateRepository = stateRepository;
    }

    public String executeStep(Agent agent) {

        AgentState state = stateRepository.get(agent.getName());

        if (state.isGoalAchieved()) {
            return "Already completed";
        }

        state.incrementStep();

        String memoryContext = agent.getMemory().getContext();

        String response = reasoner.thinkNextStep(
                agent.getGoal(),
                memoryContext
        );

        if (response.equalsIgnoreCase("DONE")) {
            state.setGoalAchieved(true);
            stateRepository.save(state);
            return "Goal completed";
        }

        String tool = "";
        String input = "";

        for (String line : response.split("\n")) {
            if (line.startsWith("TOOL:")) {
                tool = line.replace("TOOL:", "").trim();
            } else if (line.startsWith("INPUT:")) {
                input = line.replace("INPUT:", "").trim();
            }
        }

        String result;

        try {
            result = executor.execute(tool, input);
            state.addHistory("Step " + state.getStep() + ": " + tool + " → " + result);

        } catch (Exception e) {
            state.addError(e.getMessage());
            result = "ERROR: " + e.getMessage();
        }

        agent.getMemory().add(result);

        if (planner.isGoalAchieved(result, agent.getGoal())) {
            state.setGoalAchieved(true);
        }

        stateRepository.save(state);

        return result;
    }
}