package com.agentplatform.memory;

import java.io.*;
import java.util.*;

public class PersistentMemory implements Memory {

    private File file;

    public PersistentMemory(String filename) {
        this.file = new File(filename);
    }

    public void add(String entry) {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(entry + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getContext() {
        try {
            return new String(java.nio.file.Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            return "";
        }
    }

    public void clear() {
        try {
            new FileWriter(file, false).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}