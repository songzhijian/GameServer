package com.gameengine.system.net.client;


import com.gameengine.system.net.codec.ClientProtocDecoder;
import com.gameengine.system.net.codec.ProtocEncoder;
import com.gameengine.system.net.codec.ProtocFrameDecoder;
import com.gameengine.system.net.codec.ProtocLengthFieldEncoder;
import com.dreamfun.opg.message.Person1;
import com.gameengine.system.net.scan.MessageMapper;
import com.gameengine.system.net.scan.MessageScanner;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.ArrayList;
import java.util.List;

public class Client {

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
                            ch.pipeline().addLast(new ProtocFrameDecoder());
                            ch.pipeline().addLast(new ClientProtocDecoder(mapper));

                            ch.pipeline().addLast(new ProtocLengthFieldEncoder());
                            ch.pipeline().addLast(new ProtocEncoder(mapper));
//                            ch.pipeline().addLast(new StringDecoder());
//                            ch.pipeline().addLast(new StringEncoder());
                            ch.pipeline().addLast(new ClientHandler());
                        }
                    }); // 设置Channel初始化器

            // 连接到服务器
            f = b.connect("127.0.0.1", 9091).sync();

            Person1.Builder person = Person1.newBuilder();
            person.setAge(20);
            person.setName("唐僧");
            List<String> list = new ArrayList<>();
            list.add("念紧箍咒");
            list.add("取西经");
            person.addAllHobbies(list);
            f.channel().writeAndFlush(person.build());

            System.out.println("--------------- writeAndFlush END ----------------");

            // 等待连接关闭
//            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 优雅退出，释放所有资源
            group.shutdownGracefully();
        }
    }

    public void sendMsgToServer(){
        Person1.Builder person = Person1.newBuilder();
        person.setAge(20);
        person.setName("唐僧");
        List<String> list = new ArrayList<>();
        list.add("念紧箍咒");
        list.add("取西经");
        person.addAllHobbies(list);
        f.channel().writeAndFlush(person.build());
    }
}
