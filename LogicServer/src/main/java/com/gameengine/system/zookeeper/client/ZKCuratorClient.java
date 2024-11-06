package com.gameengine.system.zookeeper.client;

import com.gameengine.system.utils.GameLoggerFactory;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * zk curator客户端
 */
public class ZKCuratorClient {
    private static final Logger logger = GameLoggerFactory.getLogger(ZKCuratorClient.class);
    private final CuratorFramework curatorFramework;
    private final ExecutorService executor;

    /**
     * session超时时间
     */
    private static final int DEFAULT_SESSION_TIMEOUT_MS = 5 * 1000;
    /**
     * 连接超时时间
     */
    private static final int DEFAULT_CONNECTION_TIMEOUT_MS = 30 * 1000;

    private ZKCuratorClient(CuratorFramework curatorFramework, ExecutorService executor) {
        this.curatorFramework = curatorFramework;
        this.executor = executor;
    }

    public static ZKCuratorClient connect(String connectString) {
        return connect(connectString, DEFAULT_SESSION_TIMEOUT_MS, DEFAULT_CONNECTION_TIMEOUT_MS);
    }

    public static ZKCuratorClient connect(String connectString, int sessionTimeoutMs, int connectionTimeoutMs) {
        //5000 表示curator链接zk的时候超时时间是多少 3：表示链接zk的最大重试次数
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(5000, 3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .retryPolicy(retryPolicy)
                .sessionTimeoutMs(sessionTimeoutMs)
                .connectionTimeoutMs(connectionTimeoutMs)
                .canBeReadOnly(true)
                .build();
        curatorFramework.start();
        curatorFramework.getConnectionStateListenable().addListener((client, newState) -> {
            if (newState == ConnectionState.CONNECTED) {
                logger.info("[zookeeper][连接成功],connectString={}",connectString);
            }
        });
        logger.info("[zookeeper][连接中...],connectString={}",connectString);
        return new ZKCuratorClient(curatorFramework, Executors.newFixedThreadPool(2));
    }


    public void createNode(String path) throws Exception {
        curatorFramework.create().forPath(path);
    }
    public void createNode(String path,String data) throws Exception {
        curatorFramework.create().forPath(path,data.getBytes(StandardCharsets.UTF_8));
    }

    public void createEphemeralNode(String path) throws Exception {
        createNodeWithMode(path, CreateMode.EPHEMERAL);
    }
    public void createEphemeralNode(String path,String data) throws Exception {
        createNodeWithMode(path,data,CreateMode.EPHEMERAL);
    }

    public void createNodeWithMode(String path, CreateMode mode) throws Exception {
        if (mode.isSequential()) {
            throw new IllegalArgumentException("Sequential mode not supported for explicit node creation.");
        }
        curatorFramework.create().withMode(mode).forPath(path);
    }

    public void createNodeWithMode(String path,String data,CreateMode mode) throws Exception {
        if (mode.isSequential()) {
            throw new IllegalArgumentException("Sequential mode not supported for explicit node creation.");
        }
        curatorFramework.create().withMode(mode).forPath(path,data.getBytes(StandardCharsets.UTF_8));
    }

    public void deleteNode(String path) throws Exception {
        //guaranteed：该函数的功能如字面意思一样，主要起到一个保障删除成功的作用，其底层工作方式是：只要该客户端的会话有效，就会在后台持续发起删除请求，直到该数据节点在ZooKeeper 服务端被删除
        curatorFramework.delete().guaranteed().deletingChildrenIfNeeded().forPath(path);
    }

    public boolean existNode(String path) throws Exception {
        Stat stat = curatorFramework.checkExists().forPath(path);
        return stat != null;
    }
    /**
     * 获取字节点
     * @param path
     * @return
     * @throws Exception
     */
    public List<String> getChildren(String path) throws Exception {
        return curatorFramework.getChildren().forPath(path);
    }

    /**
     * 读取节点数据
     * @param path
     * @return
     * @throws Exception
     */
    public String getNodeData(String path) throws Exception{
        byte[] bytes = curatorFramework.getData().forPath(path);
        return new String(bytes,StandardCharsets.UTF_8);
    }
    /**
     * 读取节点数据
     * @param path
     * @return
     * @throws Exception
     */
    public byte[] getNodeDataByBytes(String path) throws Exception{
        return curatorFramework.getData().forPath(path);
    }


    /**
     * 读取节点数据
     * @param path
     * @return
     * @throws Exception
     */
    public void setNodeData(String path,String data) throws Exception{
        curatorFramework.setData().forPath(path,data.getBytes(StandardCharsets.UTF_8));
    }


    /**
     * 监听子节点变化
     *
     * @param path     监听路径
     * @param listener 监听器
     * @throws Exception 如果监听过程中发生异常
     */
    public void watchChildNodeChanges(String path, ChildNodeChangeListener listener) throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework, path, true);
        pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);

        pathChildrenCache.getListenable().addListener((client, event) -> {
            List<String> children = pathChildrenCache.getCurrentData().stream()
                    .map(childData -> childData.getPath().substring(path.length() + 1))
                    .collect(Collectors.toList());
            executor.submit(() -> listener.handleChildNodeChange(event, children));
        });
    }

    /**
     * 子节点变化监听器接口
     */
    public interface ChildNodeChangeListener {
        void handleChildNodeChange(PathChildrenCacheEvent event, List<String> children);
    }

    public void close() {
        CloseableUtils.closeQuietly(curatorFramework);
        this.executor.shutdown();
    }

    public CuratorFramework getCuratorFramework() {
        return curatorFramework;
    }
}
