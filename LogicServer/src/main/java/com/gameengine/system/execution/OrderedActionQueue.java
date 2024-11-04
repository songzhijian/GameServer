package com.gameengine.system.execution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class OrderedActionQueue implements ActionQueue {
    private static final Logger logger = LoggerFactory.getLogger(OrderedActionQueue.class);
    private Queue queue;
    private Executor executor;

    public OrderedActionQueue(Executor executor) {
        this.executor = executor;
        this.queue = new LinkedList();
    }

    public OrderedActionQueue(Executor executor, Queue queue) {
        this.executor = executor;
        this.queue = queue;
    }

    public ActionQueue getActionQueue() {
        return this;
    }

    public Queue getQueue() {
        return this.queue;
    }

    public void enqueue(Action action) {
        boolean canExec = false;
        Queue var3 = this.queue;
        synchronized(this.queue) {
            this.queue.add(action);
            if(this.queue.size() == 1) {
                canExec = true;
            } else if(this.queue.size() > 1000) {
                logger.warn(action.toString() + " queue size : " + this.queue.size());
            }
        }
        if(canExec) {
            this.executor.execute(action);
        }

    }

    public void dequeue(Action action) {
        Action nextAction = null;
        Queue var3 = this.queue;
        synchronized(this.queue) {
            if(this.queue.size() == 0) {
                logger.error("queue.size() is 0.");
                return;
            }
            Action temp = (Action)this.queue.remove();
            if(temp != action) {
                logger.error("action queue error. temp " + temp.toString() + ", action : " + action.toString());
            }

            if(this.queue.size() != 0) {
                nextAction = (Action)this.queue.peek();
            }
        }
        if(nextAction != null) {
            this.executor.execute(nextAction);
        }
    }

    public void clear() {
        Queue var1 = this.queue;
        synchronized(this.queue) {
            this.queue.clear();
        }
    }
}

