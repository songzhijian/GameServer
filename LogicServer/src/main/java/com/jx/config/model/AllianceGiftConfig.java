package com.jx.config.model;

import com.jx.config.loader.AllianceGiftConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Alliance_Gift.xml
*/
public class AllianceGiftConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**礼物类型*/
    private final int type;
    /**宝箱奖励*/
    private final int[][] reward;
    /**宝藏经验*/
    private final int allianceGiftExp;
    /**宝藏钥匙*/
    private final int allianceGiftKey;
    /**是否需要显示玩家名字*/
    private final int showName;
    /**持续时间*/
    private final int duration;

    /**
     * 获取所有配置
     */
    public static List<AllianceGiftConfig> findAll(){
        return AllianceGiftConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static AllianceGiftConfig getByKey(int key){
        return AllianceGiftConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 礼物类型
     */
    public int getType() {
        return type;
    }

    /**
     * 宝箱奖励
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 宝藏经验
     */
    public int getAllianceGiftExp() {
        return allianceGiftExp;
    }

    /**
     * 宝藏钥匙
     */
    public int getAllianceGiftKey() {
        return allianceGiftKey;
    }

    /**
     * 是否需要显示玩家名字
     */
    public int getShowName() {
        return showName;
    }

    /**
     * 持续时间
     */
    public int getDuration() {
        return duration;
    }

    //#endregion

    //#region 构造函数

    public AllianceGiftConfig(int id, int type, int[][] reward, int allianceGiftExp, int allianceGiftKey, int showName, int duration){
        this.id = id;
        this.type = type;
        this.reward = reward;
        this.allianceGiftExp = allianceGiftExp;
        this.allianceGiftKey = allianceGiftKey;
        this.showName = showName;
        this.duration = duration;
    }

    //#endregion
}
