package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成MoveType
 */
public enum MoveType {

    /**
     * 陆地
     */
    LAND_MOVE_TYPE(0),

    /**
     * 
     */
    NORMAL_SEA_MOVE_TYPE(1),

    /**
     * 
     */
    SHALLOW_SEA_MOVE_TYPE(2),

    /**
     * 
     */
    DEEP_SEA_MOVE_TYPE(3),

    ;
    private int value;

    public static MoveType[] ARRAY = {
            LAND_MOVE_TYPE,
            NORMAL_SEA_MOVE_TYPE,
            SHALLOW_SEA_MOVE_TYPE,
            DEEP_SEA_MOVE_TYPE
    };

    MoveType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MoveType getType(int value) {
        return switch (value) {
            case 0 -> LAND_MOVE_TYPE;
            case 1 -> NORMAL_SEA_MOVE_TYPE;
            case 2 -> SHALLOW_SEA_MOVE_TYPE;
            case 3 -> DEEP_SEA_MOVE_TYPE;
            default -> {
                LogUtils.logger.error("MoveType is not find value:{}",value);
                yield null;
            }
        };
    }
}
