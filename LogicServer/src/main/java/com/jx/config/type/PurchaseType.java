package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成PurchaseType
 */
public enum PurchaseType {

    /**
     * 直充
     */
    GEM_RECHARGE(1),

    /**
     * 月卡
     */
    MONTHLY_CARD(2),

    /**
     * 普通礼包
     */
    COMMON_BOUNS(3),

    /**
     * 每日礼包
     */
    DAILY_BOUNS(4),

    /**
     * 每日礼包（折扣一次性）
     */
    DAILY_BOUNS_DISCOUNT(5),

    /**
     * vip礼包
     */
    VIP_BOUNS(6),

    /**
     * 限时礼包
     */
    LIMITED_PURCHASE(7),

    /**
     * 工具间礼包
     */
    WORKSHOP_PURCHASE(8),

    /**
     * 首充礼包
     */
    FIRST_RECHARGE(9),

    /**
     * BP礼包
     */
    BATTLE_PASS_GIFT(10),

    /**
     * 限时礼包（不显示在界面中）
     */
    LIMITED_PURCHASE_NOTSHOW(11),

    /**
     * 钻石购买礼包
     */
    DIAMOND_BUY_GIFT(12),

    ;
    private int value;

    public static PurchaseType[] ARRAY = {
            GEM_RECHARGE,
            MONTHLY_CARD,
            COMMON_BOUNS,
            DAILY_BOUNS,
            DAILY_BOUNS_DISCOUNT,
            VIP_BOUNS,
            LIMITED_PURCHASE,
            WORKSHOP_PURCHASE,
            FIRST_RECHARGE,
            BATTLE_PASS_GIFT,
            LIMITED_PURCHASE_NOTSHOW,
            DIAMOND_BUY_GIFT
    };

    PurchaseType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PurchaseType getType(int value) {
        return switch (value) {
            case 1 -> GEM_RECHARGE;
            case 2 -> MONTHLY_CARD;
            case 3 -> COMMON_BOUNS;
            case 4 -> DAILY_BOUNS;
            case 5 -> DAILY_BOUNS_DISCOUNT;
            case 6 -> VIP_BOUNS;
            case 7 -> LIMITED_PURCHASE;
            case 8 -> WORKSHOP_PURCHASE;
            case 9 -> FIRST_RECHARGE;
            case 10 -> BATTLE_PASS_GIFT;
            case 11 -> LIMITED_PURCHASE_NOTSHOW;
            case 12 -> DIAMOND_BUY_GIFT;
            default -> {
                LogUtils.logger.error("PurchaseType is not find value:{}",value);
                yield null;
            }
        };
    }
}
