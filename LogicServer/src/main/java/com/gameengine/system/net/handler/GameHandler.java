package com.gameengine.system.net.handler;


import com.dreamfun.opg.GameServer;
import com.google.protobuf.MessageLite;
import com.dreamfun.opg.manager.GameSessionManager;
import com.gameengine.system.net.processor.MsgProcessor;
import com.gameengine.system.net.session.GameSession;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.EventLoopGroup;

import java.util.concurrent.atomic.AtomicInteger;

public class GameHandler extends ChannelInboundHandlerAdapter {
    private static AtomicInteger idCreator = new AtomicInteger(1);

    protected EventLoopGroup[] localGroup;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Connected to client!");
    }

    public GameHandler(EventLoopGroup[] localGroup) {
        this.localGroup = localGroup;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        GameSession gameSession = new GameSession(ctx, idCreator.getAndIncrement());
        GameSessionManager.getInstance().addSession(gameSession);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        GameSession session = GameSession.getGameSession(ctx);
        if(msg instanceof MessageLite){
            long now = System.currentTimeMillis();
            MessageLite lite = (MessageLite)msg;
            short msgType = GameServer.getInstance().getMsgScanner().getMsgType(lite);
            MsgProcessor<MessageLite> processor = GameServer.getInstance().getProcessorScanner().getMsgProcessor(msgType);

            processor.process(session,lite);
        }
        System.out.println("--- channelRead END ---");
    }
}
