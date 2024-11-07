package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成TradeEventCheckType
 */
public enum TradeEventCheckType {

    /**
     * 城市变更归属
     */
    CITY_CHANGE(1),

    /**
     * 发生过战争
     */
    BATTLE(2),

    /**
     * 出售超额
     */
    SELL_COUNT_MAX(3),

    /**
     * 无事发生
     */
    NOTHING(4),

    ;
    private int value;

    public static TradeEventCheckType[] ARRAY = {
            CITY_CHANGE,
            BATTLE,
            SELL_COUNT_MAX,
            NOTHING
    };

    TradeEventCheckType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TradeEventCheckType getType(int value) {
        return switch (value) {
            case 1 -> CITY_CHANGE;
            case 2 -> BATTLE;
            case 3 -> SELL_COUNT_MAX;
            case 4 -> NOTHING;
            default -> {
                LogUtils.logger.error("TradeEventCheckType is not find value:{}",value);
                yield null;
            }
        };
    }
}
