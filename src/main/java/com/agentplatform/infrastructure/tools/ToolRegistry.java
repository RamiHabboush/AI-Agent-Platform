package com.agentplatform.infrastructure.tools;

import java.util.HashMap;
import java.util.Map;

public class ToolRegistry {

    private Map<String, Tool> tools = new HashMap<>();

    public void register(Tool tool) {
        tools.put(tool.getName(), tool);
    }

    public Tool getTool(String name) {
        return tools.get(name);
    }

    public String describeTools() {
        StringBuilder sb = new StringBuilder();

        for (Tool tool : tools.values()) {
            sb.append(tool.getName())
              .append(": ")
              .append(tool.getDescription())
              .append("\n");
        }

        return sb.toString();
    }

    public String getToolDescriptions() {
        StringBuilder sb = new StringBuilder();

        for (Tool tool : tools.values()) {
            sb.append(tool.getName())
            .append(": ")
            .append(tool.getDescription())
            .append("\n");
        }

        return sb.toString();
    }
}