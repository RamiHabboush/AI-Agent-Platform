package com.agentplatform.domain;

import java.util.ArrayList;
import java.util.List;

public class AgentState {

    private String agentId;
    private int step;
    private boolean goalAchieved;

    private List<String> history = new ArrayList<>();
    private List<String> errors = new ArrayList<>();

    public AgentState(String agentId) {
        this.agentId = agentId;
        this.step = 0;
        this.goalAchieved = false;
    }

    public String getAgentId() { return agentId; }

    public int getStep() { return step; }

    public void incrementStep() { this.step++; }

    public boolean isGoalAchieved() { return goalAchieved; }

    public void setGoalAchieved(boolean goalAchieved) {
        this.goalAchieved = goalAchieved;
    }

    public List<String> getHistory() { return history; }

    public void addHistory(String entry) {
        history.add(entry);
    }

    public void addError(String error) {
        errors.add(error);
    }

    public List<String> getErrors() { return errors; }
}