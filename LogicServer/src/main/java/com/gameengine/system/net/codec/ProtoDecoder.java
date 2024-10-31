package com.gameengine.system.net.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class ProtoDecoder extends MessageToMessageDecoder<ByteBuf> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List out) throws Exception {

        int msgId = msg.readInt();
        int msgSeq = msg.readInt();
        int count = msg.readableBytes();
        byte[] data = new byte[count];
        msg.readBytes(data);

        out.add(new ClientReq(msgId, msgSeq, data));

    }
}
