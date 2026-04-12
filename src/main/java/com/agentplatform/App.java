package com.agentplatform;

import com.agentplatform.application.*;
import com.agentplatform.domain.Agent;
import com.agentplatform.infrastructure.queue.TaskQueue;
import com.agentplatform.infrastructure.tools.ToolRegistry;
import com.agentplatform.infrastructure.tools.WebSearchTool;
import com.agentplatform.infrastructure.llm.*;
import com.agentplatform.infrastructure.persistence.InMemoryAgentStateRepository;
import com.agentplatform.domain.memory.ShortTermMemory;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        TaskQueue queue = new TaskQueue();

        ToolRegistry toolRegistry = new ToolRegistry();

        LLMClient llm = new OpenAILLMClient();

        toolRegistry.register(new WebSearchTool());
        
        AgentStateRepository stateRepository = new InMemoryAgentStateRepository();

        AgentService agentService = new AgentService(llm, toolRegistry, stateRepository);
        
        Map<String, Agent> agentStore = new HashMap<>();

        Agent agent = new Agent("agent1", "Find latest AI news", new ShortTermMemory());
        agentStore.put(agent.getName(), agent);

        // start worker
        AgentWorker worker = new AgentWorker(queue, agentService, agentStore, stateRepository);
        new Thread(worker).start();

        // submit first task
        queue.submit(new AgentTask(agent.getName(), 1));
    }
}