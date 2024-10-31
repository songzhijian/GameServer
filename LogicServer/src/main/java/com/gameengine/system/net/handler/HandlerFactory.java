package com.gameengine.system.net.handler;

import io.netty.channel.EventLoopGroup;

public abstract class HandlerFactory {

    public abstract GameHandler newInstance();

    protected EventLoopGroup[] localGroup;

    public void setLocalGroup(EventLoopGroup[] localGroup) {
        this.localGroup = localGroup;
    }
}
