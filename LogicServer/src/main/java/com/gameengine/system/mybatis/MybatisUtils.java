package com.gameengine.system.mybatis;

import com.gameengine.system.serializable.SerializerUtils;
import com.jx.logic.GameServer;
import com.gameengine.system.zookeeper.client.ZKCuratorClient;
import com.gameengine.system.zookeeper.conf.ZookeeperConfig;
import com.gameengine.system.zookeeper.service.ZookeeperService;
import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.curator.framework.CuratorFramework;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class MybatisUtils {
    private static final MybatisUtils INSTANCE = new MybatisUtils();
    private static final String MYBATIS_MAPPER_FILE = "/mybatis-mapper.xml";
    public static final String MYBATIS_CONNECTION_FILE = "/mybatis-connection.xml";
    private static final String MYBATIS_CROSS_CONNECTION_FILE = "/mybatis-cross-template.xml";
    private Environment localEnvironment = null;
    private LoadingCache<Integer, Environment> crossEnvironmentMap;
    private SqlSessionFactory localSqlSessionFactory = null;

    public static boolean useProxy = false;

    public static MybatisUtils getInstance() {
        return INSTANCE;
    }

    public void mybatisStart() throws Exception {
        initDbToZookeeper();
        initMyBatis();
    }

    /**
     * 启动服务器初始化
     */
    public void initMyBatis() {
        Configuration mapperConfiguration = null;
        try {
            //解析所有sql配置
            ClassLoader origLoader = Thread.currentThread().getContextClassLoader();
            ClassLoader extensionLoader = getClass().getClassLoader();
            try {
                Thread.currentThread().setContextClassLoader(extensionLoader);
                // 读取所有的Mapper
                InputStream in = getClass().getResourceAsStream(MYBATIS_MAPPER_FILE);
                SqlSessionFactory mapperSqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
                mapperConfiguration = mapperSqlSessionFactory.getConfiguration();
            } finally {
                Thread.currentThread().setContextClassLoader(origLoader);
            }
        } catch (Exception e) {
            throw new RuntimeException("init mybatis mapper error", e);
        }
        try {
            //创建本地连接
            ClassLoader origLoader = Thread.currentThread().getContextClassLoader();
            ClassLoader extensionLoader = getClass().getClassLoader();
            try {
                Thread.currentThread().setContextClassLoader(extensionLoader);
                //关联db连接信息
                InputStream in = getClass().getResourceAsStream(MYBATIS_CONNECTION_FILE);
                Properties properties = GameServer.getInstance().getConfigProperties();
                properties.setProperty("bonecp.poolName", "LS" + GameServer.getInstance().getServerId());
                localSqlSessionFactory = new SqlSessionFactoryBuilder().build(in, properties);
                localEnvironment = localSqlSessionFactory.getConfiguration().getEnvironment();
                Collection<Class<?>> mappers = mapperConfiguration.getMapperRegistry().getMappers();
                for(Class<?> classzz: mappers)
                    localSqlSessionFactory.getConfiguration().getMapperRegistry().addMapper(classzz);

                if (localEnvironment == null) {
                    throw new Exception("localEnvironment is null");
                }

            } finally {
                Thread.currentThread().setContextClassLoader(origLoader);
            }

            crossEnvironmentMap = CacheBuilder.newBuilder()
                    .maximumSize(25)
                    .expireAfterAccess(2, TimeUnit.HOURS)
                    .recordStats()
                    .build(new CacheLoader<Integer, Environment>() {
                        @Override
                        public Environment load(Integer serverId) {
                            try {
                                //创建跨服连接
                                ClassLoader origLoader = Thread.currentThread().getContextClassLoader();
                                ClassLoader extensionLoader = GameServer.getInstance().getClass().getClassLoader();
                                Thread.currentThread().setContextClassLoader(extensionLoader);

                                //此文件不需要配置各个服务器连接的信息, 只需要模板
                                /**
                                 *          <environment id="{local.jdbc.environmentId}">
                                 *             <transactionManager type="JDBC" />
                                 *             <dataSource type="UNPOOLED">
                                 *                 <property name="driver" value="${local.jdbc.driver}" />
                                 *                 <property name="url" value="${local.jdbc.url}" />
                                 *                 <property name="username" value="${local.jdbc.user}" />
                                 *                 <property name="password" value="${local.jdbc.password}" />
                                 *             </dataSource>
                                 *         </environment>
                                 */

                                InputStream in = getClass().getResourceAsStream(MYBATIS_CROSS_CONNECTION_FILE);
                                Properties properties = new Properties();
                                // 从zookeeper中获取信息赋值给properties
                                ZKCuratorClient client = ZookeeperService.getInstance().getZkClient();
                                String gameDbInfoPath = new StringBuilder().append(ZookeeperConfig.DBINFO_BASE_PATH).append(ZookeeperConfig.GAME_DB_PATH).append('/').append(serverId).toString();
                                byte[] bytes = client.getNodeDataByBytes(gameDbInfoPath);
                                DbInfo dbInfo = SerializerUtils.deserialize(bytes, DbInfo.class);
                                properties.setProperty("local.jdbc.environmentId", String.valueOf(dbInfo.getServerId()));
                                properties.setProperty("local.jdbc.driver", dbInfo.getDriver());
                                properties.setProperty("local.jdbc.url", dbInfo.getJdbcUrl());
                                properties.setProperty("local.jdbc.user", dbInfo.getUsername());
                                properties.setProperty("local.jdbc.password", dbInfo.getPassworld());
                                //构建SqlSessionFactory
                                SqlSessionFactory connectionSqlSessionFactory = new SqlSessionFactoryBuilder().build(in, Integer.toString(serverId), properties);
                                Thread.currentThread().setContextClassLoader(origLoader);
                                Environment environment = connectionSqlSessionFactory.getConfiguration().getEnvironment();
                                if (environment == null) {
                                    throw new Exception("environment is null");
                                }
                                return environment;
                            } catch (Exception e) {
                                return null;
                            } finally {
                            }
                        }
                    });

        } catch (Exception e) {
            throw new RuntimeException("init mybatis connection error", e);
        }

    }

    public SqlSession newConnectionFromEnvironment(Environment environment, ExecutorType executorType, boolean autoCommit) {
        //创建连接，复制mybatis源码
        final TransactionFactory transactionFactory = environment.getTransactionFactory();
        Transaction tx = transactionFactory.newTransaction(environment.getDataSource(), null, autoCommit);
        final Executor executor = localSqlSessionFactory.getConfiguration().newExecutor(tx, executorType);
        return new DefaultSqlSession(localSqlSessionFactory.getConfiguration(), executor, autoCommit);
    }

    /**
     * 本服务db
     *
     * @return
     */
    public SqlSession getSession() {
        SqlSession session = newConnectionFromEnvironment(localEnvironment, ExecutorType.SIMPLE, false);
        if(useProxy){
            session = (SqlSession) Proxy.newProxyInstance(SqlSessionInvocationHandler.class.getClassLoader(),
                    session.getClass().getInterfaces(), new SqlSessionInvocationHandler(session));
        }
        return session;
    }

    /**
     * 本服db，批量模式
     *
     * @return
     */
    public SqlSession getBatchSession() {
        SqlSession session = newConnectionFromEnvironment(localEnvironment, ExecutorType.BATCH, false);

        if(useProxy){
            session = (SqlSession) Proxy.newProxyInstance(SqlSessionInvocationHandler.class.getClassLoader(),
                    session.getClass().getInterfaces(), new SqlSessionInvocationHandler(session));
        }
        return session;
    }


    /**
     * 只读session
     * @return
     */
    public SqlSession getNotCommitSession(){
        SqlSession session = newConnectionFromEnvironment(localEnvironment, ExecutorType.BATCH, false);
        session = (SqlSession) Proxy.newProxyInstance(SqlSessionOnlyReadInvocationHandler.class.getClassLoader(),
                session.getClass().getInterfaces(), new   SqlSessionOnlyReadInvocationHandler(session));
        return session;

    }


    public SqlSession getNotCommitSesion( int serverId ){
        SqlSession session = null;
        if( serverId == GameServer.getInstance().getServerId()){
            session = newConnectionFromEnvironment(localEnvironment, ExecutorType.BATCH, false);
        }
        else {
            session = getSession(serverId).get();
        }
        session = (SqlSession) Proxy.newProxyInstance(SqlSessionOnlyReadInvocationHandler.class.getClassLoader(),
                session.getClass().getInterfaces(), new   SqlSessionOnlyReadInvocationHandler(session));
        return session;

    }
    /**
     * 其他服db，不走连接池
     *
     * @param serverId
     * @return
     */
    public Optional<SqlSession> getSession(int serverId) {
        return getSession0(serverId, false);
    }

    /**
     * 其他服db，不走连接池
     *
     * @param serverId
     * @return
     */
    public Optional<SqlSession> getBatchSession(int serverId) {
        return getSession0(serverId, true);
    }


    private Optional<SqlSession> getSession0(int serverId, boolean isBatch) {
        SqlSession session = null;
        Environment environment = null;
        try {
            environment = crossEnvironmentMap.get(serverId);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (environment != null) {
            session = newConnectionFromEnvironment(environment, isBatch ? ExecutorType.BATCH : ExecutorType.SIMPLE, false);
            if(useProxy){
                session = (SqlSession) Proxy.newProxyInstance(SqlSessionInvocationHandler.class.getClassLoader(),
                        session.getClass().getInterfaces(), new SqlSessionInvocationHandler(session));
            }
        }
        return Optional.fromNullable(session);
    }

    /**
     * 数据库连接断开 需要从zookeeper种清楚连接信息并且从缓存中清楚
     * @param serverId
     * @return
     */
    public boolean clearCrossSessionCache(int serverId) {
        if (crossEnvironmentMap.getIfPresent(serverId) != null) {
            crossEnvironmentMap.invalidate(serverId);
        }
        return true;
    }

    /**
     * 启动服务器将各个服务器的相关的mybatis数据库连接信息放入zookeeper
     * @throws Exception
     */
    public static void initDbToZookeeper() throws Exception {
        CuratorFramework client = ZookeeperService.getInstance().getZkClient().getCuratorFramework();

        int serverId = GameServer.getInstance().getServerId();
        String gameDbInfoPath = new StringBuilder().append(ZookeeperConfig.DBINFO_BASE_PATH).append(ZookeeperConfig.GAME_DB_PATH).append('/').append(serverId).toString();

        DbInfoRegister gameDbRegister = new DbInfoRegisterBuilder()
                .setClient(client)
                .setZookeeperNodePath(gameDbInfoPath)
                .setServerId(serverId)
                .setUserKey("local.jdbc.user")
                .setPasswordKey("local.jdbc.password")
                .setJdbcUrlKey("realtime_local.jdbc.url")
                .setDriver("local.jdbc.driver")
                .build();
        gameDbRegister.register();
    }
}
