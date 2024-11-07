package com.jx.config.model;

import com.jx.config.loader.BubbleInteractionConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Bubble_Interaction.xml
*/
public class BubbleInteractionConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**功能类型*/
    private final int type;

    /**
     * 获取所有配置
     */
    public static List<BubbleInteractionConfig> findAll(){
        return BubbleInteractionConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static BubbleInteractionConfig getByKey(int key){
        return BubbleInteractionConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
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

    //#endregion

    //#region 构造函数

    public BubbleInteractionConfig(int id, int type){
        this.id = id;
        this.type = type;
    }

    //#endregion
}
