package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成SceneLogicType
 */
public enum SceneLogicType {

    /**
     * 玩家执行器
     */
    PLAYER_WORLD_EXECUTOR(0),

    /**
     * 网格（寻路和移动需要网格数据，但是网格本身不承担寻路逻辑）
     */
    GRID(1),

    /**
     * 天气
     */
    WEATHER(2),

    /**
     * 视野
     */
    AOI(3),

    /**
     * 玩家数据管理
     */
    PLAYER_DATA(4),

    /**
     * Db
     */
    DB(5),

    /**
     * 调试模式，发送大量信息
     */
    DEBUG(6),

    /**
     * 航线
     */
    ROUTE(7),

    /**
     * 机器人
     */
    ROBOT(8),

    /**
     * 迷雾逻辑
     */
    FOG(9),

    /**
     * 怪物管理
     */
    MONSTER(10),

    /**
     * 矿管理
     */
    MINE(11),

    /**
     * 场景全局数据管理
     */
    GLOBAL_DATA(12),

    /**
     * 场景中的联盟信息管理
     */
    ALLIANCE(13),

    /**
     * 定时器管理
     */
    SCHEDULE(14),

    ;
    private int value;

    public static SceneLogicType[] ARRAY = {
            PLAYER_WORLD_EXECUTOR,
            GRID,
            WEATHER,
            AOI,
            PLAYER_DATA,
            DB,
            DEBUG,
            ROUTE,
            ROBOT,
            FOG,
            MONSTER,
            MINE,
            GLOBAL_DATA,
            ALLIANCE,
            SCHEDULE
    };

    SceneLogicType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SceneLogicType getType(int value) {
        return switch (value) {
            case 0 -> PLAYER_WORLD_EXECUTOR;
            case 1 -> GRID;
            case 2 -> WEATHER;
            case 3 -> AOI;
            case 4 -> PLAYER_DATA;
            case 5 -> DB;
            case 6 -> DEBUG;
            case 7 -> ROUTE;
            case 8 -> ROBOT;
            case 9 -> FOG;
            case 10 -> MONSTER;
            case 11 -> MINE;
            case 12 -> GLOBAL_DATA;
            case 13 -> ALLIANCE;
            case 14 -> SCHEDULE;
            default -> {
                LogUtils.logger.error("SceneLogicType is not find value:{}",value);
                yield null;
            }
        };
    }
}
