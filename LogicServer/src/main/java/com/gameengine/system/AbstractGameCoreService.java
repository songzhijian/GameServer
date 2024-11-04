package com.gameengine.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractGameCoreService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private boolean initialized;
    private volatile boolean started;
    protected GameCoreServiceType serviceType;

    public AbstractGameCoreService(GameCoreServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void init() throws Exception {
        if(this.initialized) {
            throw new Exception(this.getName() + " already initialized");
        } else {
            this.initService();
            this.logger.info("{} initialized", this.getName());
            this.initialized = true;
        }
    }

    public void start() throws Exception {
        if(!this.initialized) {
            throw new Exception(this.getName() + " has not initialized");
        } else if(this.started) {
            throw new Exception(this.getName() + " already started");
        } else {
            this.startService();
            this.logger.info("{} started", this.getName());
            this.started = true;
        }
    }

    public void stop() throws Exception {
        if(!this.started) {
            throw new Exception(this.getName() + " has not started");
        } else {
            this.stopService();
            this.logger.info("{} stopped", this.getName());
            this.started = false;
        }
    }

    public void restart() throws Exception {
        this.stop();
        this.start();
    }

    protected abstract void initService() throws Exception;

    protected abstract void startService() throws Exception;

    protected abstract void stopService() throws Exception;

    public String getName() {
        return "core service " + this.serviceType.name();
    }

    public GameCoreServiceType getServiceType() {
        return this.serviceType;
    }


    public ThreadFactory nameFormatBuild(String nameFormat){
        final ThreadFactory backingThreadFactory = Executors.defaultThreadFactory();
        final AtomicLong count = (nameFormat != null) ? new AtomicLong(0) : null;
        return new ThreadFactory() {
            @Override public Thread newThread(Runnable runnable) {
                Thread thread = backingThreadFactory.newThread(runnable);
                if (nameFormat != null) {
                    thread.setName(format(nameFormat, count.getAndIncrement()));
                }
                return thread;
            }
        };
    }

    private String format(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }
}

