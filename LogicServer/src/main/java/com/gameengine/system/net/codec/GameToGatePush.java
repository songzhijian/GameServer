package com.gameengine.system.net.codec;

import java.util.Arrays;

public class GameToGatePush {
    private int sessionId;
    private int messageId;
    private int msgSeq;
    private byte[] data;

    public GameToGatePush() {
    }

    public static GameToGatePush of(int sessionId, int messageId, int msgSeq, byte[] data) {
        return new GameToGatePush(sessionId, messageId, msgSeq, data);
    }

    public GameToGatePush(int sessionId, int messageId, int msgSeq, byte[] data) {
        this.sessionId = sessionId;
        this.messageId = messageId;
        this.msgSeq = msgSeq;
        this.data = data;
    }


    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public int getMsgSeq() {
        return msgSeq;
    }

    public void setMsgSeq(int msgSeq) {
        this.msgSeq = msgSeq;
    }

    @Override
    public String toString() {
        return "sessionId:" + sessionId + "|messageId:" + messageId + "|msgSeq:" + msgSeq + "|bytes:" + Arrays.toString(data);
    }
}
