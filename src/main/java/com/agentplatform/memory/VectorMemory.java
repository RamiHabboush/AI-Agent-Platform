package com.agentplatform.memory;

import java.util.*;

public class VectorMemory {

    private List<String> documents = new ArrayList<>();

    public void store(String text) {
        documents.add(text);
    }

    public List<String> search(String query) {
        List<String> results = new ArrayList<>();

        for (String doc : documents) {
            if (doc.toLowerCase().contains(query.toLowerCase())) {
                results.add(doc);
            }
        }
        return results;
    }
}