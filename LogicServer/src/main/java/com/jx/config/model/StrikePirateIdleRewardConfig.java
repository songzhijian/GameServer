package com.jx.config.model;

import com.jx.config.loader.StrikePirateIdleRewardConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Strike_Pirate_Idle_Reward.xml
*/
public class StrikePirateIdleRewardConfig extends AbstractConfig implements IConfig {

    /**索引*/
    private final int id;
    /**一次性掉落[RandomGroupid,数量]*/
    private final int[] disposableOutput;
    /**经验产出[触发时间,RandomGroupid,数量]*/
    private final int[] exp;
    /**粉尘产出[触发时间,RandomGroupid,数量]*/
    private final int[] dust;
    /**方晶产出[触发时间,RandomGroupid,数量]*/
    private final int[] tech;
    /**装备产出队列1[触发时间,RandomGroupid,数量]*/
    private final int[] output1;
    /**装备产出队列2[触发时间,RandomGroupid,数量]*/
    private final int[] output2;
    /**装备产出队列3[触发时间,RandomGroupid,数量]*/
    private final int[] output3;
    /**装备产出队列4[触发时间,RandomGroupid,数量]*/
    private final int[] output4;
    /**装备产出队列5[触发时间,RandomGroupid,数量]*/
    private final int[] output5;
    /**装备产出队列6[触发时间,RandomGroupid,数量]*/
    private final int[] output6;
    /**装备产出队列7[触发时间,RandomGroupid,数量]*/
    private final int[] output7;
    /**装备产出队列8[触发时间,RandomGroupid,数量]*/
    private final int[] output8;
    /**装备产出队列9[触发时间,RandomGroupid,数量]*/
    private final int[] output9;

    /**
     * 获取所有配置
     */
    public static List<StrikePirateIdleRewardConfig> findAll(){
        return StrikePirateIdleRewardConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static StrikePirateIdleRewardConfig getByKey(int key){
        return StrikePirateIdleRewardConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 索引
     */
    public int getId() {
        return id;
    }

    /**
     * 一次性掉落[RandomGroupid,数量]
     */
    public int[] getDisposableOutput() {
        return disposableOutput;
    }

    /**
     * 经验产出[触发时间,RandomGroupid,数量]
     */
    public int[] getExp() {
        return exp;
    }

    /**
     * 粉尘产出[触发时间,RandomGroupid,数量]
     */
    public int[] getDust() {
        return dust;
    }

    /**
     * 方晶产出[触发时间,RandomGroupid,数量]
     */
    public int[] getTech() {
        return tech;
    }

    /**
     * 装备产出队列1[触发时间,RandomGroupid,数量]
     */
    public int[] getOutput1() {
        return output1;
    }

    /**
     * 装备产出队列2[触发时间,RandomGroupid,数量]
     */
    public int[] getOutput2() {
        return output2;
    }

    /**
     * 装备产出队列3[触发时间,RandomGroupid,数量]
     */
    public int[] getOutput3() {
        return output3;
    }

    /**
     * 装备产出队列4[触发时间,RandomGroupid,数量]
     */
    public int[] getOutput4() {
        return output4;
    }

    /**
     * 装备产出队列5[触发时间,RandomGroupid,数量]
     */
    public int[] getOutput5() {
        return output5;
    }

    /**
     * 装备产出队列6[触发时间,RandomGroupid,数量]
     */
    public int[] getOutput6() {
        return output6;
    }

    /**
     * 装备产出队列7[触发时间,RandomGroupid,数量]
     */
    public int[] getOutput7() {
        return output7;
    }

    /**
     * 装备产出队列8[触发时间,RandomGroupid,数量]
     */
    public int[] getOutput8() {
        return output8;
    }

    /**
     * 装备产出队列9[触发时间,RandomGroupid,数量]
     */
    public int[] getOutput9() {
        return output9;
    }

    //#endregion

    //#region 构造函数

    public StrikePirateIdleRewardConfig(int id, int[] disposableOutput, int[] exp, int[] dust, int[] tech, int[] output1, int[] output2, int[] output3, int[] output4, int[] output5, int[] output6, int[] output7, int[] output8, int[] output9){
        this.id = id;
        this.disposableOutput = disposableOutput;
        this.exp = exp;
        this.dust = dust;
        this.tech = tech;
        this.output1 = output1;
        this.output2 = output2;
        this.output3 = output3;
        this.output4 = output4;
        this.output5 = output5;
        this.output6 = output6;
        this.output7 = output7;
        this.output8 = output8;
        this.output9 = output9;
    }

    //#endregion
}
