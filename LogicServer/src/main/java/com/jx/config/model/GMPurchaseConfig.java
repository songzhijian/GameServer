package com.jx.config.model;

import com.jx.config.loader.GMPurchaseConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 GM_Purchase.xml
*/
public class GMPurchaseConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**名字*/
    private final String name;

    /**
     * 获取所有配置
     */
    public static List<GMPurchaseConfig> findAll(){
        return GMPurchaseConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static GMPurchaseConfig getByKey(int key){
        return GMPurchaseConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 名字
     */
    public String getName() {
        return name;
    }

    //#endregion

    //#region 构造函数

    public GMPurchaseConfig(int id, String name){
        this.id = id;
        this.name = name;
    }

    //#endregion
}
