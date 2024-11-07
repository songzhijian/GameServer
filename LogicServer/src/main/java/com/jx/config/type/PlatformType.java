package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成PlatformType
 */
public enum PlatformType {

    /**
     * AppStore
     */
    APP_STORE(1),

    /**
     * google_market_global
     */
    MARKET_GLOBAL(2),

    /**
     * 设备
     */
    DEVICE(3),

    /**
     * im30
     */
    IM30(4),

    ;
    private int value;

    public static PlatformType[] ARRAY = {
            APP_STORE,
            MARKET_GLOBAL,
            DEVICE,
            IM30
    };

    PlatformType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PlatformType getType(int value) {
        return switch (value) {
            case 1 -> APP_STORE;
            case 2 -> MARKET_GLOBAL;
            case 3 -> DEVICE;
            case 4 -> IM30;
            default -> {
                LogUtils.logger.error("PlatformType is not find value:{}",value);
                yield null;
            }
        };
    }
}
