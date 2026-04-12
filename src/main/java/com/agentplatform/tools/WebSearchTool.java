package com.agentplatform.tools;

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
        return "Results for: " + input + " (simulated search results)";
    }
}