package com.jx.config.model;

import com.jx.config.loader.RankConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Rank.xml
*/
public class RankConfig extends AbstractConfig implements IConfig {

    /**排行榜id*/
    private final int id;
    /**数据保存方式*/
    private final int saveDataType;
    /**清除数据类型*/
    private final int rankClearType;
    /**排行榜类型*/
    private final int type;
    /**结算方式*/
    private final int settlementMethod;
    /**结算期时长（秒）*/
    private final int settleDuration;
    /**上榜最小值*/
    private final int minimumValue;
    /**上榜范围*/
    private final int range;
    /**显示范围*/
    private final int showRange;
    /**奖励*/
    private final int[] reward;
    /**奖励发放方式*/
    private final int[] sendType;
    /**是否启用*/
    private final int online;

    /**
     * 获取所有配置
     */
    public static List<RankConfig> findAll(){
        return RankConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static RankConfig getByKey(int key){
        return RankConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 排行榜id
     */
    public int getId() {
        return id;
    }

    /**
     * 数据保存方式
     */
    public int getSaveDataType() {
        return saveDataType;
    }

    /**
     * 清除数据类型
     */
    public int getRankClearType() {
        return rankClearType;
    }

    /**
     * 排行榜类型
     */
    public int getType() {
        return type;
    }

    /**
     * 结算方式
     */
    public int getSettlementMethod() {
        return settlementMethod;
    }

    /**
     * 结算期时长（秒）
     */
    public int getSettleDuration() {
        return settleDuration;
    }

    /**
     * 上榜最小值
     */
    public int getMinimumValue() {
        return minimumValue;
    }

    /**
     * 上榜范围
     */
    public int getRange() {
        return range;
    }

    /**
     * 显示范围
     */
    public int getShowRange() {
        return showRange;
    }

    /**
     * 奖励
     */
    public int[] getReward() {
        return reward;
    }

    /**
     * 奖励发放方式
     */
    public int[] getSendType() {
        return sendType;
    }

    /**
     * 是否启用
     */
    public int getOnline() {
        return online;
    }

    //#endregion

    //#region 构造函数

    public RankConfig(int id, int saveDataType, int rankClearType, int type, int settlementMethod, int settleDuration, int minimumValue, int range, int showRange, int[] reward, int[] sendType, int online){
        this.id = id;
        this.saveDataType = saveDataType;
        this.rankClearType = rankClearType;
        this.type = type;
        this.settlementMethod = settlementMethod;
        this.settleDuration = settleDuration;
        this.minimumValue = minimumValue;
        this.range = range;
        this.showRange = showRange;
        this.reward = reward;
        this.sendType = sendType;
        this.online = online;
    }

    //#endregion
}
