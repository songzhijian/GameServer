package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成TradeEventType
 */
public enum TradeEventType {

    /**
     * 战后重建
     */
    POST_WAR_RECONSTRUCTION(1),

    /**
     * 瘟疫
     */
    PLAGUE(2),

    /**
     * 战争
     */
    WARFARE(3),

    /**
     * 产品过剩
     */
    EXCESS_PRODUCT(4),

    /**
     * 饥荒
     */
    FAMINE(5),

    /**
     * 经济萧条
     */
    ECONOMIC_DEPRESSION(6),

    /**
     * 经济景气
     */
    ECONOMIC_BOOM(7),

    ;
    private int value;

    public static TradeEventType[] ARRAY = {
            POST_WAR_RECONSTRUCTION,
            PLAGUE,
            WARFARE,
            EXCESS_PRODUCT,
            FAMINE,
            ECONOMIC_DEPRESSION,
            ECONOMIC_BOOM
    };

    TradeEventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TradeEventType getType(int value) {
        return switch (value) {
            case 1 -> POST_WAR_RECONSTRUCTION;
            case 2 -> PLAGUE;
            case 3 -> WARFARE;
            case 4 -> EXCESS_PRODUCT;
            case 5 -> FAMINE;
            case 6 -> ECONOMIC_DEPRESSION;
            case 7 -> ECONOMIC_BOOM;
            default -> {
                LogUtils.logger.error("TradeEventType is not find value:{}",value);
                yield null;
            }
        };
    }
}
