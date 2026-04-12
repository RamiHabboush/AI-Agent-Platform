package com.agentplatform.user;

import java.util.ArrayList;
import java.util.List;

import com.agentplatform.agent.Agent;

public class User {
    private String userId;
    private String username;
    private String password; // For demo; in production hash this
    private List<Agent> agents = new ArrayList<>();

    public User(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public boolean verifyPassword(String pw) {
        return this.password.equals(pw);
    }
}
