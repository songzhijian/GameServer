package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成MonsterType
 */
public enum MonsterType {

    /**
     * 普通怪物
     */
    NORMAL_MONSTER_TYPE(1),

    /**
     * boss
     */
    BOSS_MONSTER_TYPE(2),

    /**
     * 瞭望塔野怪
     */
    TOWER_MONSTER(3),

    /**
     * 联盟BOSS
     */
    ALLIANCE_BOSS(4),

    /**
     * 联盟BOSS小怪
     */
    ALLIANCE_BOSS_MONSTER(5),

    ;
    private int value;

    public static MonsterType[] ARRAY = {
            NORMAL_MONSTER_TYPE,
            BOSS_MONSTER_TYPE,
            TOWER_MONSTER,
            ALLIANCE_BOSS,
            ALLIANCE_BOSS_MONSTER
    };

    MonsterType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MonsterType getType(int value) {
        return switch (value) {
            case 1 -> NORMAL_MONSTER_TYPE;
            case 2 -> BOSS_MONSTER_TYPE;
            case 3 -> TOWER_MONSTER;
            case 4 -> ALLIANCE_BOSS;
            case 5 -> ALLIANCE_BOSS_MONSTER;
            default -> {
                LogUtils.logger.error("MonsterType is not find value:{}",value);
                yield null;
            }
        };
    }
}
