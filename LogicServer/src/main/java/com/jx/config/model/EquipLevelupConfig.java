package com.jx.config.model;

import com.jx.config.loader.EquipLevelupConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Equip_Levelup.xml
*/
public class EquipLevelupConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int quality;
    /**强化需要经验*/
    private final int[] expCost;

    /**
     * 获取所有配置
     */
    public static List<EquipLevelupConfig> findAll(){
        return EquipLevelupConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static EquipLevelupConfig getByKey(int key){
        return EquipLevelupConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getQuality() {
        return quality;
    }

    /**
     * 强化需要经验
     */
    public int[] getExpCost() {
        return expCost;
    }

    //#endregion

    //#region 构造函数

    public EquipLevelupConfig(int quality, int[] expCost){
        this.quality = quality;
        this.expCost = expCost;
    }

    //#endregion
}
