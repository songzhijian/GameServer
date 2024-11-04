package com.gameengine.system.execution;

import java.util.Queue;

public interface ActionQueue {
    ActionQueue getActionQueue();

    void enqueue(Action var1);

    void dequeue(Action var1);

    void clear();

    Queue getQueue();
}

