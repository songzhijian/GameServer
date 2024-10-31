package com.gameengine.system.net.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ProtocLengthFieldEncoder extends MessageToByteEncoder<ByteBuf> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception {
        int bodyLen = msg.readableBytes();
        out.ensureWritable(ProtocCodecUtil.FIRST_TAG_LENGTH + 4 + bodyLen);
        out.writeShort(ProtocCodecUtil.FIRST_TAG);
        out.writeInt(bodyLen);
        out.writeBytes(msg, msg.readerIndex(), bodyLen);
    }
}
