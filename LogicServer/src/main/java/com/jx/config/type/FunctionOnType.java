package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成FunctionOnType
 */
public enum FunctionOnType {

    /**
     * 测试用开关1
     */
    TEST_FUNC_ON_01(1),

    /**
     * 测试用开关2
     */
    TEST_FUNC_ON_02(2),

    /**
     * 测试用开关3
     */
    TEST_FUNC_ON_03(3),

    /**
     * 测试用开关4
     */
    TEST_FUNC_ON_04(4),

    /**
     * 测试用开关5
     */
    TEST_FUNC_ON_05(5),

    /**
     * 测试用开关6
     */
    TEST_FUNC_ON_06(6),

    /**
     * 抽卡功能总开关
     */
    FUNCTION_GACHA(1001),

    /**
     * 军备活动
     */
    FUNCTION_PERSONAL_ARMAMENTS(1002),

    /**
     * 开服嘉年华活动总开关
     */
    FUNTION_ACTIVITY_CARNIVAL(1003),

    /**
     * 七日签到活动总开关
     */
    FUNTION_ACTIVITY_LOGIN(1004),

    /**
     * 战力冲榜活动总开关
     */
    FUNTION_ACTIVITY_POWER_CLIMB_RANK(1005),

    /**
     * 港口冲榜活动总开关
     */
    FUNTION_ACTIVITY_PORT_CLIMB_RANK(1006),

    /**
     * 在线活动总开关
     */
    FUNCTION_ONLINE_TIME(1007),

    /**
     * 累充活动总开关
     */
    FUNCTION_ACTIVITY_RECHARGE(1008),

    /**
     * 兑换码总开关
     */
    FUNCTION_CDKEY(1009),

    /**
     * 成长基金开关
     */
    FUNCTION_GROWTH_FUND(1010),

    /**
     * 每日在线活动总开关
     */
    FUNCTION_ONLINE_TIME_DAILY(1011),

    /**
     * 联盟BOSS活动开关
     */
    FUNCTION_ALLIANCE_BOSS(1012),

    /**
     * 打野冲榜开关
     */
    FUNTION_ACTIVITY_HUNT_RANK(1013),

    /**
     * 采集冲榜开关
     */
    FUNTION_ACTIVITY_GATHER_RANK(1014),

    /**
     * 装备强化
     */
    EQUIP_STRENGTHEN(2001),

    /**
     * 装备洗炼
     */
    EQUIP_RECOIN(2002),

    /**
     * 装备进阶
     */
    EQUIP_ENHANCE(2003),

    /**
     * 英雄升级
     */
    HERO_LEVEL_UP(2004),

    /**
     * 英雄进阶
     */
    HERO_QUALITY_UP(2005),

    /**
     * 英雄遣散
     */
    HERO_DISMISS(2006),

    /**
     * 英雄重置
     */
    HERO_RESET(2007),

    /**
     * 新手Abtest
     */
    NOVICE_TEST(2008),

    /**
     * 木筏点击钩垃圾
     */
    RAFT_GARBAGE(3001),

    /**
     * iOS提审开关
     */
    IOS_CHECK(3002),

    /**
     * 押镖开关
     */
    TRANSPORTGOODS_ACTIVITY(4001),

    ;
    private int value;

    public static FunctionOnType[] ARRAY = {
            TEST_FUNC_ON_01,
            TEST_FUNC_ON_02,
            TEST_FUNC_ON_03,
            TEST_FUNC_ON_04,
            TEST_FUNC_ON_05,
            TEST_FUNC_ON_06,
            FUNCTION_GACHA,
            FUNCTION_PERSONAL_ARMAMENTS,
            FUNTION_ACTIVITY_CARNIVAL,
            FUNTION_ACTIVITY_LOGIN,
            FUNTION_ACTIVITY_POWER_CLIMB_RANK,
            FUNTION_ACTIVITY_PORT_CLIMB_RANK,
            FUNCTION_ONLINE_TIME,
            FUNCTION_ACTIVITY_RECHARGE,
            FUNCTION_CDKEY,
            FUNCTION_GROWTH_FUND,
            FUNCTION_ONLINE_TIME_DAILY,
            FUNCTION_ALLIANCE_BOSS,
            FUNTION_ACTIVITY_HUNT_RANK,
            FUNTION_ACTIVITY_GATHER_RANK,
            EQUIP_STRENGTHEN,
            EQUIP_RECOIN,
            EQUIP_ENHANCE,
            HERO_LEVEL_UP,
            HERO_QUALITY_UP,
            HERO_DISMISS,
            HERO_RESET,
            NOVICE_TEST,
            RAFT_GARBAGE,
            IOS_CHECK,
            TRANSPORTGOODS_ACTIVITY
    };

    FunctionOnType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FunctionOnType getType(int value) {
        return switch (value) {
            case 1 -> TEST_FUNC_ON_01;
            case 2 -> TEST_FUNC_ON_02;
            case 3 -> TEST_FUNC_ON_03;
            case 4 -> TEST_FUNC_ON_04;
            case 5 -> TEST_FUNC_ON_05;
            case 6 -> TEST_FUNC_ON_06;
            case 1001 -> FUNCTION_GACHA;
            case 1002 -> FUNCTION_PERSONAL_ARMAMENTS;
            case 1003 -> FUNTION_ACTIVITY_CARNIVAL;
            case 1004 -> FUNTION_ACTIVITY_LOGIN;
            case 1005 -> FUNTION_ACTIVITY_POWER_CLIMB_RANK;
            case 1006 -> FUNTION_ACTIVITY_PORT_CLIMB_RANK;
            case 1007 -> FUNCTION_ONLINE_TIME;
            case 1008 -> FUNCTION_ACTIVITY_RECHARGE;
            case 1009 -> FUNCTION_CDKEY;
            case 1010 -> FUNCTION_GROWTH_FUND;
            case 1011 -> FUNCTION_ONLINE_TIME_DAILY;
            case 1012 -> FUNCTION_ALLIANCE_BOSS;
            case 1013 -> FUNTION_ACTIVITY_HUNT_RANK;
            case 1014 -> FUNTION_ACTIVITY_GATHER_RANK;
            case 2001 -> EQUIP_STRENGTHEN;
            case 2002 -> EQUIP_RECOIN;
            case 2003 -> EQUIP_ENHANCE;
            case 2004 -> HERO_LEVEL_UP;
            case 2005 -> HERO_QUALITY_UP;
            case 2006 -> HERO_DISMISS;
            case 2007 -> HERO_RESET;
            case 2008 -> NOVICE_TEST;
            case 3001 -> RAFT_GARBAGE;
            case 3002 -> IOS_CHECK;
            case 4001 -> TRANSPORTGOODS_ACTIVITY;
            default -> {
                LogUtils.logger.error("FunctionOnType is not find value:{}",value);
                yield null;
            }
        };
    }
}
