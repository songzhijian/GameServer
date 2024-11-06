package com.jx.logic.login.handler;

import com.gameengine.system.handler.AbstractClientRequestHandler;
import com.gameengine.system.utils.GameLoggerFactory;
import com.google.protobuf.Message;
import com.jx.message.GameMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginHandler extends AbstractClientRequestHandler {
    private static final Logger logger = GameLoggerFactory.getLogger(LoginHandler.class);

    @Override
    public void handleRequest(Message message) throws Exception {
        GameMsg.LoginReq loginReq = (GameMsg.LoginReq) message;

        logger.info("---------- LoginHandler ----------, token :{}", loginReq.getToken());
    }
}
