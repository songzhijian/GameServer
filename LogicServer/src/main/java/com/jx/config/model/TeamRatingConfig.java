package com.jx.config.model;

import com.jx.config.loader.TeamRatingConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Team_Rating.xml
*/
public class TeamRatingConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int level;
    /**累计战力*/
    private final long totalPower;

    /**
     * 获取所有配置
     */
    public static List<TeamRatingConfig> findAll(){
        return TeamRatingConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TeamRatingConfig getByKey(int key){
        return TeamRatingConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getLevel() {
        return level;
    }

    /**
     * 累计战力
     */
    public long getTotalPower() {
        return totalPower;
    }

    //#endregion

    //#region 构造函数

    public TeamRatingConfig(int level, long totalPower){
        this.level = level;
        this.totalPower = totalPower;
    }

    //#endregion
}
