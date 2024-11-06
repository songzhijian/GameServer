package com.gameengine.system.rpc;

import com.jx.logic.GameServer;
import com.gameengine.system.utils.GameLoggerFactory;
import org.apache.dubbo.config.MethodConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * https://cn.dubbo.apache.org/zh-cn/overview/mannual/java-sdk/reference-manual/config/api/
 */
public class ManagerRpc {

    private static final Logger logger = GameLoggerFactory.getLogger(ManagerRpc.class);

    public static final String PROTOCOL_NAME = "dubbo";

    public static final String RPC_APPLICATION = "provider";
    /**
     * 当前服务器提供的rpc服务。 <br>
     * key：interface class; value:impl instance <br>
     */
    public static Map<Class<?>, Object> serviceclz2instance = new HashMap<>();

    /**
     * key:sid#clzname v:作为消费者连接remote的数据。
     */
    public static Map<String, ReferenceConfig> sidServiceclz2reference = new ConcurrentHashMap<>();

    /**
     * 启动所有的注册的 rpc。
     */
    public static void startServiceAll() {
        if (serviceclz2instance.isEmpty()) {
            return;
        }

        final int dubboPort = getRpcPort(GameServer.getInstance().serverId);
        // 服务提供者协议配置
        final ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName(PROTOCOL_NAME);
        protocol.setPort(dubboPort);
        protocol.setThreads(100);

        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
        // 服务提供者暴露服务配置
        List<ServiceConfig> configList = new ArrayList<>();
        for (final Map.Entry<Class<?>, ?> entry : serviceclz2instance.entrySet()) {
            final Class<?> clz = entry.getKey();
            final Object obj = entry.getValue();
            final ServiceConfig demoServiceConfig = new ServiceConfig<>();
            demoServiceConfig.setInterface(clz);
            demoServiceConfig.setRef(obj);
            demoServiceConfig.setVersion("1.0.0");

            configList.add(demoServiceConfig);
        }

        final DubboBootstrap boostrap = DubboBootstrap.getInstance().application(RPC_APPLICATION) // 应用配置
                .protocol(protocol); // 全局默认协议配置
        for (final ServiceConfig<Object> demoServiceConfig : configList) {
            boostrap.service(demoServiceConfig); // 添加ServiceConfig
        }

        boostrap.start(); // 启动Dubbo
        // .await(); // 挂起等待(防止进程退出）
        logger.info("[rpc]ManagerRpc.startServiceAuto@create default rpc service end");
    }

    @SuppressWarnings("deprecation")
    /**
     * 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏 //
     * 如果点对点直连，可以用reference.setUrl()指定目标地址，设置url后将绕过注册中心， //
     * 其中，协议对应provider.setProtocol()的值，端口对应provider.setPort()的值， //
     * 路径对应service.setPath()的值，如果未设置path，缺省path为接口名
     *
     * @param <T>
     * @param sid
     * @param type
     * @return
     */
    public static <T> ReferenceConfig<T> createConsumerService(final int sid, Class<T> type) {
        final String name = type.getTypeName();

        final String ip = getRpcIp(sid);
        final int port = getRpcPort(sid);
        // dubbo://localhost:9004/priv.wen.gs.frame.rpc.IDefaultService
        final String url = PROTOCOL_NAME + "://" + ip + ":" + port + "/" + name;
        logger.info("[rpc]ManagerRpc.createConsumerService@create start|url={}", url);

        // 方法级配置，可以不需要
        final List<MethodConfig> methodsCfgList = new ArrayList<MethodConfig>();

        //如果是 IDefaultService或者其 子class
        if (type.isAssignableFrom(IDefaultService.class)) {
            final MethodConfig method = new MethodConfig();
            method.setName("sayHi");
            method.setTimeout(1000);
            method.setRetries(0);
            methodsCfgList.add(method);
        }

        // 对一个servcie的调用
        final ReferenceConfig<T> serviceReference = new ReferenceConfig<T>();
        serviceReference.setApplication(DubboBootstrap.getInstance().getApplication());
        serviceReference.setInterface(type);
        serviceReference.setVersion("1.0.0");
        serviceReference.setUrl(url);
        serviceReference.setTimeout(2000);
        serviceReference.setMethods(methodsCfgList); // 设置方法级配置
        logger.info("[rpc]ManagerRpc.createConsumerService@create consumer service end|url={}|sid={}", url, sid);
        return serviceReference;
    }

    /**
     * 注册rpc服务器的 interface和 impl instance。<br>
     * <b>注意：该方法的调用需要在 方法 {@link #startServiceAll()} 的调用之前。
     *
     * @param clz
     * @param o
     */
    public static void regService(Class<?> clz, Object o) {
        serviceclz2instance.put(clz, o);
        logger.info("[rpc]ManagerRpc.regService@reg a rpc servcie|interfaceclz={}|instancename={}", clz.getTypeName(),
                o.getClass().getName());
    }

    public static int getRpcPort(final int sid) {
        //TODO://
        return 0;
    }

    public static String getRpcIp(final int sid) {
        //TODO://
        return "";
    }
}
