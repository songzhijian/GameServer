package com.gameengine.system.handler;

import com.google.protobuf.Message;

public interface IClientRequestHandler {
    void handleClientRequest(Message message) throws Exception;
}
