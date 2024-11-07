package com.jx.config.model;

import com.jx.config.loader.WorldPortColorConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 World_Port_Color.xml
*/
public class WorldPortColorConfig extends AbstractConfig implements IConfig {

    /**ID*/
    private final int id;
    /**描边颜色*/
    private final String outlineColor;

    /**
     * 获取所有配置
     */
    public static List<WorldPortColorConfig> findAll(){
        return WorldPortColorConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WorldPortColorConfig getByKey(int key){
        return WorldPortColorConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * ID
     */
    public int getId() {
        return id;
    }

    /**
     * 描边颜色
     */
    public String getOutlineColor() {
        return outlineColor;
    }

    //#endregion

    //#region 构造函数

    public WorldPortColorConfig(int id, String outlineColor){
        this.id = id;
        this.outlineColor = outlineColor;
    }

    //#endregion
}
