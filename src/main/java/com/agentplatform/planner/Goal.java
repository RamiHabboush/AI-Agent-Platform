package com.agentplatform.planner;

public class Goal {

    private String description;
    private int priority;

    public Goal(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}