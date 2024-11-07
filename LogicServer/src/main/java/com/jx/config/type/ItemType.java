package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ItemType
 */
public enum ItemType {

    /**
     * 资源
     */
    RESOURCE(1),

    /**
     * 一般道具
     */
    COMMON(2),

    /**
     * 宝箱
     */
    TREASURE(3),

    /**
     * 英雄碎片
     */
    HERO_PIECE(4),

    /**
     * 交易品
     */
    TRADE_GOOD(5),

    /**
     * 圣物
     */
    RELIC(6),

    /**
     * 通用加速
     */
    UNIVERSAL_SPEED(21),

    /**
     * 建造加速
     */
    BUILDING_SPEED(22),

    /**
     * 训练水兵加速
     */
    TRAINING_SPEED(23),

    /**
     * 科技加速
     */
    SCIENCE_SPEED(24),

    /**
     * 医疗加速
     */
    CURE_SPEED(25),

    /**
     * 金币资源道具
     */
    GOLD_RESOURCE(31),

    /**
     * 木材资源道具
     */
    WOOD_RESOURCE(32),

    /**
     * 织物资源道具
     */
    FABRIC_RESOURCE(33),

    /**
     * 金属资源道具
     */
    METAL_RESOURCE(34),

    /**
     * 主城BUFF类道具
     */
    MAIN_SHIP_BUFF(35),

    /**
     * vip经验道具
     */
    VIP_EXP(36),

    /**
     * 挂机时间奖励道具
     */
    IDLE_REWARD(37),

    /**
     * 城建内食品
     */
    FOOD(61),

    /**
     * 城建内饮用水
     */
    WATER(62),

    /**
     * 城建内药品
     */
    MEDICINE(63),

    /**
     * 城建内药材
     */
    MEDICINE_MATERIAL(64),

    /**
     * 城建内食材
     */
    FOOD_MATERIAL(65),

    /**
     * 用于展示奖励的假贸易品
     */
    FAKE_TRADE_GOODS(501),

    ;
    private int value;

    public static ItemType[] ARRAY = {
            RESOURCE,
            COMMON,
            TREASURE,
            HERO_PIECE,
            TRADE_GOOD,
            RELIC,
            UNIVERSAL_SPEED,
            BUILDING_SPEED,
            TRAINING_SPEED,
            SCIENCE_SPEED,
            CURE_SPEED,
            GOLD_RESOURCE,
            WOOD_RESOURCE,
            FABRIC_RESOURCE,
            METAL_RESOURCE,
            MAIN_SHIP_BUFF,
            VIP_EXP,
            IDLE_REWARD,
            FOOD,
            WATER,
            MEDICINE,
            MEDICINE_MATERIAL,
            FOOD_MATERIAL,
            FAKE_TRADE_GOODS
    };

    ItemType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemType getType(int value) {
        return switch (value) {
            case 1 -> RESOURCE;
            case 2 -> COMMON;
            case 3 -> TREASURE;
            case 4 -> HERO_PIECE;
            case 5 -> TRADE_GOOD;
            case 6 -> RELIC;
            case 21 -> UNIVERSAL_SPEED;
            case 22 -> BUILDING_SPEED;
            case 23 -> TRAINING_SPEED;
            case 24 -> SCIENCE_SPEED;
            case 25 -> CURE_SPEED;
            case 31 -> GOLD_RESOURCE;
            case 32 -> WOOD_RESOURCE;
            case 33 -> FABRIC_RESOURCE;
            case 34 -> METAL_RESOURCE;
            case 35 -> MAIN_SHIP_BUFF;
            case 36 -> VIP_EXP;
            case 37 -> IDLE_REWARD;
            case 61 -> FOOD;
            case 62 -> WATER;
            case 63 -> MEDICINE;
            case 64 -> MEDICINE_MATERIAL;
            case 65 -> FOOD_MATERIAL;
            case 501 -> FAKE_TRADE_GOODS;
            default -> {
                LogUtils.logger.error("ItemType is not find value:{}",value);
                yield null;
            }
        };
    }
}
