package com.gameengine.system.net.codec;

import com.google.protobuf.MessageLiteOrBuilder;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class GameSession {
    public static final AttributeKey<GameSession> SESSION_KEY = AttributeKey.newInstance("GAME_SESSION");


    private ChannelHandlerContext ctx;

    private int id;

    private String remoteIp="";

    private long createTime;

    private String str;

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemoteIp() {
        return remoteIp;
    }

    public void setRemoteIp(String remoteIp) {
        this.remoteIp = remoteIp;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public GameSession (ChannelHandlerContext ctx, int id){
        this.ctx = ctx;
        this.id = id;
        this.ctx.channel().attr(SESSION_KEY).set(this);

        try {
            SocketChannel socketChannel = (SocketChannel)(ctx.channel());
            if(socketChannel.isOpen()) {
                InetSocketAddress remoteAddress = socketChannel.remoteAddress();
                InetAddress address = remoteAddress.getAddress();
                remoteIp=address.getHostAddress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.createTime = System.currentTimeMillis();
        this.str = "GameIOSession [id=" + id + "]";
    }
    public static GameSession getGameSession(ChannelHandlerContext ctx){
        Attribute<GameSession> attr = ctx.channel().attr(SESSION_KEY);
        return attr.get();
    }


    public void sendMsg(MessageLiteOrBuilder msg) {
        if (ctx != null) {
            ChannelFuture future = ctx.write(msg, ctx.voidPromise());
            if (!future.isVoid()) {
                final String cname = msg.getClass().getSimpleName();
                future.addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        if (!future.isSuccess()) {
                            future.cause().printStackTrace();
                        }
                    }
                });
            }
        }
    }

    public void flushMsg() {
        if (ctx != null) {
            ctx.flush();
        }
    }



}
