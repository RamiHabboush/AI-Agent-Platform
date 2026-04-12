package com.agentplatform.infrastructure.queue;

import com.agentplatform.application.AgentTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaskQueue {

    private BlockingQueue<AgentTask> queue = new LinkedBlockingQueue<>();

    public void submit(AgentTask task) {
        queue.offer(task);
    }

    public AgentTask take() throws InterruptedException {
        return queue.take();
    }
}