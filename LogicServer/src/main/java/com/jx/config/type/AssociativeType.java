package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AssociativeType
 */
public enum AssociativeType {

    /**
     * 全局数据
     */
    GLOBAL_DATA(1),

    /**
     * 玩家活跃值系统
     */
    ACTIVE_DATA(2),

    /**
     * 全局管理数据，但不跨服
     */
    GLOBAL_DATA_NO_CROSS(3),

    ;
    private int value;

    public static AssociativeType[] ARRAY = {
            GLOBAL_DATA,
            ACTIVE_DATA,
            GLOBAL_DATA_NO_CROSS
    };

    AssociativeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AssociativeType getType(int value) {
        return switch (value) {
            case 1 -> GLOBAL_DATA;
            case 2 -> ACTIVE_DATA;
            case 3 -> GLOBAL_DATA_NO_CROSS;
            default -> {
                LogUtils.logger.error("AssociativeType is not find value:{}",value);
                yield null;
            }
        };
    }
}
