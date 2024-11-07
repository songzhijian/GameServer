package com.jx.config.model;

import com.jx.config.loader.GachaCheatPoolConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Gacha_Cheat_Pool.xml
*/
public class GachaCheatPoolConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**行为-参数*/
    private final int[] behavior;
    /**卡池*/
    private final int cheatP;

    /**
     * 获取所有配置
     */
    public static List<GachaCheatPoolConfig> findAll(){
        return GachaCheatPoolConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static GachaCheatPoolConfig getByKey(int key){
        return GachaCheatPoolConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 行为-参数
     */
    public int[] getBehavior() {
        return behavior;
    }

    /**
     * 卡池
     */
    public int getCheatP() {
        return cheatP;
    }

    //#endregion

    //#region 构造函数

    public GachaCheatPoolConfig(int id, int[] behavior, int cheatP){
        this.id = id;
        this.behavior = behavior;
        this.cheatP = cheatP;
    }

    //#endregion
}
