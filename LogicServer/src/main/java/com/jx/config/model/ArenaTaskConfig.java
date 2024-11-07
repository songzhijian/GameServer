package com.jx.config.model;

import com.jx.config.loader.ArenaTaskConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Arena_Task.xml
*/
public class ArenaTaskConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**可接取VIP等级*/
    private final int vip;
    /**积分目标*/
    private final int need;
    /**达成奖励*/
    private final int[][] reward;

    /**
     * 获取所有配置
     */
    public static List<ArenaTaskConfig> findAll(){
        return ArenaTaskConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ArenaTaskConfig getByKey(int key){
        return ArenaTaskConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 可接取VIP等级
     */
    public int getVip() {
        return vip;
    }

    /**
     * 积分目标
     */
    public int getNeed() {
        return need;
    }

    /**
     * 达成奖励
     */
    public int[][] getReward() {
        return reward;
    }

    //#endregion

    //#region 构造函数

    public ArenaTaskConfig(int id, int vip, int need, int[][] reward){
        this.id = id;
        this.vip = vip;
        this.need = need;
        this.reward = reward;
    }

    //#endregion
}
