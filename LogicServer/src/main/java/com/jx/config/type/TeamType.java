package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成TeamType
 */
public enum TeamType {

    /**
     * 推图（单队）
     */
    SINGLE_TEAM(1),

    /**
     * 探索（单队）
     */
    EXPLORE_TEAM(2),

    /**
     * 世界布阵
     */
    WORLD_TEAM(3),

    /**
     * 竞技场进攻（单队）
     */
    ARENA_TEAM(4),

    /**
     * 竞技场防守（单队）
     */
    ARENA_TEAM_DEFENCE(5),

    /**
     * 多队竞技场进攻
     */
    ARENA_MULTIPLE_TEAM(6),

    /**
     * 多队竞技场防守
     */
    ARENA_MULTIPLE_TEAM_DEFENCE(7),

    /**
     * 秘境（继承血量）
     */
    MYSTERY_TEAM(8),

    /**
     * 时光之颠（继承血量）
     */
    TOP_OF_TIME_TEAM(9),

    /**
     * 新手战斗
     */
    NEWBIE_TEAM(10),

    ;
    private int value;

    public static TeamType[] ARRAY = {
            SINGLE_TEAM,
            EXPLORE_TEAM,
            WORLD_TEAM,
            ARENA_TEAM,
            ARENA_TEAM_DEFENCE,
            ARENA_MULTIPLE_TEAM,
            ARENA_MULTIPLE_TEAM_DEFENCE,
            MYSTERY_TEAM,
            TOP_OF_TIME_TEAM,
            NEWBIE_TEAM
    };

    TeamType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TeamType getType(int value) {
        return switch (value) {
            case 1 -> SINGLE_TEAM;
            case 2 -> EXPLORE_TEAM;
            case 3 -> WORLD_TEAM;
            case 4 -> ARENA_TEAM;
            case 5 -> ARENA_TEAM_DEFENCE;
            case 6 -> ARENA_MULTIPLE_TEAM;
            case 7 -> ARENA_MULTIPLE_TEAM_DEFENCE;
            case 8 -> MYSTERY_TEAM;
            case 9 -> TOP_OF_TIME_TEAM;
            case 10 -> NEWBIE_TEAM;
            default -> {
                LogUtils.logger.error("TeamType is not find value:{}",value);
                yield null;
            }
        };
    }
}
