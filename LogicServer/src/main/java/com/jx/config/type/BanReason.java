package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成BanReason
 */
public enum BanReason {

    /**
     * 作弊
     */
    CHEAT(1),

    /**
     * 发广告
     */
    ADVERTISE(2),

    /**
     * 骂人
     */
    SWEAR(3),

    ;
    private int value;

    public static BanReason[] ARRAY = {
            CHEAT,
            ADVERTISE,
            SWEAR
    };

    BanReason(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BanReason getType(int value) {
        return switch (value) {
            case 1 -> CHEAT;
            case 2 -> ADVERTISE;
            case 3 -> SWEAR;
            default -> {
                LogUtils.logger.error("BanReason is not find value:{}",value);
                yield null;
            }
        };
    }
}
