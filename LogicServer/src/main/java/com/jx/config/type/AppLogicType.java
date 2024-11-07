package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AppLogicType
 */
public enum AppLogicType {

    /**
     * uuid异步生成
     */
    UUID(0),

    /**
     * 寻路
     */
    FIND_PATH(1),

    /**
     * 缓存
     */
    CACHE(2),

    /**
     * Aoi推送
     */
    AOI_PUSH(3),

    ;
    private int value;

    public static AppLogicType[] ARRAY = {
            UUID,
            FIND_PATH,
            CACHE,
            AOI_PUSH
    };

    AppLogicType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AppLogicType getType(int value) {
        return switch (value) {
            case 0 -> UUID;
            case 1 -> FIND_PATH;
            case 2 -> CACHE;
            case 3 -> AOI_PUSH;
            default -> {
                LogUtils.logger.error("AppLogicType is not find value:{}",value);
                yield null;
            }
        };
    }
}
