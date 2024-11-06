package com.gameengine.system.handler;

import com.google.protobuf.Message;
import com.gameengine.system.utils.GameLoggerFactory;
import org.slf4j.Logger;

public abstract class AbstractClientRequestHandler implements IClientRequestHandler {
    private static final Logger logger = GameLoggerFactory.getLogger(AbstractClientRequestHandler.class);

    public void handleClientRequest(Message message) {
        try {
            handleRequest(message);
        } catch (Exception e) {

        }
    }

    /**
     * 处理命令
     */
    public abstract void handleRequest(Message message) throws Exception;
}
