package com.gameengine.system.net.codec;

import io.netty.channel.epoll.Epoll;
import io.netty.channel.kqueue.KQueue;
public class PlatformUtil {
    public static final String OS_NAME = System.getProperty("os.name", "");

    private static boolean isLinuxPlatform = false;
    private static boolean isWindowsPlatform = false;

    private static boolean isMacPlatform = false;

    static {
        System.out.println("OsName = " + OS_NAME);
        if (OS_NAME.toLowerCase().contains("linux")) {
            isLinuxPlatform = true;
        } else if (OS_NAME.toLowerCase().contains("windows")) {
            isWindowsPlatform = true;
        } else if (OS_NAME.toLowerCase().contains("mac")) {
            isMacPlatform = true;
        }

    }

    public static boolean isWindowsPlatform() {
        return isWindowsPlatform;
    }

    public static boolean isLinuxPlatform() {
        return isLinuxPlatform;
    }

    public static boolean isMacPlatform() {
        return isMacPlatform;
    }

    public static boolean useEpoll() {
        return (isLinuxPlatform() && Epoll.isAvailable()) || (isMacPlatform() && KQueue.isAvailable());
    }
}