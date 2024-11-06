package com.gameengine.system.redis;

import com.gameengine.system.utils.GameLoggerFactory;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 初始化redis连接
 * 获取 RedisSession
 */
public enum RedisService {
    instance;

    private static final Logger logger = GameLoggerFactory.getLogger(RedisService.class);

    public static final int POOL_TYPE = 0;
    public static final int SENTINEL_POOL_TYPE = 1;
    public static final int CLUSTER_POOL_TYPE = 2;

    private RedisSession localRedis = null;
    private RedisSession globalRedis = null;
    
    private Map<Integer, RedisSession> crossRedisMap = new ConcurrentHashMap<>();

    public void init() {
        initLocalRedis();
        initGlobalRedis(SENTINEL_POOL_TYPE);
    }

    /**
     * 初始化global redis
     * @param type
     */
    private void initGlobalRedis(int type) {
        if(!Objects.isNull(globalRedis)) {
            globalRedis.shutDown();
            globalRedis = null;
        }

        String itemStr = "10.0.2.204:26379|10.0.2.204:26380|10.0.2.204:26381";
        String[] addressArr = itemStr.split("\\|");
        String[] addresses = new String[addressArr.length];
        // 遍历每个地址
        for (int i = 0; i< addressArr.length; i ++) {
            addresses[i] = "redis://" + addressArr[i];
        }

        Config config = new Config();
        if(type == POOL_TYPE) {
            config.useSingleServer()
                    .setAddress(addresses[0])
                    .setConnectionPoolSize(100)
                    .setConnectTimeout(5000); // 设置最小空闲连接数
        }

        //读配置列表
        if(type == SENTINEL_POOL_TYPE) {
            String masterName = "lsmaster";//读个配置
                    config.useSentinelServers()
                    .setMasterName(masterName) // 设置 Redis 主节点的名称
                    .addSentinelAddress(addresses)
                    .setConnectTimeout(5000)
                    .setDatabase(0); // 设置数据库索引
        }

        if(type == CLUSTER_POOL_TYPE) {
            String clientName = "lsmaster";//读个配置
            config.useClusterServers()
                    .setClientName(clientName)
                    .addNodeAddress(addresses)
                    .setConnectTimeout(5000);
        }
        RedissonClient rc = Redisson.create(config);
        globalRedis = RedisSession.buildRedisSession(rc);//构建RedisSession return ; // 根据配置创建 Redisson 客户端
    }

    /**
     * 初始化本地redis
     */
    private void initLocalRedis() {
        if(!Objects.isNull(localRedis)) {
            localRedis.shutDown();
            localRedis = null;
        }
        //  String ip = xxx.get("redis.ip"); //从配置里面读取
        //  String port = xxx.get("redis.port"); //从配置里面读取
        String ip ="10.0.0.156";
        String port ="6379";
        String address = "redis://"+ip+":"+port;

        Config config = new Config();
        config.useSingleServer()
                // .setAddress(addressList.get(0)) // 设置 Redis 服务器地址
                .setAddress(address) // 设置 Redis 服务器地址
                .setConnectionPoolSize(10) // 设置连接池大小
                .setConnectionMinimumIdleSize(5); // 设置最小空闲连接数

        // 根据配置创建 Redisson 客户端
        localRedis = RedisSession.buildRedisSession(Redisson.create(config));//构建RedisSession return ; // 根据配置创建 Redisson 客户端
    }


    public RedisSession getLocalRedis() {
        return localRedis;
    }

    public RedisSession getGlobalRedis() {
        return globalRedis;
    }

    public synchronized RedisSession getCrossRedis(int serverId) {
        //检查是不是有效的serverId
        //isUseFullServerId()
        //如果是本服 返回local redis
       /** if(serverId == localServer) {
            return localRedis;
        }*/

        if(crossRedisMap.containsKey(serverId)) {
            return crossRedisMap.get(serverId);
        }

        RedisSession redisSession = null;
        try {
            Config config = new Config();
            //创建cross连接 并保存
            RedissonClient redissonClient = Redisson.create(config);
            redisSession = RedisSession.buildRedisSession(redissonClient);
            crossRedisMap.put(serverId,redisSession);
        } catch ( Exception e) {
            logger.error("create cross redis connect fail serverId:" + serverId);
        }
        return  redisSession;
    }


    /**
     * 刷新某个redis连接
     * @param serverId
     */
    public void refreshCrossRedission(int serverId) {
        RedisSession redisSession = crossRedisMap.get(serverId);
        if(Objects.nonNull(redisSession)) {
            redisSession.shutDown();
        }
    }


    /**
     * 服务器关闭调用 其他情况不要调用
     */
    public void shutDownAll() {
        Iterator<RedisSession> iterator = crossRedisMap.values().iterator();
        while (iterator.hasNext()) {
            RedisSession rs = iterator.next();
            rs.shutDown();
            iterator.remove(); // 在遍历时移除元素
        }

        localRedis.shutDown();
        globalRedis.shutDown();
    }


}
