package com.jx.config.model;

import com.jx.config.loader.TranSportGoodConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 TranSportGood.xml
*/
public class TranSportGoodConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**开始坐标（x,y）*/
    private final int[] startPos;
    /**结束港口*/
    private final int endPortId;
    /**开始引导坐标*/
    private final int[] startPosPoint;
    /**结束引导坐标*/
    private final int[] endPortPoint;

    /**
     * 获取所有配置
     */
    public static List<TranSportGoodConfig> findAll(){
        return TranSportGoodConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TranSportGoodConfig getByKey(int key){
        return TranSportGoodConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 开始坐标（x,y）
     */
    public int[] getStartPos() {
        return startPos;
    }

    /**
     * 结束港口
     */
    public int getEndPortId() {
        return endPortId;
    }

    /**
     * 开始引导坐标
     */
    public int[] getStartPosPoint() {
        return startPosPoint;
    }

    /**
     * 结束引导坐标
     */
    public int[] getEndPortPoint() {
        return endPortPoint;
    }

    //#endregion

    //#region 构造函数

    public TranSportGoodConfig(int id, int[] startPos, int endPortId, int[] startPosPoint, int[] endPortPoint){
        this.id = id;
        this.startPos = startPos;
        this.endPortId = endPortId;
        this.startPosPoint = startPosPoint;
        this.endPortPoint = endPortPoint;
    }

    //#endregion
}
