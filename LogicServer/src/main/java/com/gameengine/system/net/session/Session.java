package com.gameengine.system.net.session;

import io.netty.channel.socket.SocketChannel;
import com.google.common.base.Optional;
import io.netty.channel.Channel;
import java.net.InetSocketAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Session extends AbstractSession {
    private static Logger logger = LoggerFactory.getLogger(Session.class);
    private SocketChannel channel;

    private volatile TokenModel tokenModel;

    private volatile int tokenBindState = ISession.NOT_BIND_TOKEN;

    public Session(SocketChannel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public String getAddress() {
        return this.channel.remoteAddress().getAddress().getHostAddress();
    }

    public String getFullIpAddress() {
        InetSocketAddress socketAddress = this.channel.remoteAddress();
        return socketAddress.getAddress().getHostAddress() + ":" + socketAddress.getPort();
    }

    public void setChannel(Channel channel) {
        this.channel = (SocketChannel)channel;
    }

    public TokenModel getTokenModel() {
        return tokenModel;
    }

    public void setTokenModel(TokenModel tokenModel) {
        this.tokenModel = tokenModel;
    }

    @Override
    public void bindTokenModel(TokenModel tokenModel) {
        this.tokenModel = tokenModel;
//        SessionGateManager.INSTANCE.putTokenSession(this);
        setTokenBindState(ISession.BIND_FINISH);
    }

    public int getTokenBindState() {
        return tokenBindState;
    }

    public void setTokenBindState(int tokenBindState) {
        this.tokenBindState = tokenBindState;
    }

    public Optional writeResponse(Object msg) {
        return Optional.absent();
    }

    public String toString() {
        return "id: " + this.getSessionId() + ", ip: " + this.getFullIpAddress();
    }
}