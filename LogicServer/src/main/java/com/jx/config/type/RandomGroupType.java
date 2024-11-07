package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成RandomGroupType
 */
public enum RandomGroupType {

    /**
     * 随机组（arg1：随机权重）
     */
    RANDOM_GROUP(0),

    /**
     * 随机值（arg1：随机权重）
     */
    RANDOM_VALUE(1),

    ;
    private int value;

    public static RandomGroupType[] ARRAY = {
            RANDOM_GROUP,
            RANDOM_VALUE
    };

    RandomGroupType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RandomGroupType getType(int value) {
        return switch (value) {
            case 0 -> RANDOM_GROUP;
            case 1 -> RANDOM_VALUE;
            default -> {
                LogUtils.logger.error("RandomGroupType is not find value:{}",value);
                yield null;
            }
        };
    }
}
