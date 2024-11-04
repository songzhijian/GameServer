package com.gameengine.system.execution;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Executor {
    private ThreadPoolExecutor pool;

    public Executor(int corePoolSize, int maxPoolSize, int keepAliveTime, int cacheSize, String prefix) {
        TimeUnit unit = TimeUnit.MINUTES;
        LinkedBlockingQueue workQueue = new LinkedBlockingQueue();
        ActionRejectedExecutionHandler handler = new ActionRejectedExecutionHandler();
        if(prefix == null) {
            prefix = "";
        }

        Executor.Threads threadFactory = new Executor.Threads(prefix);
        this.pool = new ThreadPoolExecutor(corePoolSize, maxPoolSize, (long)keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public void execute(Action action) {
        this.pool.execute(action);
    }

    public void stop() {
        if(!this.pool.isShutdown()) {
            this.pool.shutdown();
        }

    }

    public int getQueueSize() {
        return this.pool.getQueue().size();
    }

    public int getPoolThreadCount() {
        return this.pool.getPoolSize();
    }

    public int getActiveThreadCount() {
        return this.pool.getActiveCount();
    }

    static class Threads implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if(thread.isDaemon()) {
                thread.setDaemon(false);
            }

            if(thread.getPriority() != 5) {
                thread.setPriority(5);
            }

            return thread;
        }

        Threads(String prefix) {
            SecurityManager securitymanager = System.getSecurityManager();
            this.group = securitymanager == null?Thread.currentThread().getThreadGroup():securitymanager.getThreadGroup();
            this.namePrefix = "pool-" + poolNumber.getAndIncrement() + "-" + prefix + "-thread-";
        }
    }
}

