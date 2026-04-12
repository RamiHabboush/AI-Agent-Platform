package com.agentplatform.llm;

public class LLMRequest {
    //This represents a prompt request sent to the LLM.
    private String prompt;
    private int maxTokens;
    private double temperature;

    public LLMRequest(String prompt, int maxTokens, double temperature){
        this.prompt = prompt;
        this.maxTokens = maxTokens;
        this.temperature = temperature;
    }

    public String getPrompt(){
        return prompt;
    }
    
    public int getMaxtokens(){
        return maxTokens;
    }
    
    public double getTemperature(){
        return temperature;
    }
    
}
