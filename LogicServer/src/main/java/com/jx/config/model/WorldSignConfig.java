package com.jx.config.model;

import com.jx.config.loader.WorldSignConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 World_Sign.xml
*/
public class WorldSignConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**标记类型*/
    private final int type;

    /**
     * 获取所有配置
     */
    public static List<WorldSignConfig> findAll(){
        return WorldSignConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WorldSignConfig getByKey(int key){
        return WorldSignConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 标记类型
     */
    public int getType() {
        return type;
    }

    //#endregion

    //#region 构造函数

    public WorldSignConfig(int id, int type){
        this.id = id;
        this.type = type;
    }

    //#endregion
}
