package com.gameengine.system.net;

import com.dreamfun.opg.GameServer;
import com.gameengine.system.net.scan.MessageProcessorScanner;
import com.gameengine.system.net.scan.MessageScanner;
import com.gameengine.system.net.server.NetterServer;
import com.gameengine.system.net.client.Client;

public class TestNetty {

    public static void main(String[] args) throws Exception {
        MessageScanner msgScanner = new MessageScanner();
        msgScanner.scanClasses(null);

//        MessageProcessorScanner processorScanner = new MessageProcessorScanner();
//        processorScanner.scanClasses("com/gameengine/system/net/processor/");
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    GameServer.getInstance().startup();
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();

//        Thread.sleep(5000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Client client = new Client(msgScanner);
            }
        }).start();

        // 客户端发消息

        Thread.sleep(5000);
        System.out.println("--------------- TestNetty END ----------------");
    }
}
