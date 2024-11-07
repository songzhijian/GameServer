package com.jx.config.model;

import com.jx.config.loader.EquipNauticsDetailConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Equip_Nautics_Detail.xml
*/
public class EquipNauticsDetailConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**阶段*/
    private final int quality;
    /**图标*/
    private final String icon;
    /**effStar0*/
    private final int[][] effStar0;
    /**effStar1*/
    private final int[][] effStar1;
    /**effStar2*/
    private final int[][] effStar2;
    /**effStar3*/
    private final int[][] effStar3;
    /**effStar4*/
    private final int[][] effStar4;
    /**effStar5*/
    private final int[][] effStar5;
    /**被动效果-0星*/
    private final int[][] passiveEffStar0;
    /**被动效果-1星*/
    private final int[][] passiveEffStar1;
    /**被动效果-2星*/
    private final int[][] passiveEffStar2;
    /**被动效果-3星*/
    private final int[][] passiveEffStar3;
    /**被动效果-4星*/
    private final int[][] passiveEffStar4;
    /**被动效果-5星*/
    private final int[][] passiveEffStar5;
    /**强化上限*/
    private final int upLimit;
    /**回收碎片*/
    private final int debris;

    /**
     * 获取所有配置
     */
    public static List<EquipNauticsDetailConfig> findAll(){
        return EquipNauticsDetailConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static EquipNauticsDetailConfig getByKey(int key){
        return EquipNauticsDetailConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 阶段
     */
    public int getQuality() {
        return quality;
    }

    /**
     * 图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * effStar0
     */
    public int[][] getEffStar0() {
        return effStar0;
    }

    /**
     * effStar1
     */
    public int[][] getEffStar1() {
        return effStar1;
    }

    /**
     * effStar2
     */
    public int[][] getEffStar2() {
        return effStar2;
    }

    /**
     * effStar3
     */
    public int[][] getEffStar3() {
        return effStar3;
    }

    /**
     * effStar4
     */
    public int[][] getEffStar4() {
        return effStar4;
    }

    /**
     * effStar5
     */
    public int[][] getEffStar5() {
        return effStar5;
    }

    /**
     * 被动效果-0星
     */
    public int[][] getPassiveEffStar0() {
        return passiveEffStar0;
    }

    /**
     * 被动效果-1星
     */
    public int[][] getPassiveEffStar1() {
        return passiveEffStar1;
    }

    /**
     * 被动效果-2星
     */
    public int[][] getPassiveEffStar2() {
        return passiveEffStar2;
    }

    /**
     * 被动效果-3星
     */
    public int[][] getPassiveEffStar3() {
        return passiveEffStar3;
    }

    /**
     * 被动效果-4星
     */
    public int[][] getPassiveEffStar4() {
        return passiveEffStar4;
    }

    /**
     * 被动效果-5星
     */
    public int[][] getPassiveEffStar5() {
        return passiveEffStar5;
    }

    /**
     * 强化上限
     */
    public int getUpLimit() {
        return upLimit;
    }

    /**
     * 回收碎片
     */
    public int getDebris() {
        return debris;
    }

    //#endregion

    //#region 构造函数

    public EquipNauticsDetailConfig(int id, int quality, String icon, int[][] effStar0, int[][] effStar1, int[][] effStar2, int[][] effStar3, int[][] effStar4, int[][] effStar5, int[][] passiveEffStar0, int[][] passiveEffStar1, int[][] passiveEffStar2, int[][] passiveEffStar3, int[][] passiveEffStar4, int[][] passiveEffStar5, int upLimit, int debris){
        this.id = id;
        this.quality = quality;
        this.icon = icon;
        this.effStar0 = effStar0;
        this.effStar1 = effStar1;
        this.effStar2 = effStar2;
        this.effStar3 = effStar3;
        this.effStar4 = effStar4;
        this.effStar5 = effStar5;
        this.passiveEffStar0 = passiveEffStar0;
        this.passiveEffStar1 = passiveEffStar1;
        this.passiveEffStar2 = passiveEffStar2;
        this.passiveEffStar3 = passiveEffStar3;
        this.passiveEffStar4 = passiveEffStar4;
        this.passiveEffStar5 = passiveEffStar5;
        this.upLimit = upLimit;
        this.debris = debris;
    }

    //#endregion
}
