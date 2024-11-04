package com.gameengine.system.execution;

import com.dreamfun.opg.message.GameMsg;
import com.gameengine.system.net.codec.ClientReq;
import com.google.protobuf.Message;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameRequestAction extends Action {
    private static final Logger logger = LoggerFactory.getLogger(OrderedActionQueue.class);

    private Request request;

    public GameRequestAction(ActionQueue queue, Request request, long slowRequestTimeoutMilli) {
        super(queue);
        this.request = request;
        this.setSlowRequestMilliSecond(slowRequestTimeoutMilli);
    }

    public void execute() throws Throwable {
        //TODO 执行消息逻辑
        ClientReq req = request.getClientReq();
        GameMsg.Person1 p = GameMsg.Person1.parseFrom(req.getBytes());
        logger.info("msg:{}---{}---", p.getAge(), p.getName());
//        Message parse = MessageList.parse(messageId, request.getData()); //TODO 搞个MessageList
    }

    public String toString() {
        return this.request.toString();
    }
}
