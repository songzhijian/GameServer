package com.dreamfun.opg.utils;

import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class EventLoopGroupUtil {

    private static boolean epollEnabled = Epoll.isAvailable();

    public static EventLoopGroup createIoEventLoopGroup(int threadNum,
                                                        String threadName) {
        if (epollEnabled) {
            return new EpollEventLoopGroup(threadNum, new NamedThreadFactory(
                    threadName));
        } else {
            return new NioEventLoopGroup(threadNum, new NamedThreadFactory(
                    threadName));
        }
    }

    public static EventLoopGroup createLogicEventLoopGroup(int threadNum,
                                                           String threadName) {
        return new DefaultEventLoopGroup(threadNum, new NamedThreadFactory(
                threadName));
    }

    public static Class<? extends SocketChannel> getClientSocketChannelClass() {
        return epollEnabled ? EpollSocketChannel.class : NioSocketChannel.class;
    }

    public static Class<? extends ServerSocketChannel> getServerSocketChannelClass() {
        return epollEnabled ? EpollServerSocketChannel.class
                : NioServerSocketChannel.class;
    }
}
