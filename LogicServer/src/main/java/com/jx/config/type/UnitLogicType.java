package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成UnitLogicType
 */
public enum UnitLogicType {

    /**
     * 业务状态机+长期目的
     */
    STATE_MACHINE_AND_PURPOSE(0),

    /**
     * 移动
     */
    MOVE(1),

    /**
     * 战斗
     */
    FIGHT(2),

    /**
     * 大船逻辑、大船数据管理
     */
    SHIP(3),

    /**
     * 怪物逻辑
     */
    MONSTER(4),

    /**
     * 机器人
     */
    ROBOT(5),

    /**
     * 玩家单位
     */
    PLAYER(6),

    /**
     * 资源(矿）
     */
    MINE(7),

    /**
     * 小船逻辑
     */
    BOAT(8),

    /**
     * 采矿逻辑
     */
    EXPLOIT_MINE(9),

    /**
     * 港口
     */
    PORT(10),

    /**
     * 集结管理（发起集结的小船作为主船，进行集结相关的行为逻辑处理）
     */
    ASSEMBLE(11),

    /**
     * 侦查逻辑
     */
    SCOUT(12),

    /**
     * 瞭望塔情报
     */
    TOWER_POINT(13),

    ;
    private int value;

    public static UnitLogicType[] ARRAY = {
            STATE_MACHINE_AND_PURPOSE,
            MOVE,
            FIGHT,
            SHIP,
            MONSTER,
            ROBOT,
            PLAYER,
            MINE,
            BOAT,
            EXPLOIT_MINE,
            PORT,
            ASSEMBLE,
            SCOUT,
            TOWER_POINT
    };

    UnitLogicType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UnitLogicType getType(int value) {
        return switch (value) {
            case 0 -> STATE_MACHINE_AND_PURPOSE;
            case 1 -> MOVE;
            case 2 -> FIGHT;
            case 3 -> SHIP;
            case 4 -> MONSTER;
            case 5 -> ROBOT;
            case 6 -> PLAYER;
            case 7 -> MINE;
            case 8 -> BOAT;
            case 9 -> EXPLOIT_MINE;
            case 10 -> PORT;
            case 11 -> ASSEMBLE;
            case 12 -> SCOUT;
            case 13 -> TOWER_POINT;
            default -> {
                LogUtils.logger.error("UnitLogicType is not find value:{}",value);
                yield null;
            }
        };
    }
}
