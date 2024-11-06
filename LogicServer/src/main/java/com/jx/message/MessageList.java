package com.jx.message;

import com.google.protobuf.Message;

public class MessageList {
    public final static int LoginReq = 1001;
    public final static int LoginResp = 1002;
    public final static int ReconnectReq = 1003;
    public final static int ReconnectResp = 1004;

    public static Message parse(int messageId, byte[] data) {
        try {
            switch (messageId) {
                case LoginReq: return GameMsg.LoginReq.parseFrom(data);
                case LoginResp: return GameMsg.LoginResp.parseFrom(data);
                case ReconnectReq: return GameMsg.ReconnectReq.parseFrom(data);
                case ReconnectResp: return GameMsg.ReconnectResp.parseFrom(data);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
