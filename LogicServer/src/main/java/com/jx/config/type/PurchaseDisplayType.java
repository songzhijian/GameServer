package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成PurchaseDisplayType
 */
public enum PurchaseDisplayType {

    /**
     * 成功通关相应打击海盗层数（arg1：Stage_BattleID）
     */
    FIGHT_PIRATES(1),

    /**
     * 将船舱升至X级（arg1:Ship_BuildingGroupID，arg2：level)
     */
    CABIN_UPGRADE(2),

    /**
     * 购买过某个礼包（arg1：礼包ID）
     */
    BUY_PURCHASE(3),

    ;
    private int value;

    public static PurchaseDisplayType[] ARRAY = {
            FIGHT_PIRATES,
            CABIN_UPGRADE,
            BUY_PURCHASE
    };

    PurchaseDisplayType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PurchaseDisplayType getType(int value) {
        return switch (value) {
            case 1 -> FIGHT_PIRATES;
            case 2 -> CABIN_UPGRADE;
            case 3 -> BUY_PURCHASE;
            default -> {
                LogUtils.logger.error("PurchaseDisplayType is not find value:{}",value);
                yield null;
            }
        };
    }
}
