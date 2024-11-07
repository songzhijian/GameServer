package com.jx.config.model;

import com.jx.config.loader.ArenaBountyConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Arena_Bounty.xml
*/
public class ArenaBountyConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**积分*/
    private final int integral;
    /**奖励*/
    private final int[][] reward;

    /**
     * 获取所有配置
     */
    public static List<ArenaBountyConfig> findAll(){
        return ArenaBountyConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ArenaBountyConfig getByKey(int key){
        return ArenaBountyConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 积分
     */
    public int getIntegral() {
        return integral;
    }

    /**
     * 奖励
     */
    public int[][] getReward() {
        return reward;
    }

    //#endregion

    //#region 构造函数

    public ArenaBountyConfig(int id, int integral, int[][] reward){
        this.id = id;
        this.integral = integral;
        this.reward = reward;
    }

    //#endregion
}
