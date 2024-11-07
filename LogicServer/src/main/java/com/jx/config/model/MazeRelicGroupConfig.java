package com.jx.config.model;

import com.jx.config.loader.MazeRelicGroupConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Maze_Relic_Group.xml
*/
public class MazeRelicGroupConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**遗物列表*/
    private final int[] relicList;
    /**基础权重*/
    private final int baseWeight;
    /**额外权重【区间上限，权重】*/
    private final int[][] extraWeight;

    /**
     * 获取所有配置
     */
    public static List<MazeRelicGroupConfig> findAll(){
        return MazeRelicGroupConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MazeRelicGroupConfig getByKey(int key){
        return MazeRelicGroupConfigLoader.getByKey(key);
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
     * 基础权重
     */
    public int getBaseWeight() {
        return baseWeight;
    }

    /**
     * 额外权重【区间上限，权重】
     */
    public int[][] getExtraWeight() {
        return extraWeight;
    }

    //#endregion

    //#region 构造函数

    public MazeRelicGroupConfig(int id, int[] relicList, int baseWeight, int[][] extraWeight){
        this.id = id;
        this.relicList = relicList;
        this.baseWeight = baseWeight;
        this.extraWeight = extraWeight;
    }

    //#endregion
}
