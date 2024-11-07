package com.jx.config.model;

import com.jx.config.loader.GMItemNameConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 GM_ItemName.xml
*/
public class GMItemNameConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**名字*/
    private final String name;

    /**
     * 获取所有配置
     */
    public static List<GMItemNameConfig> findAll(){
        return GMItemNameConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static GMItemNameConfig getByKey(int key){
        return GMItemNameConfigLoader.getByKey(key);
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

    public GMItemNameConfig(int id, String name){
        this.id = id;
        this.name = name;
    }

    //#endregion
}
