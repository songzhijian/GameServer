package com.gameengine.system.net.client;

import com.gameengine.system.utils.GameLoggerFactory;
import com.jx.message.GameMsg;
import com.gameengine.system.net.codec.ClientReq;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = GameLoggerFactory.getLogger(ClientHandler.class);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("Connected to server!");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ClientReq serverResponse = (ClientReq) msg;
        GameMsg.LoginResp loginResp = GameMsg.LoginResp.parseFrom(serverResponse.getBytes());
        logger.info("get client token:{}---", loginResp.getToken());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}


