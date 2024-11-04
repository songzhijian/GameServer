package com.gameengine.system.net.server;

import com.gameengine.system.AbstractGameCoreService;
import com.gameengine.system.GameCoreServiceType;
import com.gameengine.system.net.codec.PlatformUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.kqueue.KQueueEventLoopGroup;
import io.netty.channel.kqueue.KQueueServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultThreadFactory;

public class ServerNettyService extends AbstractGameCoreService {
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Channel channel;
    private static final ServerNettyService instance = new ServerNettyService();
    public ServerNettyService() {
        super(GameCoreServiceType.NETWORK);
    }
    public static ServerNettyService getInstance() {
        return instance;
    }
    @Override
    protected void initService() throws Exception {

    }

    @Override
    protected void startService() throws Exception {
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
                    .childHandler(new GameServerInitializer())
                    .channel(useEpoll ? PlatformUtil.isLinuxPlatform() ?
                            EpollServerSocketChannel.class : KQueueServerSocketChannel.class : NioServerSocketChannel.class)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .option(ChannelOption.SO_RCVBUF, 10240)
                    .option(ChannelOption.SO_BACKLOG, 6000)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_LINGER, 0)
                    .childOption(ChannelOption.SO_SNDBUF, 20480);

            channel = b.bind(9091).sync().channel();
        } catch (Exception ex) {
            System.exit(1);
        }
    }

    @Override
    protected void stopService() throws Exception {
        try {
            ChannelFuture f = channel.close();
            f.awaitUninterruptibly();
        } finally {
            this.workerGroup.shutdownGracefully();
            this.bossGroup.shutdownGracefully();
        }
    }
}
