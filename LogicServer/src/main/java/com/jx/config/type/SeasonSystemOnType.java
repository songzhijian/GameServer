package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成SeasonSystemOnType
 */
public enum SeasonSystemOnType {

    /**
     * 提高大地图野怪等级上限
     */
    MONSTER_LEVEL_RAISE(1),

    /**
     * 提高大地图集结野怪等级上限
     */
    MASS_MONSTER_LEVEL_RAISE(2),

    /**
     * 提高联盟可占领港口个数
     */
    PORT_NUM_RAISE(3),

    /**
     * 提高可占领港口等级上限
     */
    PORT_LEVEL_RAISE(4),

    /**
     * 提高主船等级上限
     */
    BOAT_LEVEL_RAISE(5),

    /**
     * 解锁指定卡池(后续开发)
     */
    ULOCK_CARD_POOL(6),

    /**
     * 提高大地图采集点等级
     */
    GATHER_LEVEL_RAISE(7),

    /**
     * 大地图迷雾解锁（按港口等级）
     */
    FOG_UNLOCK_PORT(8),

    /**
     * 大地图迷雾解锁（按商圈）
     */
    FOG_UNLOCK_CONTINENT(9),

    /**
     * 港口功能开启(后续开发)
     */
    PORT_FUNCTION_ON(10),

    /**
     * 提高英雄等级上限
     */
    HERO_LEVEL_LIMIT_UP(11),

    /**
     * 控制退盟时间修改
     */
    ALLIANCE_CD_CHANGE(12),

    ;
    private int value;

    public static SeasonSystemOnType[] ARRAY = {
            MONSTER_LEVEL_RAISE,
            MASS_MONSTER_LEVEL_RAISE,
            PORT_NUM_RAISE,
            PORT_LEVEL_RAISE,
            BOAT_LEVEL_RAISE,
            ULOCK_CARD_POOL,
            GATHER_LEVEL_RAISE,
            FOG_UNLOCK_PORT,
            FOG_UNLOCK_CONTINENT,
            PORT_FUNCTION_ON,
            HERO_LEVEL_LIMIT_UP,
            ALLIANCE_CD_CHANGE
    };

    SeasonSystemOnType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SeasonSystemOnType getType(int value) {
        return switch (value) {
            case 1 -> MONSTER_LEVEL_RAISE;
            case 2 -> MASS_MONSTER_LEVEL_RAISE;
            case 3 -> PORT_NUM_RAISE;
            case 4 -> PORT_LEVEL_RAISE;
            case 5 -> BOAT_LEVEL_RAISE;
            case 6 -> ULOCK_CARD_POOL;
            case 7 -> GATHER_LEVEL_RAISE;
            case 8 -> FOG_UNLOCK_PORT;
            case 9 -> FOG_UNLOCK_CONTINENT;
            case 10 -> PORT_FUNCTION_ON;
            case 11 -> HERO_LEVEL_LIMIT_UP;
            case 12 -> ALLIANCE_CD_CHANGE;
            default -> {
                LogUtils.logger.error("SeasonSystemOnType is not find value:{}",value);
                yield null;
            }
        };
    }
}
