package com.gameengine.system.zookeeper.conf;

/**
 * zk配置类
 */
public interface ZookeeperConfig {
    /**
     * ZK服务器地址
     */
    String zkConnectString = "10.0.2.31:2181";

    /**
     * 游戏服务root path
     */
    String SERVER_ROOT_PATH = "/SERVER_GS";


    /**
     * DB root path
     */
    String DB_ROOT_PATH = "/DBINFO";

    String DBINFO_BASE_PATH = "/DBINFO";

    String GAME_DB_PATH = "/GAMEDB";

}
