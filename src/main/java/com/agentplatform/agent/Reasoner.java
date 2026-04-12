package com.agentplatform.agent;

import com.agentplatform.llm.*;

public class Reasoner {

    private LLMClient llm;

    public Reasoner(LLMClient llm) {
        this.llm = llm;
    }

    public String thinkNextStep(String goal, String memory, String tools) {

        String prompt =
                "You are an AI agent.\n\n" +
                "Goal:\n" + goal + "\n\n" +
                "Memory:\n" + memory + "\n\n" +
                "Tools:\n" + tools + "\n\n" +
                "Respond ONLY in format:\n" +
                "TOOL: tool_name\n" +
                "INPUT: input\n" +
                "OR\nDONE";

        return llm.generate(new LLMRequest(prompt, 400, 0.7)).getContent().trim();
    }
}