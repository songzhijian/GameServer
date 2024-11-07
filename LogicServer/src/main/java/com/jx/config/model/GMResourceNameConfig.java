package com.jx.config.model;

import com.jx.config.loader.GMResourceNameConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 GM_ResourceName.xml
*/
public class GMResourceNameConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**名字*/
    private final String name;

    /**
     * 获取所有配置
     */
    public static List<GMResourceNameConfig> findAll(){
        return GMResourceNameConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static GMResourceNameConfig getByKey(int key){
        return GMResourceNameConfigLoader.getByKey(key);
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

    public GMResourceNameConfig(int id, String name){
        this.id = id;
        this.name = name;
    }

    //#endregion
}
