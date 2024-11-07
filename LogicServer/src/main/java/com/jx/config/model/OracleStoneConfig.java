package com.jx.config.model;

import com.jx.config.loader.OracleStoneConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Oracle_Stone.xml
*/
public class OracleStoneConfig extends AbstractConfig implements IConfig {

    /**船长室索引*/
    private final int id;
    /**船长室等级*/
    private final int lv;
    /**多少秒回复一点能量*/
    private final int powerRecover;

    /**
     * 获取所有配置
     */
    public static List<OracleStoneConfig> findAll(){
        return OracleStoneConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static OracleStoneConfig getByKey(int key){
        return OracleStoneConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 船长室索引
     */
    public int getId() {
        return id;
    }

    /**
     * 船长室等级
     */
    public int getLv() {
        return lv;
    }

    /**
     * 多少秒回复一点能量
     */
    public int getPowerRecover() {
        return powerRecover;
    }

    //#endregion

    //#region 构造函数

    public OracleStoneConfig(int id, int lv, int powerRecover){
        this.id = id;
        this.lv = lv;
        this.powerRecover = powerRecover;
    }

    //#endregion
}
