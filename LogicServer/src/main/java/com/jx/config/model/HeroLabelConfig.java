package com.jx.config.model;

import com.jx.config.loader.HeroLabelConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Hero_Label.xml
*/
public class HeroLabelConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**icon*/
    private final String icon;
    /**标签文字*/
    private final String name;
    /**tips*/
    private final String des;

    /**
     * 获取所有配置
     */
    public static List<HeroLabelConfig> findAll(){
        return HeroLabelConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HeroLabelConfig getByKey(int key){
        return HeroLabelConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 标签文字
     */
    public String getName() {
        return name;
    }

    /**
     * tips
     */
    public String getDes() {
        return des;
    }

    //#endregion

    //#region 构造函数

    public HeroLabelConfig(int id, String icon, String name, String des){
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.des = des;
    }

    //#endregion
}
