package com.agentplatform.application;

import com.agentplatform.infrastructure.llm.*;
import com.agentplatform.infrastructure.tools.ToolRegistry;

public class Reasoner {

    private LLMClient llm;
    private ToolRegistry toolRegistry;

    public Reasoner(LLMClient llm, ToolRegistry toolRegistry) {
        this.llm = llm;
        this.toolRegistry = toolRegistry;
    }

    public String thinkNextStep(String goal, String memory) {

        String prompt = "You are an autonomous agent.\n\n" +
                "GOAL:\n" + goal + "\n\n" +
                "MEMORY:\n" + memory + "\n\n" +
                "TOOLS:\n" + toolRegistry.getToolDescriptions() + "\n\n" +
                "Respond ONLY in format:\n" +
                "TOOL: tool_name\nINPUT: input\nOR\nDONE";

        LLMResponse response = llm.generate(
            new LLMRequest(prompt, 200, 0.7)
        );
        
        return response.getContent();
    }
}