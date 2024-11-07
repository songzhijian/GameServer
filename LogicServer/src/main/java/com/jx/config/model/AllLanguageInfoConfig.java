package com.jx.config.model;

import com.jx.config.loader.AllLanguageInfoConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 AllLanguage_Info.xml
*/
public class AllLanguageInfoConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**缩写*/
    private final String langSimpleName;
    /**是否大语种*/
    private final int majorLanguage;

    /**
     * 获取所有配置
     */
    public static List<AllLanguageInfoConfig> findAll(){
        return AllLanguageInfoConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AllLanguageInfoConfig getByKey(int key){
        return AllLanguageInfoConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 缩写
     */
    public String getLangSimpleName() {
        return langSimpleName;
    }

    /**
     * 是否大语种
     */
    public int getMajorLanguage() {
        return majorLanguage;
    }

    //#endregion

    //#region 构造函数

    public AllLanguageInfoConfig(int id, String langSimpleName, int majorLanguage){
        this.id = id;
        this.langSimpleName = langSimpleName;
        this.majorLanguage = majorLanguage;
    }

    //#endregion
}
