package com.gameengine.system.net.server;

import com.gameengine.system.utils.ByteUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
public class GameFrameCompressor implements FrameCompressor {
    public final int MAX_SIZE_FOR_COMPRESSION = 4*1024*1024;
    //   private static final int MAX_LOOP_COUNT = 5000;
    private final int compressionBufferSize = 2048;

    public byte[] compress(byte[] data) throws Exception {
        int readableBytes = data.length;
        if(readableBytes > MAX_SIZE_FOR_COMPRESSION) {
            return data;
        } else {
            Deflater compressor = null;
            ByteArrayOutputStream bos = null;

            byte[] var8;
            try {
                compressor = new Deflater();
                compressor.setInput(data);
                compressor.finish();
                bos = new ByteArrayOutputStream(data.length);
                byte[] buf = new byte[compressionBufferSize];
//            int loopCount = 0;

                while(!compressor.finished()) {
                    int count = compressor.deflate(buf);
                    bos.write(buf, 0, count);
                }

//            if(loopCount >= MAX_LOOP_COUNT) {
//               throw new COKFrameException(String.format("compression loop count reach max [%d]. data detail: %s", new Object[]{Integer.valueOf(1000), ByteUtils.fullHexDump(data)}));
//            }

                var8 = bos.toByteArray();
            } finally {
                if(compressor != null) {
                    compressor.end();
                }

                if(bos != null) {
                    bos.close();
                }

            }

            return var8;
        }
    }

    public byte[] uncompress(byte[] data) throws Exception {

        Inflater inflater = null;
        ByteArrayOutputStream bos = null;

        byte[] var7;
        try {
            inflater = new Inflater();
            inflater.setInput(data);
            bos = new ByteArrayOutputStream(data.length);
            byte[] buf = new byte[512];
            int loopCount = 0;

            while(!inflater.finished() && loopCount++ < 1000) {
                int count = inflater.inflate(buf);
                if(count < 1 && inflater.needsInput()) {
                    throw new IOException("Bad Compression Format! Packet will be dropped");
                }

                bos.write(buf, 0, count);
            }

            if(loopCount >= 1000) {
                throw new RuntimeException(String.format("decompression loop count reach max [%d]. data detail: %s", new Object[]{Integer.valueOf(1000), ByteUtils.fullHexDump(data)}));
            }

            var7 = bos.toByteArray();
        } finally {
            if(inflater != null) {
                inflater.end();
            }

            if(bos != null) {
                bos.close();
            }

        }

        return var7;
    }
}

