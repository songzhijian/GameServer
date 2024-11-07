package com.jx.config.model;

import com.jx.config.loader.PointsConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Points.xml
*/
public class PointsConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**关联活动*/
    private final int activityId;

    /**
     * 获取所有配置
     */
    public static List<PointsConfig> findAll(){
        return PointsConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static PointsConfig getByKey(int key){
        return PointsConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 关联活动
     */
    public int getActivityId() {
        return activityId;
    }

    //#endregion

    //#region 构造函数

    public PointsConfig(int id, int activityId){
        this.id = id;
        this.activityId = activityId;
    }

    //#endregion
}
