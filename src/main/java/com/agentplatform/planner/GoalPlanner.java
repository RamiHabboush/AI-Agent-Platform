package com.agentplatform.planner;

import java.util.*;

public class GoalPlanner {

    public List<Goal> prioritize(List<Goal> goals) {
        goals.sort((a, b) -> b.getPriority() - a.getPriority());
        return goals;
    }
}