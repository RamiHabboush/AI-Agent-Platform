package com.agentplatform.infrastructure.llm;

public class LLMRequest {

    private String prompt;
    private int maxTokens;
    private double temperature;

    public LLMRequest(String prompt, int maxTokens, double temperature) {
        this.prompt = prompt;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
    }

    public String getPrompt() {
        return prompt;
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    public double getTemperature() {
        return temperature;
    }
}