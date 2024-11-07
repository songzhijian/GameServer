package com.jx.config.model;

import com.jx.config.loader.ActivityLoginConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Activity_Login.xml
*/
public class ActivityLoginConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**奖励*/
    private final int[][] reward;

    /**
     * 获取所有配置
     */
    public static List<ActivityLoginConfig> findAll(){
        return ActivityLoginConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ActivityLoginConfig getByKey(int key){
        return ActivityLoginConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 奖励
     */
    public int[][] getReward() {
        return reward;
    }

    //#endregion

    //#region 构造函数

    public ActivityLoginConfig(int id, int[][] reward){
        this.id = id;
        this.reward = reward;
    }

    //#endregion
}
