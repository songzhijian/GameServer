package com.jx.config.model;

import com.jx.config.loader.HeroShowInfoConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Hero_Show_Info.xml
*/
public class HeroShowInfoConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**名字*/
    private final String name;
    /**称号*/
    private final String title;

    /**
     * 获取所有配置
     */
    public static List<HeroShowInfoConfig> findAll(){
        return HeroShowInfoConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HeroShowInfoConfig getByKey(int key){
        return HeroShowInfoConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
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

    /**
     * 称号
     */
    public String getTitle() {
        return title;
    }

    //#endregion

    //#region 构造函数

    public HeroShowInfoConfig(int id, String name, String title){
        this.id = id;
        this.name = name;
        this.title = title;
    }

    //#endregion
}
