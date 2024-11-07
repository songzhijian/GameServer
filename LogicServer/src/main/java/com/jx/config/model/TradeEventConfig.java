package com.jx.config.model;

import com.jx.config.loader.TradeEventConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Trade_Event.xml
*/
public class TradeEventConfig extends AbstractConfig implements IConfig {

    /**序号*/
    private final int id;
    /**判断优先级*/
    private final int order;
    /**name*/
    private final String name;
    /**img*/
    private final String img;
    /**des*/
    private final String des;
    /**往前检测刷新次数*/
    private final int checkTime;
    /**检测事件*/
    private final int checkType;
    /**出现几率or出现参数[1级城,2级城,x级城]*/
    private final int[] Param;
    /**是否强制覆盖其他事件*/
    private final int isForce;
    /**持续时间*/
    private final int time;
    /**品类影响*/
    private final int affectClass;
    /**波动系数变化*/
    private final int[] trend;
    /**趋势改变*/
    private final int trendTurn;

    /**
     * 获取所有配置
     */
    public static List<TradeEventConfig> findAll(){
        return TradeEventConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TradeEventConfig getByKey(int key){
        return TradeEventConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 序号
     */
    public int getId() {
        return id;
    }

    /**
     * 判断优先级
     */
    public int getOrder() {
        return order;
    }

    /**
     * name
     */
    public String getName() {
        return name;
    }

    /**
     * img
     */
    public String getImg() {
        return img;
    }

    /**
     * des
     */
    public String getDes() {
        return des;
    }

    /**
     * 往前检测刷新次数
     */
    public int getCheckTime() {
        return checkTime;
    }

    /**
     * 检测事件
     */
    public int getCheckType() {
        return checkType;
    }

    /**
     * 出现几率or出现参数[1级城,2级城,x级城]
     */
    public int[] getParam() {
        return Param;
    }

    /**
     * 是否强制覆盖其他事件
     */
    public int getIsForce() {
        return isForce;
    }

    /**
     * 持续时间
     */
    public int getTime() {
        return time;
    }

    /**
     * 品类影响
     */
    public int getAffectClass() {
        return affectClass;
    }

    /**
     * 波动系数变化
     */
    public int[] getTrend() {
        return trend;
    }

    /**
     * 趋势改变
     */
    public int getTrendTurn() {
        return trendTurn;
    }

    //#endregion

    //#region 构造函数

    public TradeEventConfig(int id, int order, String name, String img, String des, int checkTime, int checkType, int[] Param, int isForce, int time, int affectClass, int[] trend, int trendTurn){
        this.id = id;
        this.order = order;
        this.name = name;
        this.img = img;
        this.des = des;
        this.checkTime = checkTime;
        this.checkType = checkType;
        this.Param = Param;
        this.isForce = isForce;
        this.time = time;
        this.affectClass = affectClass;
        this.trend = trend;
        this.trendTurn = trendTurn;
    }

    //#endregion
}
