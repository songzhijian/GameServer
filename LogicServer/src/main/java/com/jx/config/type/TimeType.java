package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成TimeType
 */
public enum TimeType {

    /**
     * 固定时间（arg1:开始时间  arg2:结束时间）
     */
    FIXED_TIME(1),

    /**
     * 周期时间 （arg1:开始时间 arg2:单位（0:分钟 1:小时 2:天 3:周 4:月(开始时间不要超过28号)）arg3：周期 arg4:持续时间,单位秒 arg5:循环几次【-1无限循环】）
     */
    CYCLE_TIME(2),

    /**
     * 开服时间   （arg1:开服第几天开始 arg3:开服第几天结束）
     */
    OPEN_SERVER_TIME(3),

    /**
     * 常开（开始时间和结束时间都是-1）
     */
    FOREVER_TIME(4),

    /**
     * 赛季时间（arg1：开始赛季ID   arg2：结束赛季ID   arg3：赛季第几天开始    arg4：赛季第几天结束)
     */
    SEASON_TIME(5),

    ;
    private int value;

    public static TimeType[] ARRAY = {
            FIXED_TIME,
            CYCLE_TIME,
            OPEN_SERVER_TIME,
            FOREVER_TIME,
            SEASON_TIME
    };

    TimeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TimeType getType(int value) {
        return switch (value) {
            case 1 -> FIXED_TIME;
            case 2 -> CYCLE_TIME;
            case 3 -> OPEN_SERVER_TIME;
            case 4 -> FOREVER_TIME;
            case 5 -> SEASON_TIME;
            default -> {
                LogUtils.logger.error("TimeType is not find value:{}",value);
                yield null;
            }
        };
    }
}
