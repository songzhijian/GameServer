package com.jx.config.model;

import com.jx.config.loader.FunctionOnConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Function_On.xml
*/
public class FunctionOnConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**本地服务器*/
    private final String local;
    /**线上服务器*/
    private final String online;
    /**线上测试服*/
    private final String test;
    /**版本号*/
    private final String version;
    /**平台*/
    private final String platform;

    /**
     * 获取所有配置
     */
    public static List<FunctionOnConfig> findAll(){
        return FunctionOnConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static FunctionOnConfig getByKey(int key){
        return FunctionOnConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 本地服务器
     */
    public String getLocal() {
        return local;
    }

    /**
     * 线上服务器
     */
    public String getOnline() {
        return online;
    }

    /**
     * 线上测试服
     */
    public String getTest() {
        return test;
    }

    /**
     * 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 平台
     */
    public String getPlatform() {
        return platform;
    }

    //#endregion

    //#region 构造函数

    public FunctionOnConfig(int id, String local, String online, String test, String version, String platform){
        this.id = id;
        this.local = local;
        this.online = online;
        this.test = test;
        this.version = version;
        this.platform = platform;
    }

    //#endregion
}
