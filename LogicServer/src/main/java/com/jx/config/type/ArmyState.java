package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ArmyState
 */
public enum ArmyState {

    /**
     * 移动（前往）
     */
    MOVING(0),

    /**
     * 正在参与战斗
     */
    FIGHTING(1),

    /**
     * 采集中
     */
    EXPLOITING_MINE(2),

    /**
     * 驻守中
     */
    STATIONING(3),

    /**
     * 在家（母船）（空闲）
     */
    IN_HOME(4),

    /**
     * 集结等待出发
     */
    ASSEMBLE_WAITING_LEAVE(5),

    /**
     * 返回（回家途中）
     */
    BACKING_HOME(6),

    /**
     * 战斗等待
     */
    FIGHT_WAITING(7),

    /**
     * 前往侦查
     */
    SCOUTING(8),

    /**
     * 集结出发
     */
    ASSEMBLE_MOVING(9),

    /**
     * 侦查返回
     */
    SCOUT_BACKING_HOME(10),

    /**
     * 未知状态（后端能正确计算出编队状态）
     */
    UNKNOWN(-1),

    ;
    private int value;

    public static ArmyState[] ARRAY = {
            MOVING,
            FIGHTING,
            EXPLOITING_MINE,
            STATIONING,
            IN_HOME,
            ASSEMBLE_WAITING_LEAVE,
            BACKING_HOME,
            FIGHT_WAITING,
            SCOUTING,
            ASSEMBLE_MOVING,
            SCOUT_BACKING_HOME,
            UNKNOWN
    };

    ArmyState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ArmyState getType(int value) {
        return switch (value) {
            case 0 -> MOVING;
            case 1 -> FIGHTING;
            case 2 -> EXPLOITING_MINE;
            case 3 -> STATIONING;
            case 4 -> IN_HOME;
            case 5 -> ASSEMBLE_WAITING_LEAVE;
            case 6 -> BACKING_HOME;
            case 7 -> FIGHT_WAITING;
            case 8 -> SCOUTING;
            case 9 -> ASSEMBLE_MOVING;
            case 10 -> SCOUT_BACKING_HOME;
            case -1 -> UNKNOWN;
            default -> {
                LogUtils.logger.error("ArmyState is not find value:{}",value);
                yield null;
            }
        };
    }
}
