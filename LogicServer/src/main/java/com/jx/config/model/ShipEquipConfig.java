package com.jx.config.model;

import com.jx.config.loader.ShipEquipConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Ship_Equip.xml
*/
public class ShipEquipConfig extends AbstractConfig implements IConfig {

    /**id【房间id=groupid+等级】*/
    private final int id;
    /**品质*/
    private final int quality;
    /**group*/
    private final int group;
    /**效果*/
    private final int[][] eff;

    /**
     * 获取所有配置
     */
    public static List<ShipEquipConfig> findAll(){
        return ShipEquipConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ShipEquipConfig getByKey(int key){
        return ShipEquipConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id【房间id=groupid+等级】
     */
    public int getId() {
        return id;
    }

    /**
     * 品质
     */
    public int getQuality() {
        return quality;
    }

    /**
     * group
     */
    public int getGroup() {
        return group;
    }

    /**
     * 效果
     */
    public int[][] getEff() {
        return eff;
    }

    //#endregion

    //#region 构造函数

    public ShipEquipConfig(int id, int quality, int group, int[][] eff){
        this.id = id;
        this.quality = quality;
        this.group = group;
        this.eff = eff;
    }

    //#endregion
}
