package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成RewardStatus
 */
public enum RewardStatus {

    /**
     * 不可领取
     */
    CANT_RECEIVED(0),

    /**
     * 未领取
     */
    NO_RECEIVED(1),

    /**
     * 已领取
     */
    RECEIVED(2),

    ;
    private int value;

    public static RewardStatus[] ARRAY = {
            CANT_RECEIVED,
            NO_RECEIVED,
            RECEIVED
    };

    RewardStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RewardStatus getType(int value) {
        return switch (value) {
            case 0 -> CANT_RECEIVED;
            case 1 -> NO_RECEIVED;
            case 2 -> RECEIVED;
            default -> {
                LogUtils.logger.error("RewardStatus is not find value:{}",value);
                yield null;
            }
        };
    }
}
