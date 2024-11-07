package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成PortEventType
 */
public enum PortEventType {

    /**
     * 城市归属变更
     */
    CITY_AFFILIATION_CHANGE(1),

    /**
     * 发生战争
     */
    CITY_BATTLE(2),

    /**
     * 出售数量超额
     */
    SELL_MAX(3),

    /**
     * 无事件
     */
    NOTHING_HAPPENED(4),

    ;
    private int value;

    public static PortEventType[] ARRAY = {
            CITY_AFFILIATION_CHANGE,
            CITY_BATTLE,
            SELL_MAX,
            NOTHING_HAPPENED
    };

    PortEventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PortEventType getType(int value) {
        return switch (value) {
            case 1 -> CITY_AFFILIATION_CHANGE;
            case 2 -> CITY_BATTLE;
            case 3 -> SELL_MAX;
            case 4 -> NOTHING_HAPPENED;
            default -> {
                LogUtils.logger.error("PortEventType is not find value:{}",value);
                yield null;
            }
        };
    }
}
