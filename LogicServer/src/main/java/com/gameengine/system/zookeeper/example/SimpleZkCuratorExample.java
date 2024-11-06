package com.gameengine.system.zookeeper.example;


import com.gameengine.system.utils.NetUtil;

/**
 * zk curator 示例
 */
public class SimpleZkCuratorExample {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        try {
            String pathName1 = String.format("gs-%d-%s", 1001,NetUtil.getHostIp(""));
            new SimpleZookeeperService().start(pathName1);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            String pathName2 = String.format("gs-%d-%s", 1002,NetUtil.getHostIp(""));
            new SimpleZookeeperService().start(pathName2);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            String pathName3 = String.format("gs-%d-%s", 1003,NetUtil.getHostIp(""));
            new SimpleZookeeperService().start(pathName3);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            Thread.sleep(100000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
