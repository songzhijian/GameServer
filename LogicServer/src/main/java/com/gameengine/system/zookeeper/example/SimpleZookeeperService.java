package com.gameengine.system.zookeeper.example;

import com.gameengine.system.utils.GameLoggerFactory;
import com.gameengine.system.zookeeper.client.ZKCuratorClient;
import com.gameengine.system.zookeeper.conf.ZookeeperConfig;
import com.gameengine.system.zookeeper.node.Node;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.slf4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * zookeeper服务
 */
public class SimpleZookeeperService {
    private static final Logger logger = GameLoggerFactory.getLogger(SimpleZookeeperService.class);

    private static ZKCuratorClient zkClient;

    public SimpleZookeeperService() {
        zkClient = ZKCuratorClient.connect(ZookeeperConfig.zkConnectString);
    }
    /**
     * 本服node节点
     */
    private Node localServerNode;

    /**
     * 启动zk服务
     * @param nodePath node路径
     * @throws Exception
     */
    public void start(String nodePath) throws Exception {
        //检查path
        checkCreateNodeIfNeeded();
        String nodeName = ZookeeperConfig.SERVER_ROOT_PATH + "/" + nodePath;
        //初始化node
        this.localServerNode = new Node(nodeName);
        //注册node
        registerNode(localServerNode);

        String dbNode = ZookeeperConfig.DB_ROOT_PATH + "/" + nodePath;
        //注册dbnode
        registerNode(new Node(dbNode,"12345"));

        //注册监听
        registerNodeWatcher();
    }

    /**
     * 检查是否需要创建节点
     * @throws Exception
     */
    private void checkCreateNodeIfNeeded() throws Exception{
        //判定是否存在server 根节点
        if(!zkClient.existNode(ZookeeperConfig.SERVER_ROOT_PATH)){
            zkClient.createNode(ZookeeperConfig.SERVER_ROOT_PATH);
            logger.info("[zookeeper][不存在根节点:{},创建节点]", ZookeeperConfig.SERVER_ROOT_PATH);
        }
        //判定是否存在server 根节点
        if(!zkClient.existNode(ZookeeperConfig.DB_ROOT_PATH)){
            zkClient.createNode(ZookeeperConfig.DB_ROOT_PATH);
            logger.info("[zookeeper][不存在根节点:{},创建节点]", ZookeeperConfig.DB_ROOT_PATH);
        }
    }

    /**
     * 注册 node
     * @param node
     */
    private void registerNode(Node node) throws Exception{
        // 初始化消息监听服务
        if(node.isRunning()){
            return;
        }
        node.setRunning(true);
        // 重连上是重新注册节点
        if(zkClient.existNode(node.getPath())){
            zkClient.deleteNode(node.getPath());
        }
        if(node.getData() != null){
            zkClient.createEphemeralNode(node.getPath(),node.getData());
            logger.info("[zookeeper][注册子节点],path={},data={}",node.getPath(),node.getData());
        }else{
            zkClient.createEphemeralNode(node.getPath());
            logger.info("[zookeeper][注册子节点],path={}",node.getPath());
        }
    }

    /**
     * 添加节点监听
     */
    private void registerNodeWatcher() throws Exception{
        //监听服务节点
        zkClient.watchChildNodeChanges(ZookeeperConfig.SERVER_ROOT_PATH, (event, children) -> {
        });
        List<String> list = zkClient.getChildren(ZookeeperConfig.SERVER_ROOT_PATH);
        if(list == null || list.isEmpty()){
            return ;
        }
        zkClient.watchChildNodeChanges(ZookeeperConfig.DB_ROOT_PATH, (event, children) -> {
            ChildData data = event.getData();
            if(data != null){
                logger.info("node changed,type={},path={},data={}",event.getType().toString(),data.getPath(),new String(data.getData(), StandardCharsets.UTF_8));
            }
        });
    }

    public void stop() {
        if(zkClient != null) {
            zkClient.close();
        }
    }

}
