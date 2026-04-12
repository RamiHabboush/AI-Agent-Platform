package com.agentplatform.tools;

public interface Tool {

    String getName();

    String getDescription();

    String execute(String input);
}