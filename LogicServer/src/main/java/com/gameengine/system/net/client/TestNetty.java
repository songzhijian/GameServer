package com.gameengine.system.net.client;

import com.gameengine.system.net.client.Client;

public class TestNetty {

    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Client client = new Client();
            }
        }).start();

        // 客户端发消息

        Thread.sleep(5000);
        System.out.println("--------------- TestNetty END ----------------");
    }
}
