package com.jx.config.model;

import com.jx.config.loader.MazeRelicBondConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Maze_Relic_Bond.xml
*/
public class MazeRelicBondConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**遗物列表*/
    private final int[] relicList;
    /**羁绊效果*/
    private final int newRelic;

    /**
     * 获取所有配置
     */
    public static List<MazeRelicBondConfig> findAll(){
        return MazeRelicBondConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MazeRelicBondConfig getByKey(int key){
        return MazeRelicBondConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 遗物列表
     */
    public int[] getRelicList() {
        return relicList;
    }

    /**
     * 羁绊效果
     */
    public int getNewRelic() {
        return newRelic;
    }

    //#endregion

    //#region 构造函数

    public MazeRelicBondConfig(int id, int[] relicList, int newRelic){
        this.id = id;
        this.relicList = relicList;
        this.newRelic = newRelic;
    }

    //#endregion
}
