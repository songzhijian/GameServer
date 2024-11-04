
package com.dreamfun.opg;
import com.dreamfun.opg.game.OPServerShutdownHook;
import com.dreamfun.opg.manager.GameSessionManager;
import com.dreamfun.opg.utils.AsciiUtil;
import com.gameengine.system.GameCoreServiceManager;
import com.gameengine.system.net.scan.MessageProcessorScanner;
import com.gameengine.system.net.scan.MessageScanner;

import com.gameengine.system.net.server.ServerNettyService;
import com.dreamfun.opg.utils.GameLoggerFactory;
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
    private final Logger logger = GameLoggerFactory.getLogger(GameServer.class);

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

    // TODO 游戏核心manager 后期优化点
    private GameSessionManager sessionManager;

    private ServerNettyService netterServer;

    /**
     * 消息扫描
     */
    private MessageScanner msgScanner;

    /**
     * 消息handler 扫描
     */
    private MessageProcessorScanner processorScanner;

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

        // netty
        MessageScanner msgScanner = new MessageScanner();
        msgScanner.scanClasses(null);

        MessageProcessorScanner processorScanner = new MessageProcessorScanner();
        if (isWindows()){
            processorScanner.scanClassesWin("com/gameengine/system/net/processor/");
        }else {
        processorScanner.scanClasses("com/gameengine/system/net/processor/");
        }
        this.msgScanner = msgScanner;
        this.processorScanner = processorScanner;

        this.coreServiceManager.init();
        this.coreServiceManager.start();

//        netterServer = new ServerNettyService();
//        netterServer.startService(9091);

//        RedisService.instance.init();

//        loadCustomConfigFile("config.properties");//todo
//        GameConfigService.init();

        registerShutdownHook();
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

    public MessageScanner getMsgScanner() {
        return msgScanner;
    }

    public MessageProcessorScanner getProcessorScanner() {
        return processorScanner;
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
     * 关闭服务器
     */
    public void shutdown() {
        Runtime.getRuntime().exit(0);
    }

    private void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new OPServerShutdownHook());
    }
}
