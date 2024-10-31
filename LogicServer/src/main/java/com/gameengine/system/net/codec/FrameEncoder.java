package com.gameengine.system.net.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.MessageToByteEncoder;
public class FrameEncoder extends MessageToByteEncoder<GameToGatePush> {

    protected void encode(ChannelHandlerContext ctx, GameToGatePush msg, ByteBuf out) throws Exception {
        out.writeShort(0);
        out.writeInt(msg.getMessageId());
        out.writeInt(msg.getMsgSeq());
        out.writeBytes(msg.getData());
    }
}
