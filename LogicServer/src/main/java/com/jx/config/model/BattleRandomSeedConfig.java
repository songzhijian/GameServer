package com.jx.config.model;

import com.jx.config.loader.BattleRandomSeedConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Battle_Random_Seed.xml
*/
public class BattleRandomSeedConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**种子值*/
    private final int[] value;

    /**
     * 获取所有配置
     */
    public static List<BattleRandomSeedConfig> findAll(){
        return BattleRandomSeedConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static BattleRandomSeedConfig getByKey(int key){
        return BattleRandomSeedConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 种子值
     */
    public int[] getValue() {
        return value;
    }

    //#endregion

    //#region 构造函数

    public BattleRandomSeedConfig(int id, int[] value){
        this.id = id;
        this.value = value;
    }

    //#endregion
}
