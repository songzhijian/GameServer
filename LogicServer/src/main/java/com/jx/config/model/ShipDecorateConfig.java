package com.jx.config.model;

import com.jx.config.loader.ShipDecorateConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Ship_Decorate.xml
*/
public class ShipDecorateConfig extends AbstractConfig implements IConfig {

    /**id【房间id=groupid+等级】*/
    private final int id;
    /**group*/
    private final int group;

    /**
     * 获取所有配置
     */
    public static List<ShipDecorateConfig> findAll(){
        return ShipDecorateConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ShipDecorateConfig getByKey(int key){
        return ShipDecorateConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id【房间id=groupid+等级】
     */
    public int getId() {
        return id;
    }

    /**
     * group
     */
    public int getGroup() {
        return group;
    }

    //#endregion

    //#region 构造函数

    public ShipDecorateConfig(int id, int group){
        this.id = id;
        this.group = group;
    }

    //#endregion
}
