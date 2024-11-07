package com.jx.config.model;

import com.jx.config.loader.NewbiesPointsConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Newbies_Points.xml
*/
public class NewbiesPointsConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**交互范围*/
    private final int interactionScope;

    /**
     * 获取所有配置
     */
    public static List<NewbiesPointsConfig> findAll(){
        return NewbiesPointsConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static NewbiesPointsConfig getByKey(int key){
        return NewbiesPointsConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 交互范围
     */
    public int getInteractionScope() {
        return interactionScope;
    }

    //#endregion

    //#region 构造函数

    public NewbiesPointsConfig(int id, int interactionScope){
        this.id = id;
        this.interactionScope = interactionScope;
    }

    //#endregion
}
