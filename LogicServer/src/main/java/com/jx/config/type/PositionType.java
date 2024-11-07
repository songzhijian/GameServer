package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成PositionType
 */
public enum PositionType {

    /**
     * 固定坐标
     */
    FIXED_COORDINATE(0),

    ;
    private int value;

    public static PositionType[] ARRAY = {
            FIXED_COORDINATE
    };

    PositionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PositionType getType(int value) {
        return switch (value) {
            case 0 -> FIXED_COORDINATE;
            default -> {
                LogUtils.logger.error("PositionType is not find value:{}",value);
                yield null;
            }
        };
    }
}
