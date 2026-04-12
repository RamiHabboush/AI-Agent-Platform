package com.agentplatform.infrastructure.llm;

public class LLMResponse {
    //This will store the response returned by the model.
    private String content;

    public LLMResponse(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
    
}
