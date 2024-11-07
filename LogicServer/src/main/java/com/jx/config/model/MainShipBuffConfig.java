package com.jx.config.model;

import com.jx.config.loader.MainShipBuffConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Main_Ship_Buff.xml
*/
public class MainShipBuffConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**持续时间*/
    private final int Duration;
    /**作用号*/
    private final int[][] Effects;
    /**是否显示在头像旁边*/
    private final int isShow;
    /**分组*/
    private final int group;
    /**分组叠加方式*/
    private final int overlap;

    /**
     * 获取所有配置
     */
    public static List<MainShipBuffConfig> findAll(){
        return MainShipBuffConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MainShipBuffConfig getByKey(int key){
        return MainShipBuffConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 持续时间
     */
    public int getDuration() {
        return Duration;
    }

    /**
     * 作用号
     */
    public int[][] getEffects() {
        return Effects;
    }

    /**
     * 是否显示在头像旁边
     */
    public int getIsShow() {
        return isShow;
    }

    /**
     * 分组
     */
    public int getGroup() {
        return group;
    }

    /**
     * 分组叠加方式
     */
    public int getOverlap() {
        return overlap;
    }

    //#endregion

    //#region 构造函数

    public MainShipBuffConfig(int id, int Duration, int[][] Effects, int isShow, int group, int overlap){
        this.id = id;
        this.Duration = Duration;
        this.Effects = Effects;
        this.isShow = isShow;
        this.group = group;
        this.overlap = overlap;
    }

    //#endregion
}
