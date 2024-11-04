package com.gameengine.system.net.session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractSession implements ISession {
    private static final AtomicInteger SESSION_ID_GENERATOR = new AtomicInteger(0);
    private final int sessionId = newSessionId();
    private String reconnectionToken;
    protected Map<String, Object> properties = new ConcurrentHashMap<>();
    private long lastReadTime;
    protected long createTime;
    private long readBytes;
    private long sendBytes;
    protected String address;
    public static volatile AtomicLong totalRead = new AtomicLong(0L);
    public static volatile AtomicLong totalSend = new AtomicLong(0L);

    private static int newSessionId() {
        return SESSION_ID_GENERATOR.incrementAndGet();
    }

    public AbstractSession() {
        long currTime = System.currentTimeMillis();
        this.lastReadTime = currTime;
        this.reconnectionToken = "---";
        this.setCreationTime(currTime);
    }

    public int getSessionId() {
        return this.sessionId;
    }

    public Object getProperty(String key) {
        return this.properties.get(key);
    }

    public void setProperty(String key, Object property) {
        this.properties.put(key, property);
    }

    public void removeProperty(String key) {
        this.properties.remove(key);
    }

    public boolean isTimeout() {
        return System.currentTimeMillis() - this.lastReadTime > (long)(300 * 1000);//TODO
    }

    public void updateLastReadTime() {
        this.lastReadTime = System.currentTimeMillis();
    }

    public long getLastReadTime() {
        return this.lastReadTime;
    }

    public void setReconnectionToken(String sessionToken) {
        this.reconnectionToken = sessionToken;
    }

    public String getReconnectionToken() {
        return this.reconnectionToken;
    }

    public long getCreationTime() {
        return this.createTime;
    }

    public void setCreationTime(long creationTime) {
        this.createTime = creationTime;
    }

    public void addReadBytes(int len) {
        this.readBytes += len;
        totalRead.addAndGet(len);
    }

    public void addSendBytes(int len) {
        this.sendBytes += len;
        totalSend.addAndGet(len);
    }

    public long getReadBytes() {
        return this.readBytes;
    }

    public long getSendBytes() {
        return this.sendBytes;
    }

    public void setAddress(String val) {
        address = val;
    }
}

