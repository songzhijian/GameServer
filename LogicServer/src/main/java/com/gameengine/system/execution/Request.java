package com.gameengine.system.execution;

import com.gameengine.system.net.codec.ClientReq;
import com.gameengine.system.net.session.ISession;

import java.util.HashMap;

public class Request {
    private short id;
    private ISession session;
    private ClientReq clientReq;
    private long receiveTime;
    private long handleStartTime;

    public Request(ISession session) {
        this.session = session;
        this.receiveTime = System.currentTimeMillis();
    }

    public Request(ISession session, ClientReq clientReq) {
        this.receiveTime = System.currentTimeMillis();
        this.session = session;
        this.clientReq = clientReq;
    }

    public long getReceiveTime() {
        return this.receiveTime;
    }

    public short getId() {
        return this.id;
    }

    public ClientReq getClientReq(){
        return this.clientReq;
    }

    public ISession getSession() {
        return this.session;
    }

    public void setHandleStartTime(long handleStartTime) {
        this.handleStartTime = handleStartTime;
    }

    public String stat() {
        return String.format("wait cost time %d, handle cost time %d",
                new Object[]{Long.valueOf(this.handleStartTime - this.receiveTime),
                        Long.valueOf(System.currentTimeMillis() - this.handleStartTime)});
    }
}

