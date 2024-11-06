package com.jx.logic;


public class OpenWorld {

    public static void main(String[] args) {
        try {
            GameServer.getInstance().start();
        }catch (Exception e){
            e.printStackTrace();
            GameServer.getInstance().shutdown();
        }
    }
}
