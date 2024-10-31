package com.dreamfun.opg.game;

import com.gameengine.system.redis.RedisService;
import com.gameengine.system.zookeeper.service.ZookeeperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OPServerShutdownHook extends Thread{
    private Logger logger = LoggerFactory.getLogger(OPServerShutdownHook.class);

    public OPServerShutdownHook() {
        super("register OP shutdown hook");
        this.logger.info("Op server shutdown hook started");
    }

    public void run() {
        try {
            shutdownDo();
            this.logger.info("op server stop successfully");
        } catch (Throwable e) {
            this.logger.error("op server stop error", e);
        }

    }

    private void shutdownDo() {
        //......

        //关闭zk
        ZookeeperService.getInstance().stop();

        //放在最下面
        RedisService.instance.shutDownAll();
    }
}
