package com.agentplatform.llm;

public interface LLMClient {
    //This is the core interface your agents will use.
    public LLMResponse generate(LLMRequest request);
}
