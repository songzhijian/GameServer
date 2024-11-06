
package com.jx.logic;
import com.gameengine.system.handler.HandlerRegisterCenter;
import com.gameengine.system.handler.IClientRequestHandler;
import com.gameengine.system.handler.RequestHandlerFactory;
import com.google.protobuf.Message;
import com.gameengine.system.OPServerShutdownHook;
import com.gameengine.system.utils.AsciiUtil;
import com.gameengine.system.service.GameCoreServiceManager;

import com.gameengine.system.utils.GameLoggerFactory;
import org.apache.commons.configuration.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 游戏服务器
 */
public class GameServer {
    private static final Logger logger = GameLoggerFactory.getLogger(GameServer.class);

    private static final GameServer instance = new GameServer();

    private GameCoreServiceManager coreServiceManager = new GameCoreServiceManager();
    public Properties configProperties;

    private CompositeConfiguration configuration;

    public int serverId = 1;


    private GameServer() {

    }
    public Properties getConfigProperties() {
        return configProperties;
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }

    public static GameServer getInstance() {
        return instance;
    }

    private RequestHandlerFactory handlerFactory = new RequestHandlerFactory();

    /**
     * 游戏服务初始化
     */
    public void start() throws Exception{
        long beginTime = System.currentTimeMillis();
        this.logger.info("Server starting...");
        this.loadConfiguration();
        //zk节点注册
//        String pathName = String.format("gs-%d-%s", serverId,NetUtil.getHostIp(""));
//        ZookeeperService.getInstance().start(pathName);

        this.coreServiceManager.init();
        this.coreServiceManager.start();

//        netterServer = new ServerNettyService();
//        netterServer.startService(9091);

//        RedisService.instance.init();

//        loadCustomConfigFile("config.properties");//todo
//        GameConfigService.init();

        registerShutdownHook();
        HandlerRegisterCenter.register();
        logger.info("GameServer startup ok,cost={}ms",(System.currentTimeMillis() - beginTime));
        //启动完毕
        String asciiMessage = AsciiUtil.getAsciiMessage("startup.txt");
        if(StringUtils.isNotEmpty(asciiMessage)) {
            logger.info(asciiMessage);
        }
    }

    public boolean isWindows() {
        return System.getProperties().getProperty("os.name").toUpperCase().contains("WINDOWS");
    }

    private void loadCustomConfigFile(String fileName) throws IOException {
        this.configProperties = new Properties();
        this.configProperties.load(new FileInputStream(fileName));
    }

    public void loadConfiguration() throws ConfigurationException {
        this.configuration = new CompositeConfiguration();
        this.configuration.addConfiguration(new SystemConfiguration());
//        this.configuration.addConfiguration(new PropertiesConfiguration("gameconfig/core.properties")); //TODO
    }

    public int getServerId() {
        return serverId;
    }

    /**
     * 客户端消息请求入口
     * @param messageId
     * @param message
     * @throws Exception
     */
    public void handleClientRequest(int messageId, Message message) throws Exception {
        try {
            IClientRequestHandler requestHandler = (IClientRequestHandler)this.handlerFactory.findHandler(messageId);
            if(requestHandler == null) {
                throw new RuntimeException("Request handler not found, messageId: " + messageId );
            }
            requestHandler.handleClientRequest(message);
        } catch (InstantiationException e) {
            logger.warn("Cannot instantiate handler class: ", e);
        } catch (IllegalAccessException e) {
            logger.warn("Illegal access for handler class: ", e);
        }
    }

    public void addRequestHandler(Integer messageId, Class<?> theClass) {
        if(!IClientRequestHandler.class.isAssignableFrom(theClass)) {
            throw new RuntimeException(String.format("Request Handler not implement IClientRequestHandler: %s, messageId: %s", theClass, messageId));
        } else {
            this.handlerFactory.addHandler(messageId, theClass);
        }
    }

    protected void removeRequestHandler(Integer messageId) {
        this.handlerFactory.removeHandler(messageId);
    }

    public void destroy() {
        this.handlerFactory.clearAll();
    }

    /**
     * 关闭服务器
     */
    public void shutdown() {
        Runtime.getRuntime().exit(0);
    }

    private void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new OPServerShutdownHook());
    }
}
