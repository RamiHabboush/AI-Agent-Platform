package com.agentplatform.agent;

import com.agentplatform.memory.Memory;
import com.agentplatform.monitoring.AgentLogger;
import com.agentplatform.tools.*;

public class AgentLoop {

    private Reasoner reasoner;
    private Memory memory;
    private Planner planner;
    private Executor executor;
    private ToolExecutor toolExecutor;
    private ToolRegistry registry;

    public AgentLoop(Reasoner reasoner, Memory memory, ToolRegistry registry) {
        this.reasoner = reasoner;
        this.memory = memory;
        this.registry = registry;
        this.executor = new Executor(new ToolExecutor(registry));
        this.planner = new Planner();
    }

    public void run(Agent agent) {

        int step = 1;

        while (!agent.isGoalAchieved() && step <= 20) {

            System.out.println("\n--- Step " + step + " ---");

            String tools = registry.describeTools();

            String response = reasoner.thinkNextStep(
                agent.getGoal(),
                memory.getContext(),
                tools
            );

            if (response.equalsIgnoreCase("DONE")) {
                agent.setGoalAchieved(true);
                break;
            }

            String tool = "";
            String input = "";

            String[] lines = response.split("\n");
            for (String line : lines) {
                if (line.startsWith("TOOL:")) {
                    tool = line.replace("TOOL:", "").trim();
                } else if (line.startsWith("INPUT:")) {
                    input = line.replace("INPUT:", "").trim();
                }
            }

            if (tool.isEmpty()) break;

            String result = executor.execute(tool, input);

            System.out.println("Result: " + result);

            if (planner.isGoalAchieved(result, agent.getGoal())) {
                agent.setGoalAchieved(true);
            }

            memory.add("Step " + step + ": " + result + " → " + result);

            AgentLogger.log("Step " + step + " started");
            AgentLogger.log("Tool used: " + tool);
            AgentLogger.log("Result: " + result);

            step++;
        }
    }
}