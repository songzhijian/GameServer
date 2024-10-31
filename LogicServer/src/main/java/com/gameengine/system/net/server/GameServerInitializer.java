package com.gameengine.system.net.server;

import com.gameengine.system.net.codec.FrameEncoder;
import com.gameengine.system.net.codec.ProtoDecoder;
import com.gameengine.system.net.handler.ServerHandler;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class GameServerInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel ch) throws Exception {
        int maxRequestMsgSize = 1000000;

        ch.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(maxRequestMsgSize,0,4,0,4));
        ch.pipeline().addLast("ProtoDecoder", new ProtoDecoder());
        ch.pipeline().addLast("FrameEncoder", new LengthFieldPrepender(4));
        ch.pipeline().addLast("Encoder", new FrameEncoder());
        ch.pipeline().addLast("ServerHandler", ServerHandler.INSTANCE);
    }
}
