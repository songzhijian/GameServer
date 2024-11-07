package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ItemUseType
 */
public enum ItemUseType {

    /**
     * 不产生效果
     */
    NO_EFFECT(0),

    /**
     * 唤出Reward界面获取指定数量指定道具：道具ID:道具数量,道具ID:道具数量
     */
    GAIN_ITEM(1),

    /**
     * 获得随机道具，索引至RandomGroup表
     */
    GAIN_RAND_ITEM(2),

    /**
     * 开启道具选择列表
     */
    GAIN_CHOOSE_ITEM(3),

    /**
     * 阵营自选
     */
    GAIN_HERO_BY_RACE(4),

    /**
     * 获得worldbuff
     */
    GAIN_WORLD_BUFF(5),

    /**
     * 碎片类道具使用
     */
    PIECE_ITEM_USE(6),

    /**
     * 使用道具给挂机奖励
     */
    HANG_ITEM_USE(7),

    /**
     * 自选礼包类型，批量使用
     */
    OPTIONAL_GIFT(8),

    ;
    private int value;

    public static ItemUseType[] ARRAY = {
            NO_EFFECT,
            GAIN_ITEM,
            GAIN_RAND_ITEM,
            GAIN_CHOOSE_ITEM,
            GAIN_HERO_BY_RACE,
            GAIN_WORLD_BUFF,
            PIECE_ITEM_USE,
            HANG_ITEM_USE,
            OPTIONAL_GIFT
    };

    ItemUseType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemUseType getType(int value) {
        return switch (value) {
            case 0 -> NO_EFFECT;
            case 1 -> GAIN_ITEM;
            case 2 -> GAIN_RAND_ITEM;
            case 3 -> GAIN_CHOOSE_ITEM;
            case 4 -> GAIN_HERO_BY_RACE;
            case 5 -> GAIN_WORLD_BUFF;
            case 6 -> PIECE_ITEM_USE;
            case 7 -> HANG_ITEM_USE;
            case 8 -> OPTIONAL_GIFT;
            default -> {
                LogUtils.logger.error("ItemUseType is not find value:{}",value);
                yield null;
            }
        };
    }
}
