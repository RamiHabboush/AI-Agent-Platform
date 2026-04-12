package com.agentplatform.user;

import java.util.HashMap;
import java.util.Map;

import com.agentplatform.agent.Agent;
import com.agentplatform.agent.AgentManager;

public class UserManager {

    private Map<String, User> users = new HashMap<>();
    private AgentManager agentManager = new AgentManager();

    public void assignAgentToUser(String userId, Agent agent) {
        User user = users.get(userId);
        user.addAgent(agent);
        agentManager.registerAgent(agent);
    }

    public User registerUser(String username, String password) {
        String userId = "user_" + (users.size() + 1);
        User user = new User(userId, username, password);
        users.put(userId, user);
        return user;
    }

    public User login(String username, String password) {
        for (User user : users.values()) {
            if (user.getUsername().equals(username) && user.verifyPassword(password)) {
                return user;
            }
        }
        return null;
    }
}

// This allows multiple users to register, login, and have their own agents.