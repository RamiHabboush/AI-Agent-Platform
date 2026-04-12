package com.agentplatform.agent;

import java.util.ArrayList;
import java.util.List;

import com.agentplatform.memory.Memory;
import com.agentplatform.memory.VectorMemory;
import com.agentplatform.planner.Goal;

public class Agent {

    private String name;
    private String goal;
    private boolean goalAchieved;
    private Memory memory;
    private VectorMemory vectorMemory;
    private List<Goal> goals = new ArrayList<>();

    // Constructor
    public Agent(String name, String goal, Memory memory) {
        this.name = name;
        this.goal = goal;
        this.memory = memory;
    }
    
    // Getters and setters
    public String getName() {
        return name;
    }

    public String getGoal() {
        return goal;
    }

    public boolean isGoalAchieved() {
        return goalAchieved;
    }

    public Memory getMemory() {
        return memory;
    }

    public VectorMemory getVectorMemory() {
        return vectorMemory;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoalAchieved(boolean goalAchieved) {
        this.goalAchieved = goalAchieved;
    }
}