package com.jx.config.model;

import com.jx.config.loader.TowerExtraPointConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Tower_Extra_Point.xml
*/
public class TowerExtraPointConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**随机数量0*/
    private final int type0Count;
    /**随机组0*/
    private final int[][] type0Rand;
    /**随机数量1*/
    private final int type1Count;
    /**随机组1*/
    private final int[][] type1Rand;
    /**随机数量2*/
    private final int type2Count;
    /**随机组2*/
    private final int[][] type2Rand;
    /**随机数量3*/
    private final int type3Count;
    /**随机组3*/
    private final int[][] type3Rand;

    /**
     * 获取所有配置
     */
    public static List<TowerExtraPointConfig> findAll(){
        return TowerExtraPointConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TowerExtraPointConfig getByKey(int key){
        return TowerExtraPointConfigLoader.getByKey(key);
    }

    //#region getter
    public int getId() {
        return id;
    }

    /**
     * 随机数量0
     */
    public int getType0Count() {
        return type0Count;
    }

    /**
     * 随机组0
     */
    public int[][] getType0Rand() {
        return type0Rand;
    }

    /**
     * 随机数量1
     */
    public int getType1Count() {
        return type1Count;
    }

    /**
     * 随机组1
     */
    public int[][] getType1Rand() {
        return type1Rand;
    }

    /**
     * 随机数量2
     */
    public int getType2Count() {
        return type2Count;
    }

    /**
     * 随机组2
     */
    public int[][] getType2Rand() {
        return type2Rand;
    }

    /**
     * 随机数量3
     */
    public int getType3Count() {
        return type3Count;
    }

    /**
     * 随机组3
     */
    public int[][] getType3Rand() {
        return type3Rand;
    }

    //#endregion

    //#region 构造函数

    public TowerExtraPointConfig(int id, int type0Count, int[][] type0Rand, int type1Count, int[][] type1Rand, int type2Count, int[][] type2Rand, int type3Count, int[][] type3Rand){
        this.id = id;
        this.type0Count = type0Count;
        this.type0Rand = type0Rand;
        this.type1Count = type1Count;
        this.type1Rand = type1Rand;
        this.type2Count = type2Count;
        this.type2Rand = type2Rand;
        this.type3Count = type3Count;
        this.type3Rand = type3Rand;
    }

    //#endregion
}
