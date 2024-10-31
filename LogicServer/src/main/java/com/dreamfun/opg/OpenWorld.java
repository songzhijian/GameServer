package com.dreamfun.opg;


import com.dreamfun.opg.GameServer;


public class OpenWorld {

    public static void main(String[] args) {
        try {
            GameServer.getInstance().startup();
        }catch (Exception e){
            e.printStackTrace();
            GameServer.getInstance().shutdown();
        }
    }
}