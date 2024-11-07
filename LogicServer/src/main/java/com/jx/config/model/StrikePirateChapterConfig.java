package com.jx.config.model;

import com.jx.config.loader.StrikePirateChapterConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Strike_Pirate_Chapter.xml
*/
public class StrikePirateChapterConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**赛季*/
    private final int season;
    /**章节包括的Layer*/
    private final int[] layer;

    /**
     * 获取所有配置
     */
    public static List<StrikePirateChapterConfig> findAll(){
        return StrikePirateChapterConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static StrikePirateChapterConfig getByKey(int key){
        return StrikePirateChapterConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 赛季
     */
    public int getSeason() {
        return season;
    }

    /**
     * 章节包括的Layer
     */
    public int[] getLayer() {
        return layer;
    }

    //#endregion

    //#region 构造函数

    public StrikePirateChapterConfig(int id, int season, int[] layer){
        this.id = id;
        this.season = season;
        this.layer = layer;
    }

    //#endregion
}
