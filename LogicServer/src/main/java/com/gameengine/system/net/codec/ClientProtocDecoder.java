package com.gameengine.system.net.codec;


import com.google.protobuf.MessageLite;
import com.gameengine.system.net.scan.MessageMapper;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class ClientProtocDecoder extends MessageToMessageDecoder<ByteBuf> {

    private MessageMapper mapper;

    public ClientProtocDecoder(MessageMapper mapper){
        super();
        this.mapper = mapper;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        short msgType = msg.readShort();
        try {
            MessageLite prototype = mapper.getProto(msgType);
            byte[] array;
            int offset;
            int length = msg.readableBytes();
            if (msg.hasArray()) {
                array = msg.array();
                offset = msg.arrayOffset() + msg.readerIndex();
            } else {
                array = new byte[length];
                msg.getBytes(msg.readerIndex(), array, 0, length);
                offset = 0;
            }

            if (ProtocCodecUtil.HAS_PARSER) {
                out.add(prototype.getParserForType().parseFrom(array, offset, length));
            } else {
                out.add(prototype.newBuilderForType().mergeFrom(array, offset, length).build());
            }

        } catch (Exception e) {

        }
    }
}
