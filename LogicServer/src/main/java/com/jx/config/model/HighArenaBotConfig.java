package com.jx.config.model;

import com.jx.config.loader.HighArenaBotConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 HighArena_Bot.xml
*/
public class HighArenaBotConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**名称*/
    private final String name;
    /**头像*/
    private final String icon;
    /**战斗信息*/
    private final int battle;
    /**积分*/
    private final int integral;
    /**淘汰积分*/
    private final int elimination;

    /**
     * 获取所有配置
     */
    public static List<HighArenaBotConfig> findAll(){
        return HighArenaBotConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HighArenaBotConfig getByKey(int key){
        return HighArenaBotConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 头像
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 战斗信息
     */
    public int getBattle() {
        return battle;
    }

    /**
     * 积分
     */
    public int getIntegral() {
        return integral;
    }

    /**
     * 淘汰积分
     */
    public int getElimination() {
        return elimination;
    }

    //#endregion

    //#region 构造函数

    public HighArenaBotConfig(int id, String name, String icon, int battle, int integral, int elimination){
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.battle = battle;
        this.integral = integral;
        this.elimination = elimination;
    }

    //#endregion
}