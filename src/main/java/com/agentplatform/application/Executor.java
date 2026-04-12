package com.agentplatform.application;

import com.agentplatform.infrastructure.tools.Tool;
import com.agentplatform.infrastructure.tools.ToolRegistry;

public class Executor {

    private ToolRegistry toolRegistry;

    public Executor(ToolRegistry toolRegistry) {
        this.toolRegistry = toolRegistry;
    }

    public String execute(String toolName, String input) {
        Tool tool = toolRegistry.getTool(toolName);
        if (tool == null) return "Tool not found";

        return tool.execute(input);
    }
}