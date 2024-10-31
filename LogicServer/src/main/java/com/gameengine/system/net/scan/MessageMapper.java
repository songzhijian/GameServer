package com.gameengine.system.net.scan;

import com.google.protobuf.MessageLite;
public interface MessageMapper {
    Short getMsgType(MessageLite msg);

    MessageLite getProto(short msgType);
}
