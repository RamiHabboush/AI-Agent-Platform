package com.agentplatform.application;

public class Planner {
    public boolean isGoalAchieved(String lastResult, String goal) {
        if (lastResult == null) return false;

        return lastResult.toLowerCase().contains("completed")
                || lastResult.toLowerCase().contains("done")
                || lastResult.toLowerCase().contains(goal.toLowerCase());
    }
}
