package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成RaceType
 */
public enum RaceType {

    /**
     * 1=自由联盟
     */
    RACE_1(1),

    /**
     * 2=天理星辰
     */
    RACE_2(2),

    /**
     * 3=变革之风
     */
    RACE_3(3),

    /**
     * 4=复仇之血
     */
    RACE_4(4),

    /**
     * 5=秩序守望者
     */
    RACE_5(5),

    /**
     * 6=混沌呼唤者
     */
    RACE_6(6),

    /**
     * 7=奇迹之光
     */
    RACE_7(7),

    /**
     * 9=Boss阵营
     */
    RACE_9(9),

    ;
    private int value;

    public static RaceType[] ARRAY = {
            RACE_1,
            RACE_2,
            RACE_3,
            RACE_4,
            RACE_5,
            RACE_6,
            RACE_7,
            RACE_9
    };

    RaceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RaceType getType(int value) {
        return switch (value) {
            case 1 -> RACE_1;
            case 2 -> RACE_2;
            case 3 -> RACE_3;
            case 4 -> RACE_4;
            case 5 -> RACE_5;
            case 6 -> RACE_6;
            case 7 -> RACE_7;
            case 9 -> RACE_9;
            default -> {
                LogUtils.logger.error("RaceType is not find value:{}",value);
                yield null;
            }
        };
    }
}
