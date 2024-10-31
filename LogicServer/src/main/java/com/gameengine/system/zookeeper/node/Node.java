package com.gameengine.system.zookeeper.node;

import com.dreamfun.opg.utils.GameLoggerFactory;
import org.slf4j.Logger;

/**
 * zk node
 */
public class Node{
    Logger logger = GameLoggerFactory.getLogger(Node.class);

    //节点路径
    private String path;

    //节点数据
    private String data;

    private volatile boolean running = false;

    public Node(String path){
        this.path = path;
    }

    public Node(String path,String data){
        this.path = path;
        this.data = data;
    }


    public String getPath() {
        return path;
    }

    public String getData() {
        return data;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
