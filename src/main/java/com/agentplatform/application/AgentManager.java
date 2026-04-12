package com.agentplatform.application;

import java.util.*;

import com.agentplatform.domain.Agent;

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