package com.agentplatform.application;

import com.agentplatform.domain.Agent;
import com.agentplatform.domain.AgentState;
import com.agentplatform.infrastructure.queue.TaskQueue;

import java.util.Map;

public class AgentWorker implements Runnable {

    private TaskQueue queue;
    private AgentService agentService;
    private Map<String, Agent> agentStore;
    private AgentStateRepository stateRepository;

    public AgentWorker(TaskQueue queue,
                   AgentService agentService,
                   Map<String, Agent> agentStore,
                   AgentStateRepository stateRepository) {

        this.queue = queue;
        this.agentService = agentService;
        this.agentStore = agentStore;
        this.stateRepository = stateRepository;
    }

    @Override
    public void run() {
        while (true) {
            try {
                AgentTask task = queue.take();

                Agent agent = agentStore.get(task.getAgentId());

                if (agent == null) continue;

                AgentState state = stateRepository.get(agent.getName());

                if (state.isGoalAchieved()) continue;

                if (state.getStep() >= 20) {
                    System.out.println("Max steps reached for " + agent.getName());
                    state.setGoalAchieved(true);
                    stateRepository.save(state);
                    continue;
                }

                String result = agentService.executeStep(agent);

                System.out.println("Agent: " + agent.getName() +
                   " | Step: " + state.getStep() +
                   " | Result: " + result);

                // requeue next step
                queue.submit(new AgentTask(agent.getName(), task.getStep() + 1));

                // if (result.equals(agent.getMemory().getContext())) {
                //     System.out.println("Loop detected. Stopping.");
                //     agent.setGoalAchieved(true);
                //     continue;
                // }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}