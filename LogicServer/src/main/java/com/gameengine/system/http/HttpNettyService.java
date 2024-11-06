package com.gameengine.system.http;

import com.gameengine.system.net.codec.PlatformUtil;
import com.gameengine.system.service.AbstractGameCoreService;
import com.gameengine.system.service.GameCoreServiceType;
import com.gameengine.system.utils.GameLoggerFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.kqueue.KQueueEventLoopGroup;
import io.netty.channel.kqueue.KQueueServerSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.concurrent.DefaultThreadFactory;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class HttpNettyService extends AbstractGameCoreService {
    private static final Logger logger = GameLoggerFactory.getLogger(HttpNettyService.class);

    private EventLoopGroup parentGroup;
    private EventLoopGroup childGroup;

    private static final HttpNettyService instance = new HttpNettyService();
    public static HttpNettyService getInstance() {
        return instance;
    }

    public HttpNettyService() {
        super(GameCoreServiceType.HTTP);
    }

    @Override
    protected void initService() {

    }

    @Override
    protected void startService() {
        boolean useEpoll = PlatformUtil.useEpoll();
        if (useEpoll) {
            if (PlatformUtil.isLinuxPlatform()) {
                this.parentGroup = new EpollEventLoopGroup(new DefaultThreadFactory("NettyHttpServer-parentGroup"));
                this.childGroup = new EpollEventLoopGroup(new DefaultThreadFactory("NettyHttpServer-childGroup"));
            } else {
                this.parentGroup = new KQueueEventLoopGroup(new DefaultThreadFactory("NettyHttpServer-parentGroup"));
                this.childGroup = new KQueueEventLoopGroup(new DefaultThreadFactory("NettyHttpServer-childGroup"));
            }

        } else {
            this.parentGroup = new NioEventLoopGroup(new DefaultThreadFactory("NettyHttpServer-parentGroup"));
            this.childGroup = new NioEventLoopGroup(new DefaultThreadFactory("NettyHttpServer-childGroup"));
        }

        try {
            ServerBootstrap server = new ServerBootstrap();
            // 1. 绑定两个线程组分别用来处理客户端通道的accept和读写时间
            server.group(parentGroup, childGroup)
                    // 2. 绑定服务端通道NioServerSocketChannel
                    .channel(useEpoll ? PlatformUtil.isLinuxPlatform() ?
                            EpollServerSocketChannel.class : KQueueServerSocketChannel.class : NioServerSocketChannel.class)
                    // 3. 给读写事件的线程通道绑定handler去真正处理读写
                    // ChannelInitializer初始化通道SocketChannel
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(@NotNull SocketChannel socketChannel) throws Exception {
                            // 请求解码器
                            socketChannel.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                            // 将HTTP消息的多个部分合成一条完整的HTTP消息
                            socketChannel.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65535));
                            // 响应转码器
                            socketChannel.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                            // 解决大码流的问题，ChunkedWriteHandler：向客户端发送HTML5文件
                            socketChannel.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                            // 自定义处理handler
                            socketChannel.pipeline().addLast("http-server", new NettyHttpServerHandler());
                        }
                    });
            // 4. 监听端口（服务器host和port端口），同步返回
            // ChannelFuture future = server.bind(inetHost, this.inetPort).sync();
            logger.info("Netty-http服务器已启动");

            Channel channel = server.bind(8080).sync().channel();

            // 当通道关闭时继续向后执行，这是一个阻塞方法
//            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void stopService() {
        childGroup.shutdownGracefully();
        parentGroup.shutdownGracefully();
    }

}
