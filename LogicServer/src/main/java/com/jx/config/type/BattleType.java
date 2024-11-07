package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成BattleType
 */
public enum BattleType {

    /**
     * 所有
     */
    ALL_TEAM(0),

    /**
     * 推图
     */
    CHAPTER(1),

    /**
     * 探索
     */
    EXPLORE(2),

    /**
     * 竞技场
     */
    ARENA(3),

    /**
     * 多队竞技场
     */
    MULTI_TEAM_ARENA(4),

    /**
     * 世界PVE（敌人：读表）
     */
    WORLD_PVE(5),

    /**
     * 秘境
     */
    MYSTERY(6),

    /**
     * 时光之巅
     */
    TOP_OF_TIME(7),

    /**
     * 世界PVP(敌人：服务器下发）
     */
    WORLD_PVP(8),

    /**
     * 新手战斗
     */
    NEWBIE(9),

    /**
     * 联盟BOSS
     */
    ALLIANCE_BOSS(10),

    ;
    private int value;

    public static BattleType[] ARRAY = {
            ALL_TEAM,
            CHAPTER,
            EXPLORE,
            ARENA,
            MULTI_TEAM_ARENA,
            WORLD_PVE,
            MYSTERY,
            TOP_OF_TIME,
            WORLD_PVP,
            NEWBIE,
            ALLIANCE_BOSS
    };

    BattleType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BattleType getType(int value) {
        return switch (value) {
            case 0 -> ALL_TEAM;
            case 1 -> CHAPTER;
            case 2 -> EXPLORE;
            case 3 -> ARENA;
            case 4 -> MULTI_TEAM_ARENA;
            case 5 -> WORLD_PVE;
            case 6 -> MYSTERY;
            case 7 -> TOP_OF_TIME;
            case 8 -> WORLD_PVP;
            case 9 -> NEWBIE;
            case 10 -> ALLIANCE_BOSS;
            default -> {
                LogUtils.logger.error("BattleType is not find value:{}",value);
                yield null;
            }
        };
    }
}
