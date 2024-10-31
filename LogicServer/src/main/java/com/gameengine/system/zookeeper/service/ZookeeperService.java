package com.gameengine.system.zookeeper.service;

import com.dreamfun.opg.utils.GameLoggerFactory;
import com.gameengine.system.mybatis.MybatisUtils;
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
public class ZookeeperService {
    private final Logger logger = GameLoggerFactory.getLogger(ZookeeperService.class);

    private static ZookeeperService instance;
    private static ZKCuratorClient zkClient;

    private ZookeeperService() {}

    public static ZookeeperService getInstance() {
        if(instance == null) {
            instance = new ZookeeperService();
            zkClient = ZKCuratorClient.connect(ZookeeperConfig.zkConnectString);
        }
        return instance;
    }
    /**
     * 本服servernode节点
     */
    private Node serverNode;

    /**
     * 本服dbnode节点
     */
    private Node dbNode;


    /**
     * 启动zk服务
     * @param nodePath 当前节点
     * @throws Exception
     */
    public void start(String nodePath) throws Exception {
        //检查path
        checkCreateNodeIfNeeded();
        //初始化node
        String serverNodeName = ZookeeperConfig.SERVER_ROOT_PATH + "/" + nodePath;
        this.serverNode = new Node(serverNodeName);
        //注册node
        registerNode(serverNode);

        //初始化node
        String dbNodeName = ZookeeperConfig.DB_ROOT_PATH + "/" + nodePath;
        this.dbNode = new Node(dbNodeName,"{1234}");
        //注册node
        registerNode(dbNode);
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
        //判定是否存在DB 根节点
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
            logger.info("node changed,type={},children.size={}",event.getType().toString(),children.size());
        });
        List<String> list = zkClient.getChildren(ZookeeperConfig.SERVER_ROOT_PATH);
        if(list == null || list.isEmpty()){
            return ;
        }
        //监听DB服务节点
        zkClient.watchChildNodeChanges(ZookeeperConfig.DB_ROOT_PATH, (event, children) -> {
            ChildData data = event.getData();
            if(data != null){
                logger.info("node changed,type={},path={},data={}",event.getType().toString(),data.getPath(),new String(data.getData(), StandardCharsets.UTF_8));
                String []pathSplit = data.getPath().split("/");
                if(pathSplit.length > 3) {
                    MybatisUtils.getInstance().clearCrossSessionCache(Integer.parseInt(pathSplit[3]));
                }
            }
        });

    }

    public void stop() {
        if(zkClient != null) {
            zkClient.close();
        }
        this.instance = null;
    }

    public ZKCuratorClient getZkClient() {
        return zkClient;
    }
}
