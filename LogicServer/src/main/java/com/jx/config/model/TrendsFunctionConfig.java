package com.jx.config.model;

import com.jx.config.loader.TrendsFunctionConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Trends_Function.xml
*/
public class TrendsFunctionConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**功能类型*/
    private final int type;
    /**类型参数*/
    private final int para;
    /**特定服务器生效*/
    private final String[] server;

    /**
     * 获取所有配置
     */
    public static List<TrendsFunctionConfig> findAll(){
        return TrendsFunctionConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TrendsFunctionConfig getByKey(int key){
        return TrendsFunctionConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 功能类型
     */
    public int getType() {
        return type;
    }

    /**
     * 类型参数
     */
    public int getPara() {
        return para;
    }

    /**
     * 特定服务器生效
     */
    public String[] getServer() {
        return server;
    }

    //#endregion

    //#region 构造函数

    public TrendsFunctionConfig(int id, int type, int para, String[] server){
        this.id = id;
        this.type = type;
        this.para = para;
        this.server = server;
    }

    //#endregion
}
