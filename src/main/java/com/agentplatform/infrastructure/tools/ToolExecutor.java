package com.agentplatform.infrastructure.tools;

public class ToolExecutor {

    private ToolRegistry registry;

    public ToolExecutor(ToolRegistry registry) {
        this.registry = registry;
    }

    public String execute(String name, String input) {

        Tool tool = registry.getTool(name);

        if (tool == null) return "Tool not found";

        return tool.execute(input);
    }
}