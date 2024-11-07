package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成PurposeType
 */
public enum PurposeType {

    /**
     * 无目的
     */
    NONE(0),

    /**
     * 单纯攻击（无后续操作）
     */
    ATTACK(1),

    /**
     * 采集
     */
    EXPLOIT_MINE(2),

    /**
     * 前往驻守
     */
    STATION_FOR_DEF(3),

    /**
     * 返回主船
     */
    BACK_HOME(4),

    /**
     * 参与集结(已经合成一个大船，主船已经在移动或者战斗了。参与集结的船依然是这个TO_ASSEMBLE目的）
     */
    TO_ASSEMBLE(5),

    /**
     * 单纯移动
     */
    MOVE(6),

    /**
     * 在港口地区停留
     */
    STATIONED_IN_PORT_AREA(7),

    /**
     * 侦查
     */
    SCOUT(8),

    ;
    private int value;

    public static PurposeType[] ARRAY = {
            NONE,
            ATTACK,
            EXPLOIT_MINE,
            STATION_FOR_DEF,
            BACK_HOME,
            TO_ASSEMBLE,
            MOVE,
            STATIONED_IN_PORT_AREA,
            SCOUT
    };

    PurposeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PurposeType getType(int value) {
        return switch (value) {
            case 0 -> NONE;
            case 1 -> ATTACK;
            case 2 -> EXPLOIT_MINE;
            case 3 -> STATION_FOR_DEF;
            case 4 -> BACK_HOME;
            case 5 -> TO_ASSEMBLE;
            case 6 -> MOVE;
            case 7 -> STATIONED_IN_PORT_AREA;
            case 8 -> SCOUT;
            default -> {
                LogUtils.logger.error("PurposeType is not find value:{}",value);
                yield null;
            }
        };
    }
}
