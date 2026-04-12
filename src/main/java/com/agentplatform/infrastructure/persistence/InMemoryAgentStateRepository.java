package com.agentplatform.infrastructure.persistence;

import com.agentplatform.application.AgentStateRepository;
import com.agentplatform.domain.AgentState;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAgentStateRepository implements AgentStateRepository {

    private Map<String, AgentState> store = new HashMap<>();

    @Override
    public AgentState get(String agentId) {
        return store.computeIfAbsent(agentId, AgentState::new);
    }

    @Override
    public void save(AgentState state) {
        store.put(state.getAgentId(), state);
    }
}