package com.agentplatform.memory;

public interface Memory {
    void add(String entry);
    String getContext();
    void clear();
}