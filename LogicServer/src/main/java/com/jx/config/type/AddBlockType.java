package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AddBlockType
 */
public enum AddBlockType {

    /**
     * 环形
     */
    RING(0),

    ;
    private int value;

    public static AddBlockType[] ARRAY = {
            RING
    };

    AddBlockType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AddBlockType getType(int value) {
        return switch (value) {
            case 0 -> RING;
            default -> {
                LogUtils.logger.error("AddBlockType is not find value:{}",value);
                yield null;
            }
        };
    }
}
