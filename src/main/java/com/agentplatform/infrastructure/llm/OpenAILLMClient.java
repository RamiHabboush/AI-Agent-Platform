package com.agentplatform.infrastructure.llm;

public class OpenAILLMClient implements LLMClient {

    @Override
    public LLMResponse generate(LLMRequest request) {

        // TEMP MOCK (replace later with real API)
        String output = "TOOL: web_search\nINPUT: latest AI news";

        return new LLMResponse(output);
    }
}