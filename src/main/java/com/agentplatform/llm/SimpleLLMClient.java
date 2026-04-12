package com.agentplatform.llm;

import com.agentplatform.infrastructure.llm.*;

public class SimpleLLMClient implements LLMClient {

    @Override
    public LLMResponse generate(LLMRequest request) {

        String prompt = request.getPrompt();

        if (!prompt.contains("Step 1")) {
            return new LLMResponse("web_search: AI startups Europe");
        }

        if (prompt.contains("web_search") && !prompt.contains("summarize")) {
            return new LLMResponse("web_search: summarize startups");
        }

        return new LLMResponse("DONE");
    }
}