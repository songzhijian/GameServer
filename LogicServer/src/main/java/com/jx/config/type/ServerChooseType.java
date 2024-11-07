package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ServerChooseType
 */
public enum ServerChooseType {

    /**
     * 连续范围
     */
    CONTINUOUS_RANGE(1),

    /**
     * 单独指定
     */
    SPECIFIED_RANGE(2),

    ;
    private int value;

    public static ServerChooseType[] ARRAY = {
            CONTINUOUS_RANGE,
            SPECIFIED_RANGE
    };

    ServerChooseType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ServerChooseType getType(int value) {
        return switch (value) {
            case 1 -> CONTINUOUS_RANGE;
            case 2 -> SPECIFIED_RANGE;
            default -> {
                LogUtils.logger.error("ServerChooseType is not find value:{}",value);
                yield null;
            }
        };
    }
}
