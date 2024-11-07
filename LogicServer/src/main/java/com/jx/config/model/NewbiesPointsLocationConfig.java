package com.jx.config.model;

import com.jx.config.loader.NewbiesPointsLocationConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Newbies_Points_Location.xml
*/
public class NewbiesPointsLocationConfig extends AbstractConfig implements IConfig {

    /**键值*/
    private final int id;
    /**交互点id*/
    private final int pointid;
    /**出生位置*/
    private final int[] birthPoint;
    /**刷新条件*/
    private final long[][] condition;
    /**完成条件*/
    private final int[][] Completion;
    /**完成奖励*/
    private final int[][] interactionReward;

    /**
     * 获取所有配置
     */
    public static List<NewbiesPointsLocationConfig> findAll(){
        return NewbiesPointsLocationConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static NewbiesPointsLocationConfig getByKey(int key){
        return NewbiesPointsLocationConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * 键值
     */
    public int getId() {
        return id;
    }

    /**
     * 交互点id
     */
    public int getPointid() {
        return pointid;
    }

    /**
     * 出生位置
     */
    public int[] getBirthPoint() {
        return birthPoint;
    }

    /**
     * 刷新条件
     */
    public long[][] getCondition() {
        return condition;
    }

    /**
     * 完成条件
     */
    public int[][] getCompletion() {
        return Completion;
    }

    /**
     * 完成奖励
     */
    public int[][] getInteractionReward() {
        return interactionReward;
    }

    //#endregion

    //#region 构造函数

    public NewbiesPointsLocationConfig(int id, int pointid, int[] birthPoint, long[][] condition, int[][] Completion, int[][] interactionReward){
        this.id = id;
        this.pointid = pointid;
        this.birthPoint = birthPoint;
        this.condition = condition;
        this.Completion = Completion;
        this.interactionReward = interactionReward;
    }

    //#endregion
}
