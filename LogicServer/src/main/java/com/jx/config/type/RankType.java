package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成RankType
 */
public enum RankType {

    /**
     * 联盟军功排行榜
     */
    ALLIANCE_MILITARY_RANKING(1),

    /**
     * 联盟贡献排行榜
     */
    ALLIANCE_CONTRIBUTION_RANKING(2),

    /**
     * 联盟杀敌排行榜（包括轻伤、重伤）
     */
    ALLIANCE_KILL_RANKING(3),

    /**
     * 联盟采集排行榜
     */
    ALLIANCE_GATHER_RANKING(4),

    /**
     * 联盟打野排行榜
     */
    ALLIANCE_WILD_RANKING(5),

    /**
     * 个人军备排行榜
     */
    PERSONAL_ARMAMENTS(6),

    /**
     * 玩家总战力排行榜
     */
    PERSONAL_TOTAL_POWER(7),

    /**
     * 玩家总解锁港口数排行榜
     */
    PERSONAL_PORT_SIZE(8),

    /**
     * 联盟BOSS伤害排行榜
     */
    ALLIANCE_BOSS_DAMAGE_RANKING(9),

    /**
     * 个人单服战力榜
     */
    PERSONAL_POWER(10),

    /**
     * 个人单服杀敌榜
     */
    PERSONAL_KILL(11),

    /**
     * 个人单服采集榜
     */
    PERSONAL_GATHER(12),

    /**
     * 个人单服打野榜
     */
    PERSONAL_WILD(13),

    /**
     * 个人单服推图榜
     */
    PERSONAL_PIRATE_WAR(14),

    /**
     * 个人单服贸易榜
     */
    PERSONAL_TRADE(15),

    /**
     * 联盟单服势力榜
     */
    ALLIANCE_POWER(16),

    /**
     * 联盟单服总战力榜
     */
    ALLIANCE_COMBAT(17),

    ;
    private int value;

    public static RankType[] ARRAY = {
            ALLIANCE_MILITARY_RANKING,
            ALLIANCE_CONTRIBUTION_RANKING,
            ALLIANCE_KILL_RANKING,
            ALLIANCE_GATHER_RANKING,
            ALLIANCE_WILD_RANKING,
            PERSONAL_ARMAMENTS,
            PERSONAL_TOTAL_POWER,
            PERSONAL_PORT_SIZE,
            ALLIANCE_BOSS_DAMAGE_RANKING,
            PERSONAL_POWER,
            PERSONAL_KILL,
            PERSONAL_GATHER,
            PERSONAL_WILD,
            PERSONAL_PIRATE_WAR,
            PERSONAL_TRADE,
            ALLIANCE_POWER,
            ALLIANCE_COMBAT
    };

    RankType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RankType getType(int value) {
        return switch (value) {
            case 1 -> ALLIANCE_MILITARY_RANKING;
            case 2 -> ALLIANCE_CONTRIBUTION_RANKING;
            case 3 -> ALLIANCE_KILL_RANKING;
            case 4 -> ALLIANCE_GATHER_RANKING;
            case 5 -> ALLIANCE_WILD_RANKING;
            case 6 -> PERSONAL_ARMAMENTS;
            case 7 -> PERSONAL_TOTAL_POWER;
            case 8 -> PERSONAL_PORT_SIZE;
            case 9 -> ALLIANCE_BOSS_DAMAGE_RANKING;
            case 10 -> PERSONAL_POWER;
            case 11 -> PERSONAL_KILL;
            case 12 -> PERSONAL_GATHER;
            case 13 -> PERSONAL_WILD;
            case 14 -> PERSONAL_PIRATE_WAR;
            case 15 -> PERSONAL_TRADE;
            case 16 -> ALLIANCE_POWER;
            case 17 -> ALLIANCE_COMBAT;
            default -> {
                LogUtils.logger.error("RankType is not find value:{}",value);
                yield null;
            }
        };
    }
}
