package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ActivityType
 */
public enum ActivityType {

    /**
     * 
     */
    ACTIVITY_TYPE_1(1),

    /**
     * 
     */
    ACTIVITY_TYPE_2(2),

    /**
     * 天下大势
     */
    SERVER_TREND(3),

    /**
     * 个人军备
     */
    PERSONAL_ARMAMENTS(4),

    /**
     * 7日登录
     */
    LOGIN_ACTIVITY(5),

    /**
     * 开服嘉年华
     */
    ACTIVITY_CARNIVAL(6),

    /**
     * 冲榜活动
     */
    CLIMB_RANK(7),

    /**
     * 在线活动
     */
    ONLINE_ACTIVITY(8),

    /**
     * 累充活动
     */
    RECHARGE_ACTIVITY(9),

    /**
     * battlepass
     */
    BATTLEPASS_ACTIVITY(10),

    /**
     * 在线活动（每日重置版）
     */
    ONLINE_DAILY_ACTIVITY(11),

    /**
     * 联盟BOSS
     */
    ALLIANCE_BOSS(12),

    /**
     * 单服排行榜
     */
    SINGLE_SERVER_RANK(13),

    /**
     * 押镖活动
     */
    TRANSPORTGOODS_ACTIVITY(14),

    ;
    private int value;

    public static ActivityType[] ARRAY = {
            ACTIVITY_TYPE_1,
            ACTIVITY_TYPE_2,
            SERVER_TREND,
            PERSONAL_ARMAMENTS,
            LOGIN_ACTIVITY,
            ACTIVITY_CARNIVAL,
            CLIMB_RANK,
            ONLINE_ACTIVITY,
            RECHARGE_ACTIVITY,
            BATTLEPASS_ACTIVITY,
            ONLINE_DAILY_ACTIVITY,
            ALLIANCE_BOSS,
            SINGLE_SERVER_RANK,
            TRANSPORTGOODS_ACTIVITY
    };

    ActivityType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ActivityType getType(int value) {
        return switch (value) {
            case 1 -> ACTIVITY_TYPE_1;
            case 2 -> ACTIVITY_TYPE_2;
            case 3 -> SERVER_TREND;
            case 4 -> PERSONAL_ARMAMENTS;
            case 5 -> LOGIN_ACTIVITY;
            case 6 -> ACTIVITY_CARNIVAL;
            case 7 -> CLIMB_RANK;
            case 8 -> ONLINE_ACTIVITY;
            case 9 -> RECHARGE_ACTIVITY;
            case 10 -> BATTLEPASS_ACTIVITY;
            case 11 -> ONLINE_DAILY_ACTIVITY;
            case 12 -> ALLIANCE_BOSS;
            case 13 -> SINGLE_SERVER_RANK;
            case 14 -> TRANSPORTGOODS_ACTIVITY;
            default -> {
                LogUtils.logger.error("ActivityType is not find value:{}",value);
                yield null;
            }
        };
    }
}
