package com.gameengine.system.net.server;

import com.gameengine.system.net.codec.FrameEncoder;
import com.gameengine.system.net.codec.ProtoDecoder;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;

public class GameServerInitializer extends ChannelInitializer<SocketChannel> {
    protected void initChannel(SocketChannel ch) throws Exception {
        int maxRequestMsgSize = 1000000;

        try {
            ch.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(maxRequestMsgSize,0,4,0,4));
            ch.pipeline().addLast("ProtoDecoder", new ProtoDecoder());
            ch.pipeline().addLast("FrameEncoder", new LengthFieldPrepender(4));
            ch.pipeline().addLast("Encoder", new FrameEncoder());
            ch.pipeline().addLast("ServerHandler", new ServerHandler());
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
