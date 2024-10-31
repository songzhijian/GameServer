package com.gameengine.system.net.codec;

public class ProtocCodecUtil {

    public static final boolean HAS_PARSER = true;
    /**
     * 消息分隔符
     */
    public static final short FIRST_TAG = 127;
    /**
     * 消息分割占用符字节数
     */
    public static final int FIRST_TAG_LENGTH = 2;
    /**
     * 消息号占用字节数
     */
    public static final int MSG_TYPE_LENGTH = 2;

    /**
     * 上行消息最大长度
     */
    public static final int UP_MAX_LENGTH = 204800;
}

