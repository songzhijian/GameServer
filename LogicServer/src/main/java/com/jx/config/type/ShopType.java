package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ShopType
 */
public enum ShopType {

    /**
     * 港口商店
     */
    PORT(1001),

    /**
     * 战功商店
     */
    MILITARY(1002),

    /**
     * 联盟商店
     */
    COIN(1003),

    /**
     * VIP商店
     */
    VIPSHOP(1004),

    /**
     * 遣返商店
     */
    COINSHOP(1005),

    /**
     * 秘境商店
     */
    MAZESHOP(1006),

    ;
    private int value;

    public static ShopType[] ARRAY = {
            PORT,
            MILITARY,
            COIN,
            VIPSHOP,
            COINSHOP,
            MAZESHOP
    };

    ShopType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ShopType getType(int value) {
        return switch (value) {
            case 1001 -> PORT;
            case 1002 -> MILITARY;
            case 1003 -> COIN;
            case 1004 -> VIPSHOP;
            case 1005 -> COINSHOP;
            case 1006 -> MAZESHOP;
            default -> {
                LogUtils.logger.error("ShopType is not find value:{}",value);
                yield null;
            }
        };
    }
}
