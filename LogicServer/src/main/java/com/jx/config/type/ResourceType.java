package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ResourceType
 */
public enum ResourceType {

    /**
     * 钻石
     */
    DIAMOND(100),

    /**
     * 金币
     */
    GOLD(101),

    /**
     * 木材
     */
    WOOD(102),

    /**
     * 织物
     */
    FABRIC(103),

    /**
     * 金属
     */
    METAL(104),

    /**
     * 英雄经验
     */
    HERO_EXP(105),

    /**
     * 竞技场货币
     */
    COIN_ARENA(107),

    /**
     * 遣散英雄货币
     */
    COIN_DISBAND(108),

    /**
     * 迷宫币
     */
    COIN_MYSTIC(109),

    /**
     * 抽卡点
     */
    GACHA_POINT(110),

    /**
     * 抽卡心愿单能量
     */
    WISH_POWER(111),

    /**
     * 贤者之石能量
     */
    ORACLE_STONE_POWER(112),

    /**
     * 无字之书能量
     */
    WORDLESS_BOOK_POWER(113),

    /**
     * 赛季battlepass的经验
     */
    SEASON_BATTLEPASS_POINT(114),

    /**
     * 个人battlepass的经验
     */
    PERSON_BATTLEPASS_POINT(115),

    /**
     * 回归battlepass的经验
     */
    CALLBACK_BATTLEPASS_POINT(116),

    /**
     * 方晶（科技币）
     */
    CUBICCRYSTAL(117),

    /**
     * 联盟贡献
     */
    COIN_ALLIANCE(201),

    /**
     * 贸易额度
     */
    TRADE_LINE(202),

    /**
     * 攻城燃油
     */
    ATTACK_CITY_POWER(203),

    /**
     * 政策点-个人赛季政策玩法消耗的资源
     */
    POLICY_POINT(204),

    /**
     * 联盟战功
     */
    MILITARY_ALLIANCE(205),

    ;
    private int value;

    public static ResourceType[] ARRAY = {
            DIAMOND,
            GOLD,
            WOOD,
            FABRIC,
            METAL,
            HERO_EXP,
            COIN_ARENA,
            COIN_DISBAND,
            COIN_MYSTIC,
            GACHA_POINT,
            WISH_POWER,
            ORACLE_STONE_POWER,
            WORDLESS_BOOK_POWER,
            SEASON_BATTLEPASS_POINT,
            PERSON_BATTLEPASS_POINT,
            CALLBACK_BATTLEPASS_POINT,
            CUBICCRYSTAL,
            COIN_ALLIANCE,
            TRADE_LINE,
            ATTACK_CITY_POWER,
            POLICY_POINT,
            MILITARY_ALLIANCE
    };

    ResourceType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ResourceType getType(int value) {
        return switch (value) {
            case 100 -> DIAMOND;
            case 101 -> GOLD;
            case 102 -> WOOD;
            case 103 -> FABRIC;
            case 104 -> METAL;
            case 105 -> HERO_EXP;
            case 107 -> COIN_ARENA;
            case 108 -> COIN_DISBAND;
            case 109 -> COIN_MYSTIC;
            case 110 -> GACHA_POINT;
            case 111 -> WISH_POWER;
            case 112 -> ORACLE_STONE_POWER;
            case 113 -> WORDLESS_BOOK_POWER;
            case 114 -> SEASON_BATTLEPASS_POINT;
            case 115 -> PERSON_BATTLEPASS_POINT;
            case 116 -> CALLBACK_BATTLEPASS_POINT;
            case 117 -> CUBICCRYSTAL;
            case 201 -> COIN_ALLIANCE;
            case 202 -> TRADE_LINE;
            case 203 -> ATTACK_CITY_POWER;
            case 204 -> POLICY_POINT;
            case 205 -> MILITARY_ALLIANCE;
            default -> {
                LogUtils.logger.error("ResourceType is not find value:{}",value);
                yield null;
            }
        };
    }
}
