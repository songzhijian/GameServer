package com.jx.config.model;

import com.jx.config.loader.GachaCheatCountConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Gacha_Cheat_Count.xml
*/
public class GachaCheatCountConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**人生普通抽紫卡次数【左闭右开】*/
    private final int[] careerCount;
    /**作弊概率[万分位]*/
    private final int cheatP;

    /**
     * 获取所有配置
     */
    public static List<GachaCheatCountConfig> findAll(){
        return GachaCheatCountConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static GachaCheatCountConfig getByKey(int key){
        return GachaCheatCountConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 人生普通抽紫卡次数【左闭右开】
     */
    public int[] getCareerCount() {
        return careerCount;
    }

    /**
     * 作弊概率[万分位]
     */
    public int getCheatP() {
        return cheatP;
    }

    //#endregion

    //#region 构造函数

    public GachaCheatCountConfig(int id, int[] careerCount, int cheatP){
        this.id = id;
        this.careerCount = careerCount;
        this.cheatP = cheatP;
    }

    //#endregion
}
