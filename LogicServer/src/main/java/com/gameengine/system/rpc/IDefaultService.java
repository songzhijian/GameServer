package com.gameengine.system.rpc;

/**
 * 这个是本服务器默认的rpc interface，其默认实现是 {@link DefaultServiceImpl}，各个模块可以在这里添加方法。<br>
 * 当然各个模块也可以定义自己的rpc interface，然后再调用
 * {@link IRpc#regService(Class, Object)}
 */
public interface IDefaultService {

    String sayHi(String name);

}
