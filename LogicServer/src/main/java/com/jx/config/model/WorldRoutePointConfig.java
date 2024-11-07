package com.jx.config.model;

import com.jx.config.loader.WorldRoutePointConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 World_Route_Point.xml
*/
public class WorldRoutePointConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**类型【1=港口节点，2=自由节点】*/
    private final int type;
    /**归属港口*/
    private final String port;
    /**航路*/
    private final int[] shipRoute;

    /**
     * 获取所有配置
     */
    public static List<WorldRoutePointConfig> findAll(){
        return WorldRoutePointConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static WorldRoutePointConfig getByKey(int key){
        return WorldRoutePointConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 类型【1=港口节点，2=自由节点】
     */
    public int getType() {
        return type;
    }

    /**
     * 归属港口
     */
    public String getPort() {
        return port;
    }

    /**
     * 航路
     */
    public int[] getShipRoute() {
        return shipRoute;
    }

    //#endregion

    //#region 构造函数

    public WorldRoutePointConfig(int id, int type, String port, int[] shipRoute){
        this.id = id;
        this.type = type;
        this.port = port;
        this.shipRoute = shipRoute;
    }

    //#endregion
}
