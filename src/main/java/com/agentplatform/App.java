package com.agentplatform;

import com.agentplatform.agent.*;
import com.agentplatform.llm.*;
import com.agentplatform.memory.*;
import com.agentplatform.tools.*;

public class App {

    public static void main(String[] args) {

        // LLM
        LLMClient llm = new SimpleLLMClient();

        // Reasoner
        Reasoner reasoner = new Reasoner(llm);

        // Memory
        Memory memory = new ShortTermMemory();

        // Tools
        ToolRegistry registry = new ToolRegistry();
        registry.registerTool(new WebSearchTool());
        registry.registerTool(new FileTool());

        // Agent
        Agent agent = new Agent(
                "ResearchAgent",
                "Find top AI startups in Europe and summarize them", memory
        );

        // Loop
        AgentLoop loop = new AgentLoop(reasoner, memory, registry);

        loop.run(agent);
    }
}