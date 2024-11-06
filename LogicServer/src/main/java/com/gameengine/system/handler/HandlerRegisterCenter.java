package com.gameengine.system.handler;

import com.jx.logic.GameServer;
import com.jx.logic.login.handler.LoginHandler;
import com.jx.logic.login.handler.ReconnectHandler;
import com.jx.message.MessageList;

public class HandlerRegisterCenter {
    public static void register(){
        GameServer.getInstance().addRequestHandler(MessageList.LoginReq, LoginHandler.class);
        GameServer.getInstance().addRequestHandler(MessageList.ReconnectReq, ReconnectHandler.class);
    }
}