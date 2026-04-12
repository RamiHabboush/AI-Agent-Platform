package com.agentplatform.agent;

import java.util.*;

public class AgentManager {

    private Map<String, Agent> agents = new HashMap<>();

    public void registerAgent(Agent agent) {
        agents.put(agent.getName(), agent);
    }

    public Agent getAgent(String name) {
        return agents.get(name);
    }

    public Collection<Agent> getAllAgents() {
        return agents.values();
    }
}