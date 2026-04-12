package com.agentplatform.agent;

import com.agentplatform.tools.ToolExecutor;

public class Executor {

    private ToolExecutor toolExecutor;

    public Executor(ToolExecutor toolExecutor) {
        this.toolExecutor = toolExecutor;
    }

    public String execute(String tool, String input) {
        return toolExecutor.execute(tool, input);
    }
}