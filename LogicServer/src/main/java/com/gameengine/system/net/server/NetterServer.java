package com.gameengine.system.net.server;


import com.gameengine.system.net.codec.ClientProtocDecoder;
import com.gameengine.system.net.codec.ProtocEncoder;
import com.gameengine.system.net.codec.ProtocFrameDecoder;
import com.gameengine.system.net.codec.ProtocLengthFieldEncoder;
import com.gameengine.system.net.handler.GameHandler;
import com.gameengine.system.net.handler.HandlerFactory;
import com.gameengine.system.net.scan.MessageMapper;
import com.gameengine.system.net.scan.MessageScanner;

import com.dreamfun.opg.utils.EventLoopGroupUtil;
import com.dreamfun.opg.utils.NamedThreadFactory;
import com.dreamfun.opg.utils.ThreadNameUtils;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NetterServer {


    private EventLoopGroup bossGroup;

    private EventLoopGroup workerGroup;

    private EventLoopGroup[] localGroup;

    private HandlerFactory handlerFactory;

    private EventLoopGroup logicGroup;

    private MessageMapper mapper;

    private boolean listening = false;


    public NetterServer(MessageScanner msgScanner, int port) {
        this.logicGroup = new DefaultEventLoopGroup(120, new NamedThreadFactory(ThreadNameUtils.GAME_WORK_THREAD));
        this.handlerFactory = new HandlerFactory() {
            @Override
            public GameHandler newInstance() {
                return new GameHandler(localGroup);
            }
        };
        this.mapper = msgScanner;

        if (port <= 0) {
            throw new IllegalArgumentException("端口号错误" + port);
        }

        bossGroup = EventLoopGroupUtil.createIoEventLoopGroup(1, ThreadNameUtils.BOSS_GROUP_THREAD);// 1线程
        workerGroup = EventLoopGroupUtil.createIoEventLoopGroup(8, ThreadNameUtils.WORKER_GROUP_THREAD);// cpu核数*2 个线程

        localGroup = new EventLoopGroup[]{
                new DefaultEventLoopGroup(10, new NamedThreadFactory(ThreadNameUtils.LOGIN_QUEUE_THREAD + "0_")),
                new DefaultEventLoopGroup(10, new NamedThreadFactory(ThreadNameUtils.LOGIN_QUEUE_THREAD + "1_")),
                new DefaultEventLoopGroup(10, new NamedThreadFactory(ThreadNameUtils.LOGIN_QUEUE_THREAD + "2_")),
        };
        handlerFactory.setLocalGroup(localGroup);

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(EventLoopGroupUtil.getServerSocketChannelClass())
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .option(ChannelOption.SO_RCVBUF, 10240)
                    .option(ChannelOption.SO_BACKLOG, 6000)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_LINGER, 0)
                    .childOption(ChannelOption.SO_SNDBUF, 20480)

                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            if (!checkConnectAttack(ch)) {
                                return;
                            }
                            ChannelPipeline pipeline = ch.pipeline();
                            // 测试
//                            ch.pipeline().addLast(new StringDecoder());
//                            ch.pipeline().addLast(new StringEncoder());
                            pipeline.addLast(new ProtocFrameDecoder());
                            pipeline.addLast(new ClientProtocDecoder(mapper));

                            pipeline.addLast(new ProtocLengthFieldEncoder());
                            pipeline.addLast(new ProtocEncoder(mapper));

                            pipeline.addLast(logicGroup, handlerFactory.newInstance());
                        }
                    });
            listening = true;

            ChannelFuture f = b.bind(port).sync();

//            logger.error("开启监听服务成功,端口: " + workerGroup);
        } catch (Exception ex) {
//            logger.error("{}端口开启监听服务失败，退出程序", listenPort, ex);
            ex.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * 检测是否有连接攻击
     *
     * @param ch
     * @return
     */
    private boolean checkConnectAttack(SocketChannel ch) {
        return true;
    }


}
