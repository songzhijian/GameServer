package com.gameengine.system.net.codec;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.gameengine.system.net.scan.MessageMapper;
import io.netty.buffer.PooledHeapByteBufX;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class ProtocEncoder extends MessageToMessageEncoder<MessageLiteOrBuilder> {

    private MessageMapper mapper;

    public ProtocEncoder(MessageMapper mapper) {
        super();
        this.mapper = mapper;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, MessageLiteOrBuilder msg, List<Object> out) throws Exception {
        try {
            if (msg instanceof MessageLite) {
                int msgType = mapper.getMsgType(((MessageLite) msg));
                out.add(PooledHeapByteBufX.wrappedBuffer(msgType, ((MessageLite) msg)));
                return;
            }
            if (msg instanceof MessageLite.Builder) {
                MessageLite msgLite = ((MessageLite.Builder) msg).build();
                int msgType = mapper.getMsgType(msgLite);

                out.add(PooledHeapByteBufX.wrappedBuffer(msgType, msgLite));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
