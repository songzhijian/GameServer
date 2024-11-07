package com.jx.config.model;

import com.jx.config.loader.HighArenaTaskConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 HighArena_Task.xml
*/
public class HighArenaTaskConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**任务类型*/
    private final int type;
    /**目标值*/
    private final int need;
    /**达成奖励*/
    private final int[][] reward;

    /**
     * 获取所有配置
     */
    public static List<HighArenaTaskConfig> findAll(){
        return HighArenaTaskConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static HighArenaTaskConfig getByKey(int key){
        return HighArenaTaskConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 任务类型
     */
    public int getType() {
        return type;
    }

    /**
     * 目标值
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

    public HighArenaTaskConfig(int id, int type, int need, int[][] reward){
        this.id = id;
        this.type = type;
        this.need = need;
        this.reward = reward;
    }

    //#endregion
}
