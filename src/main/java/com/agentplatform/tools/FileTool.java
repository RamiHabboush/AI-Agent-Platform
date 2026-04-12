package com.agentplatform.tools;

public class FileTool implements Tool {

    @Override
    public String getName() {
        return "read_file";
    }

    @Override
    public String getDescription() {
        return "Read a file from the system";
    }

    @Override
    public String execute(String input) {
        return "Reading file: " + input + " (simulated)";
    }
}