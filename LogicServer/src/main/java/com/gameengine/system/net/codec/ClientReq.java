package com.gameengine.system.net.codec;

import com.google.protobuf.Message;

public class ClientReq {
    private int messageId;

    private int msgSeq;

    private Message msg;

    private byte[] bytes;

    public ClientReq(int messageId, int msgSeq, Message msg) {
        this.messageId = messageId;
        this.msgSeq = msgSeq;
        this.msg = msg;
    }

    public ClientReq(int messageId, int msgSeq, byte[] bytes) {
        this.messageId = messageId;
        this.msgSeq = msgSeq;
        this.bytes = bytes;
    }


    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Message getMsg() {
        return msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    public int getMsgSeq() {
        return msgSeq;
    }

    public void setMsgSeq(int msgSeq) {
        this.msgSeq = msgSeq;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}