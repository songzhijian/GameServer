package com.jx.logic.login.handler;

import com.gameengine.system.handler.AbstractClientRequestHandler;
import com.gameengine.system.utils.GameLoggerFactory;
import com.google.protobuf.Message;
import com.jx.message.GameMsg;
import org.slf4j.Logger;

public class ReconnectHandler extends AbstractClientRequestHandler {
    private static final Logger logger = GameLoggerFactory.getLogger(ReconnectHandler.class);
    @Override
    public void handleRequest(Message message) throws Exception {
        GameMsg.ReconnectReq reconnectReq = (GameMsg.ReconnectReq) message;

        logger.info("---------- ReconnectHandler ----------, token :{}", reconnectReq.getToken());
    }
}
