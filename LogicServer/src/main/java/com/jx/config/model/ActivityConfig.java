package com.jx.config.model;

import com.jx.config.loader.ActivityConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Activity.xml
*/
public class ActivityConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**活动类型*/
    private final int type;
    /**活动附加参数*/
    private final int[] param;
    /**活动附加参数2*/
    private final int[] param2;
    /**活动预览时间 单位 秒*/
    private final int previewTime;
    /**时间方式*/
    private final String[] time;
    /**服务器限制条件*/
    private final long[][] serverCondition;
    /**个人限制条件*/
    private final long[][] personCondition;
    /**排行榜*/
    private final int rank;
    /**数据关联方式*/
    private final int associativeType;
    /**服务器id*/
    private final int[][][] serverIds;
    /**是否主动通知玩家*/
    private final boolean activeNotification;
    /**事件*/
    private final int[] event;
    /**活动开始前多少分钟广播*/
    private final int[] startMarqueeTime;
    /**广播id*/
    private final int marqueeId;
    /**活动奖励*/
    private final int[][] reward;
    /**活动邮件*/
    private final int mail;
    /**功能开关*/
    private final int functionOn;
    /**是否是个人活动*/
    private final int ifPersonal;
    /**是否每日重置*/
    private final boolean isDailyReset;

    /**
     * 获取所有配置
     */
    public static List<ActivityConfig> findAll(){
        return ActivityConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ActivityConfig getByKey(int key){
        return ActivityConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 活动类型
     */
    public int getType() {
        return type;
    }

    /**
     * 活动附加参数
     */
    public int[] getParam() {
        return param;
    }

    /**
     * 活动附加参数2
     */
    public int[] getParam2() {
        return param2;
    }

    /**
     * 活动预览时间 单位 秒
     */
    public int getPreviewTime() {
        return previewTime;
    }

    /**
     * 时间方式
     */
    public String[] getTime() {
        return time;
    }

    /**
     * 服务器限制条件
     */
    public long[][] getServerCondition() {
        return serverCondition;
    }

    /**
     * 个人限制条件
     */
    public long[][] getPersonCondition() {
        return personCondition;
    }

    /**
     * 排行榜
     */
    public int getRank() {
        return rank;
    }

    /**
     * 数据关联方式
     */
    public int getAssociativeType() {
        return associativeType;
    }

    /**
     * 服务器id
     */
    public int[][][] getServerIds() {
        return serverIds;
    }

    /**
     * 是否主动通知玩家
     */
    public boolean isActiveNotification() {
        return activeNotification;
    }

    /**
     * 事件
     */
    public int[] getEvent() {
        return event;
    }

    /**
     * 活动开始前多少分钟广播
     */
    public int[] getStartMarqueeTime() {
        return startMarqueeTime;
    }

    /**
     * 广播id
     */
    public int getMarqueeId() {
        return marqueeId;
    }

    /**
     * 活动奖励
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 活动邮件
     */
    public int getMail() {
        return mail;
    }

    /**
     * 功能开关
     */
    public int getFunctionOn() {
        return functionOn;
    }

    /**
     * 是否是个人活动
     */
    public int getIfPersonal() {
        return ifPersonal;
    }

    /**
     * 是否每日重置
     */
    public boolean isIsDailyReset() {
        return isDailyReset;
    }

    //#endregion

    //#region 构造函数

    public ActivityConfig(int id, int type, int[] param, int[] param2, int previewTime, String[] time, long[][] serverCondition, long[][] personCondition, int rank, int associativeType, int[][][] serverIds, boolean activeNotification, int[] event, int[] startMarqueeTime, int marqueeId, int[][] reward, int mail, int functionOn, int ifPersonal, boolean isDailyReset){
        this.id = id;
        this.type = type;
        this.param = param;
        this.param2 = param2;
        this.previewTime = previewTime;
        this.time = time;
        this.serverCondition = serverCondition;
        this.personCondition = personCondition;
        this.rank = rank;
        this.associativeType = associativeType;
        this.serverIds = serverIds;
        this.activeNotification = activeNotification;
        this.event = event;
        this.startMarqueeTime = startMarqueeTime;
        this.marqueeId = marqueeId;
        this.reward = reward;
        this.mail = mail;
        this.functionOn = functionOn;
        this.ifPersonal = ifPersonal;
        this.isDailyReset = isDailyReset;
    }

    //#endregion
}
