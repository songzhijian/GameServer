package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成CostType
 */
public enum CostType {

    /**
     * 固定物品（arg1：物品id,arg2:数量）
     */
    ITEM(1),

    /**
     * 固定资源（arg1：资源id,arg2:数量）
     */
    RESOURCE(2),

    /**
     * 固定水兵（arg1：等级id,arg2:数量）
     */
    NAVY(5),

    /**
     * 固定交易品（arg1：物品id,arg2：星级,arg3:数量）
     */
    GOOD(6),

    /**
     * 无字之书能量（arg1：0=占位符，arg2：数量）
     */
    WORD_LESS_BOOK_ENERGY(19),

    /**
     * 委托任务次数（arg1:数量）
     */
    ENTRUST(24),

    ;
    private int value;

    public static CostType[] ARRAY = {
            ITEM,
            RESOURCE,
            NAVY,
            GOOD,
            WORD_LESS_BOOK_ENERGY,
            ENTRUST
    };

    CostType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CostType getType(int value) {
        return switch (value) {
            case 1 -> ITEM;
            case 2 -> RESOURCE;
            case 5 -> NAVY;
            case 6 -> GOOD;
            case 19 -> WORD_LESS_BOOK_ENERGY;
            case 24 -> ENTRUST;
            default -> {
                LogUtils.logger.error("CostType is not find value:{}",value);
                yield null;
            }
        };
    }
}
