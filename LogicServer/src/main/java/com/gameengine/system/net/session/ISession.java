package com.gameengine.system.net.session;

import com.google.common.base.Optional;
import io.netty.channel.Channel;

public interface ISession {
    int getSessionId();

    Channel getChannel();

    String getAddress();

    Object getProperty(String var1);

    void setProperty(String var1, Object var2);

    void removeProperty(String var1);

    Optional writeResponse(Object var1);

    String getFullIpAddress();

    boolean isTimeout();

    long getLastReadTime();

    void updateLastReadTime();

    String getReconnectionToken();

    void setReconnectionToken(String var1);

    void setChannel(Channel var1);

    long getCreationTime();

    void setCreationTime(long var1);

    void addReadBytes(int var1);

    void addSendBytes(int var1);

    long getReadBytes();

    long getSendBytes();

    TokenModel getTokenModel();

    void bindTokenModel(TokenModel tokenModel);
    void setTokenModel(TokenModel tokenModel);

    int NOT_BIND_TOKEN = 0;
    int BINDING_TOKEN = -1;
    int BIND_FINISH = 1;
    int getTokenBindState();

    void setTokenBindState(int tokenBindState);
}

