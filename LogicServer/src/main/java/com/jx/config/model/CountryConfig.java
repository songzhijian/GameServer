package com.jx.config.model;

import com.jx.config.loader.CountryConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Country.xml
*/
public class CountryConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**二位代码*/
    private final String des;
    /**语言*/
    private final int language;
    /**使用状态*/
    private final int status;

    /**
     * 获取所有配置
     */
    public static List<CountryConfig> findAll(){
        return CountryConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static CountryConfig getByKey(int key){
        return CountryConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 二位代码
     */
    public String getDes() {
        return des;
    }

    /**
     * 语言
     */
    public int getLanguage() {
        return language;
    }

    /**
     * 使用状态
     */
    public int getStatus() {
        return status;
    }

    //#endregion

    //#region 构造函数

    public CountryConfig(int id, String des, int language, int status){
        this.id = id;
        this.des = des;
        this.language = language;
        this.status = status;
    }

    //#endregion
}
