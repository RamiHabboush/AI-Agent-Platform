package com.agentplatform.scheduler;

import com.agentplatform.agent.Agent;
import com.agentplatform.agent.AgentLoop;

import java.util.concurrent.*;

public class Scheduler {

    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);

    public void scheduleAgent(Agent agent, AgentLoop loop, int intervalSeconds) {
        executor.scheduleAtFixedRate(() -> {
            loop.run(agent);
        }, 0, intervalSeconds, TimeUnit.SECONDS);
    }
}