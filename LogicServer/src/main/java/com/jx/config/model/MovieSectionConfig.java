package com.jx.config.model;

import com.jx.config.loader.MovieSectionConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Movie_Section.xml
*/
public class MovieSectionConfig extends AbstractConfig implements IConfig {

    /**开始节点*/
    private final int startSectionId;
    /**下一段开始节点*/
    private final int nextStartSectionId;
    /**上一段开始节点*/
    private final int lastSectionId;
    /**动态参数5*/
    private final int[] param_5;
    /**动态参数6*/
    private final String param_6;

    /**
     * 获取所有配置
     */
    public static List<MovieSectionConfig> findAll(){
        return MovieSectionConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MovieSectionConfig getByKey(int key){
        return MovieSectionConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 开始节点
     */
    public int getStartSectionId() {
        return startSectionId;
    }

    /**
     * 下一段开始节点
     */
    public int getNextStartSectionId() {
        return nextStartSectionId;
    }

    /**
     * 上一段开始节点
     */
    public int getLastSectionId() {
        return lastSectionId;
    }

    /**
     * 动态参数5
     */
    public int[] getParam_5() {
        return param_5;
    }

    /**
     * 动态参数6
     */
    public String getParam_6() {
        return param_6;
    }

    //#endregion

    //#region 构造函数

    public MovieSectionConfig(int startSectionId, int nextStartSectionId, int lastSectionId, int[] param_5, String param_6){
        this.startSectionId = startSectionId;
        this.nextStartSectionId = nextStartSectionId;
        this.lastSectionId = lastSectionId;
        this.param_5 = param_5;
        this.param_6 = param_6;
    }

    //#endregion
}
