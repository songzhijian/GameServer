package com.gameengine.system.net.server;

public interface FrameCompressor {
    byte[] compress(byte[] var1) throws Exception;

    byte[] uncompress(byte[] var1) throws Exception;
}
