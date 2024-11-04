package com.gameengine.system.net.client;


import com.dreamfun.opg.message.GameMsg;
import com.gameengine.system.net.codec.*;
import com.gameengine.system.net.handler.ServerHandler;
import com.gameengine.system.net.scan.MessageMapper;
import com.gameengine.system.net.scan.MessageScanner;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private Logger logger = LoggerFactory.getLogger(Client.class);

    private MessageMapper mapper;
    private ChannelFuture f;


    public Client(MessageScanner msgScanner){

        this.mapper = msgScanner;

        // 创建EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(1000000,0,4,0,4));
                            ch.pipeline().addLast("ProtoDecoder", new ProtoDecoder());
                            ch.pipeline().addLast("FrameEncoder", new LengthFieldPrepender(4));
                            ch.pipeline().addLast("Encoder", new FrameEncoder());
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    }); // 设置Channel初始化器


            // 连接到服务器
            f = b.connect("127.0.0.1", 9091).sync();

//            Thread.sleep(10000);

//            f.channel().writeAndFlush("person.build()!");

            GameMsg.Person1.Builder person = GameMsg.Person1.newBuilder();
            person.setAge(20);
            person.setName("唐僧");
            List<String> list = new ArrayList<>();
            list.add("念紧箍咒");
            list.add("取西经");
            person.addAllHobbies(list);
//            f.channel().writeAndFlush(person.build());

            GameToGatePush push = GameToGatePush.of(1, 1, 0, person.build().toByteArray());
            f.channel().writeAndFlush(push);


            logger.info("--------------- writeAndFlush END ----------------");

            // 等待连接关闭
//            f.channel().closeFuture().sync();
        } catch (Exception e) {
            logger.error("Client test Exception", e);
            throw new RuntimeException(e);
        } finally {
            // 优雅退出，释放所有资源
            group.shutdownGracefully();
        }
    }
}
