package com.agentplatform.application;

import com.agentplatform.domain.AgentState;

public interface AgentStateRepository {

    AgentState get(String agentId);

    void save(AgentState state);
}