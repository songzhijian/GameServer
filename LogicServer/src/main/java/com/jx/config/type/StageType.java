package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成StageType
 */
public enum StageType {

    /**
     * 时间(arg1:开始时间)
     */
    TIME(1),

    ;
    private int value;

    public static StageType[] ARRAY = {
            TIME
    };

    StageType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static StageType getType(int value) {
        return switch (value) {
            case 1 -> TIME;
            default -> {
                LogUtils.logger.error("StageType is not find value:{}",value);
                yield null;
            }
        };
    }
}
