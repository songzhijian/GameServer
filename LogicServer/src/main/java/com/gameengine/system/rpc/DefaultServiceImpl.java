package com.gameengine.system.rpc;

import com.gameengine.system.utils.GameLoggerFactory;
import org.slf4j.Logger;

/**
 * 默认的rpc impl实现。
 */
public class DefaultServiceImpl implements IDefaultService {

	private static final Logger logger = GameLoggerFactory.getLogger(DefaultServiceImpl.class);

	@Override
	public String sayHi(String name) {
		logger.info("[rpc]DefaultServiceImpl.sayHi@this is a hi msg|name={}", name);
		return "hi, " + name;
	}

}
