package com.jx.config.model;

import com.jx.config.loader.SearchConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Search.xml
*/
public class SearchConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**场景对象类型：：4=怪物_World_Monster，5=资源_World_Resource_Point*/
    private final int sceneUnitType;
    /**对象类型id*/
    private final int typeId;
    /**最小搜索等级*/
    private final int minLv;
    /**最大搜索等级*/
    private final int maxLv;
    /**搜索范围*/
    private final int[][] searchRange;
    /**强制刷新等级，如果搜索目标低于该等级，并且没有搜到，则刷一个出来*/
    private final int maxRefreshLv;
    /**searchRadius*/
    private final int searchRadius;

    /**
     * 获取所有配置
     */
    public static List<SearchConfig> findAll(){
        return SearchConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static SearchConfig getByKey(int key){
        return SearchConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 场景对象类型：：4=怪物_World_Monster，5=资源_World_Resource_Point
     */
    public int getSceneUnitType() {
        return sceneUnitType;
    }

    /**
     * 对象类型id
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * 最小搜索等级
     */
    public int getMinLv() {
        return minLv;
    }

    /**
     * 最大搜索等级
     */
    public int getMaxLv() {
        return maxLv;
    }

    /**
     * 搜索范围
     */
    public int[][] getSearchRange() {
        return searchRange;
    }

    /**
     * 强制刷新等级，如果搜索目标低于该等级，并且没有搜到，则刷一个出来
     */
    public int getMaxRefreshLv() {
        return maxRefreshLv;
    }

    public int getSearchRadius() {
        return searchRadius;
    }

    //#endregion

    //#region 构造函数

    public SearchConfig(int id, int sceneUnitType, int typeId, int minLv, int maxLv, int[][] searchRange, int maxRefreshLv, int searchRadius){
        this.id = id;
        this.sceneUnitType = sceneUnitType;
        this.typeId = typeId;
        this.minLv = minLv;
        this.maxLv = maxLv;
        this.searchRange = searchRange;
        this.maxRefreshLv = maxRefreshLv;
        this.searchRadius = searchRadius;
    }

    //#endregion
}
