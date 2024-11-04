package com.gameengine.system.net.codec;

import com.gameengine.system.net.server.FrameCompressor;
import com.gameengine.system.net.server.GameFrameCompressor;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class ProtoDecoder extends MessageToMessageDecoder<ByteBuf> {
    private static final FrameCompressor COMPRESSOR = new GameFrameCompressor();

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List out) throws Exception {

        short magic = msg.readShort();

        int msgId = msg.readInt();
        int msgSeq = msg.readInt();
        int count = msg.readableBytes();
        byte[] data = new byte[count];
        msg.readBytes(data);

        out.add(new ClientReq(msgId, msgSeq, data));

    }
}
