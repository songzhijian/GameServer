package com.jx.config.model;

import com.jx.config.loader.WorldResourcePointConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 World_Resource_Point.xml
*/
public class WorldResourcePointConfig extends AbstractConfig implements IConfig {

    /**序列*/
    private final int id;
    /**资源点等级*/
    private final int level;
    /**资源类型*/
    private final int resourceType;
    /**资源含量*/
    private final int pointNum;
    /**资源点寿命H*/
    private final int lifeTime;
    /**资源点消失后再刷新h*/
    private final int refreshTime;
    /**每秒采集数量*/
    private final double baseCollectSpeed;

    /**
     * 获取所有配置
     */
    public static List<WorldResourcePointConfig> findAll(){
        return WorldResourcePointConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WorldResourcePointConfig getByKey(int key){
        return WorldResourcePointConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 序列
     */
    public int getId() {
        return id;
    }

    /**
     * 资源点等级
     */
    public int getLevel() {
        return level;
    }

    /**
     * 资源类型
     */
    public int getResourceType() {
        return resourceType;
    }

    /**
     * 资源含量
     */
    public int getPointNum() {
        return pointNum;
    }

    /**
     * 资源点寿命H
     */
    public int getLifeTime() {
        return lifeTime;
    }

    /**
     * 资源点消失后再刷新h
     */
    public int getRefreshTime() {
        return refreshTime;
    }

    /**
     * 每秒采集数量
     */
    public double getBaseCollectSpeed() {
        return baseCollectSpeed;
    }

    //#endregion

    //#region 构造函数

    public WorldResourcePointConfig(int id, int level, int resourceType, int pointNum, int lifeTime, int refreshTime, double baseCollectSpeed){
        this.id = id;
        this.level = level;
        this.resourceType = resourceType;
        this.pointNum = pointNum;
        this.lifeTime = lifeTime;
        this.refreshTime = refreshTime;
        this.baseCollectSpeed = baseCollectSpeed;
    }

    //#endregion
}
