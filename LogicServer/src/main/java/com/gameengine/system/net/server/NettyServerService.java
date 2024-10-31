package com.gameengine.system.net.server;

import com.dreamfun.opg.utils.EventLoopGroupUtil;
import com.gameengine.system.net.codec.PlatformUtil;
import com.google.common.base.Joiner;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.kqueue.KQueueEventLoopGroup;
import io.netty.channel.kqueue.KQueueServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;
import java.util.ArrayList;
import java.util.List;

public class NettyServerService {
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;

    public void startService(int port) {
        boolean useEpoll = PlatformUtil.useEpoll();
        if (useEpoll) {
            if (PlatformUtil.isLinuxPlatform()) {
                this.bossGroup = new EpollEventLoopGroup(new DefaultThreadFactory("GateNettyService-bossGroup"));
                this.workerGroup = new EpollEventLoopGroup(new DefaultThreadFactory("GateNettyService-workerGroup"));
            } else {
                this.bossGroup = new KQueueEventLoopGroup(new DefaultThreadFactory("GateNettyService-bossGroup"));
                this.workerGroup = new KQueueEventLoopGroup(new DefaultThreadFactory("GateNettyService-workerGroup"));
            }
        } else {
            bossGroup = new NioEventLoopGroup(new DefaultThreadFactory("GateNettyService-bossGroup"));
            workerGroup = new NioEventLoopGroup(new DefaultThreadFactory("GateNettyService-workerGroup"));
        }

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
                    .childHandler(new GameServerInitializer());

            Channel f = b.bind(port).sync().channel();

        } catch (Exception ex) {
            System.exit(1);
        }

    }
}
