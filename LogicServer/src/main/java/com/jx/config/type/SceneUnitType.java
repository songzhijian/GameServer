package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成SceneUnitType
 */
public enum SceneUnitType {

    /**
     * 玩家主体船
     */
    PLAYER_SHIP(0),

    /**
     * 玩家小船
     */
    PLAYER_BOAT(1),

    /**
     * 机器人大船
     */
    ROBOT_SHIP(2),

    /**
     * 机器人小船
     */
    ROBOT_BOAT(3),

    /**
     * 普通怪
     */
    MONSTER(4),

    /**
     * 资源（矿)
     */
    MINE(5),

    /**
     * 港口
     */
    PORT(6),

    /**
     * 侦查小船
     */
    PLAYER_SCOUT_BOAT(7),

    /**
     * 瞭望塔情报点虚拟单位
     */
    TOWER_POINT_UNIT(8),

    ;
    private int value;

    public static SceneUnitType[] ARRAY = {
            PLAYER_SHIP,
            PLAYER_BOAT,
            ROBOT_SHIP,
            ROBOT_BOAT,
            MONSTER,
            MINE,
            PORT,
            PLAYER_SCOUT_BOAT,
            TOWER_POINT_UNIT
    };

    SceneUnitType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SceneUnitType getType(int value) {
        return switch (value) {
            case 0 -> PLAYER_SHIP;
            case 1 -> PLAYER_BOAT;
            case 2 -> ROBOT_SHIP;
            case 3 -> ROBOT_BOAT;
            case 4 -> MONSTER;
            case 5 -> MINE;
            case 6 -> PORT;
            case 7 -> PLAYER_SCOUT_BOAT;
            case 8 -> TOWER_POINT_UNIT;
            default -> {
                LogUtils.logger.error("SceneUnitType is not find value:{}",value);
                yield null;
            }
        };
    }
}
