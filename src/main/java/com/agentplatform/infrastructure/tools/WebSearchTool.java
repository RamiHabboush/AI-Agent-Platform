package com.agentplatform.infrastructure.tools;

public class WebSearchTool implements Tool {

    @Override
    public String getName() {
        return "web_search";
    }

    @Override
    public String getDescription() {
        return "Search the web for information";
    }

    @Override
    public String execute(String input) {
        return "Simulated web result for: " + input;
    }
}