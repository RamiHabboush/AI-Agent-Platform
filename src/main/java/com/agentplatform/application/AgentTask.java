package com.agentplatform.application;

public class AgentTask {

    private String agentId;
    private int step;
    private int maxSteps = 20;

    public AgentTask(String agentId, int step) {
        this.agentId = agentId;
        this.step = step;
    }

    public String getAgentId() {
        return agentId;
    }

    public int getStep() {
        return step;
    }
}