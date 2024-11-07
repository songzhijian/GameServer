package com.jx.config.model;

import com.jx.config.loader.TradeTrendConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Trade_Trend.xml
*/
public class TradeTrendConfig extends AbstractConfig implements IConfig {

    /**序号*/
    private final int id;
    /**波动区间*/
    private final int[] section;
    /**单次变化的步长 
[趋势向上时步长范围，趋势向下时步长范围]*/
    private final int[][] speedStep;
    /**趋势方向改变概率
 [趋势上升时改变的概率，趋势下降时改变的概率]*/
    private final int[] trendChangeProb;

    /**
     * 获取所有配置
     */
    public static List<TradeTrendConfig> findAll(){
        return TradeTrendConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TradeTrendConfig getByKey(int key){
        return TradeTrendConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 序号
     */
    public int getId() {
        return id;
    }

    /**
     * 波动区间
     */
    public int[] getSection() {
        return section;
    }

    /**
     * 单次变化的步长 
[趋势向上时步长范围，趋势向下时步长范围]
     */
    public int[][] getSpeedStep() {
        return speedStep;
    }

    /**
     * 趋势方向改变概率
 [趋势上升时改变的概率，趋势下降时改变的概率]
     */
    public int[] getTrendChangeProb() {
        return trendChangeProb;
    }

    //#endregion

    //#region 构造函数

    public TradeTrendConfig(int id, int[] section, int[][] speedStep, int[] trendChangeProb){
        this.id = id;
        this.section = section;
        this.speedStep = speedStep;
        this.trendChangeProb = trendChangeProb;
    }

    //#endregion
}
