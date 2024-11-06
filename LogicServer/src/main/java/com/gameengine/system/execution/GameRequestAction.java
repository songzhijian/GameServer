package com.gameengine.system.execution;

import com.gameengine.system.utils.GameLoggerFactory;
import com.google.protobuf.Message;
import com.jx.logic.GameServer;
import com.jx.message.GameMsg;
import com.gameengine.system.net.codec.GameToGatePush;
import com.jx.message.MessageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameRequestAction extends Action {
    private static final Logger logger = GameLoggerFactory.getLogger(GameRequestAction.class);

    private Request request;

    public GameRequestAction(ActionQueue queue, Request request, long slowRequestTimeoutMilli) {
        super(queue);
        this.request = request;
        this.setSlowRequestMilliSecond(slowRequestTimeoutMilli);
    }

    public void execute() throws Throwable {
        //TODO 执行消息逻辑
        Message message = MessageList.parse(request.getClientReq().getMessageId(), request.getClientReq().getBytes());
        GameServer.getInstance().handleClientRequest(request.getClientReq().getMessageId(), message);
    }

    public void testHandler(Message message){
        GameMsg.LoginReq loginReq = (GameMsg.LoginReq) message;
        loginReq.getToken();
        logger.info("get client token:{}---", loginReq.getToken());

        //测试回传
        GameMsg.LoginResp.Builder resp = GameMsg.LoginResp.newBuilder();
        resp.setToken("success");
        GameToGatePush push = GameToGatePush.of(2, 3, 0, resp.build().toByteArray());
        request.getSession().getChannel().writeAndFlush(push);
        logger.info("server send response end");
    }

    public String toString() {
        return this.request.toString();
    }
}
