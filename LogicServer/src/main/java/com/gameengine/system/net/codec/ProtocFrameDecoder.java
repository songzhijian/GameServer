package com.gameengine.system.net.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ProtocFrameDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        in.markReaderIndex();
        if (!in.isReadable()) {
            in.resetReaderIndex();
            return;
        }
        if (in.readableBytes() < 6) {
            in.resetReaderIndex();
            return;
        }
        short tag = in.readShort();
        if(tag != ProtocCodecUtil.FIRST_TAG) {
            in.clear();
            ctx.close();
            ctx.disconnect();
            return ;
        }

        int length = in.readInt();
        if(length > ProtocCodecUtil.UP_MAX_LENGTH) {
            in.clear();
            ctx.close();
            ctx.disconnect();
            return;
        }
        if (in.readableBytes() < length) {
            in.resetReaderIndex();
        } else {
            out.add(in.readBytes(length));
        }

    }
}
