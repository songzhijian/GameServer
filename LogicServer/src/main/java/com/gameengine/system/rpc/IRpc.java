package com.gameengine.system.rpc;

import com.dreamfun.opg.utils.GameLoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.ReferenceConfig;
import org.slf4j.Logger;

public class IRpc {

	private static final Logger logger = GameLoggerFactory.getLogger(IRpc.class);

	/**
	 * 目前有个默认的已经发布的rpc服务，该服务在服务器启动的时候进行了发布。其接口: {@link IDefaultService}，其实现类为
	 * {@link DefaultServiceImpl }。 <br>
	 * 开发的时候在 这两个地方添加方法即可。 <br>
	 * 
	 * 
	 * 
	 * @param <T>
	 * @param serverId
	 * @param type
	 * @return
	 */
	public static <T> T getRemoteService(final int serverId, Class<T> type) {
		// 和本地bean一样使用demoService
		// 通过Interface获取远程服务接口代理，不需要依赖ReferenceConfig对象
		// T demoService = DubboBootstrap.getInstance().getCache().get(type);

		final String key = serverId + "#" + type.getName();
		final ReferenceConfig<T> config = ManagerRpc.sidServiceclz2reference.computeIfAbsent(key, (k) -> {
			final int sid = Integer.parseInt(StringUtils.split(k, '#')[0]);
			return ManagerRpc.createConsumerService(sid, type);
		});
		return null == config ? null : config.get();
	}

	/**
	 * 注册rpc服务器的 interface和 impl instance。<br>
	 *
	 * @param clz
	 * @param o
	 */
	public static void regService(Class<?> clz, Object o) {
		ManagerRpc.regService(clz, o);
	}
}
