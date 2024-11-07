package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成RandomType
 */
public enum RandomType {

    /**
     * 饼状随机
     */
    PIE_RANDOM(1),

    /**
     * 万分比随机
     */
    PART_PER_MILLION(2),

    ;
    private int value;

    public static RandomType[] ARRAY = {
            PIE_RANDOM,
            PART_PER_MILLION
    };

    RandomType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RandomType getType(int value) {
        return switch (value) {
            case 1 -> PIE_RANDOM;
            case 2 -> PART_PER_MILLION;
            default -> {
                LogUtils.logger.error("RandomType is not find value:{}",value);
                yield null;
            }
        };
    }
}
