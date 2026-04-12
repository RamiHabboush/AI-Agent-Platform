package com.agentplatform.memory;

import java.util.*;

public class ShortTermMemory implements Memory {

    private List<String> memory = new ArrayList<>();

    public void add(String entry) {
        memory.add(entry);
    }

    public void clear() {
        memory.clear();
    }

    public String getContext() {
        return String.join("\n", memory);
    }
}