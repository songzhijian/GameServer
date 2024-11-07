package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成SceneType
 */
public enum SceneType {

    /**
     * 大世界
     */
    WORLD(0),

    /**
     * 私人小世界
     */
    PERSONAL(1),

    ;
    private int value;

    public static SceneType[] ARRAY = {
            WORLD,
            PERSONAL
    };

    SceneType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SceneType getType(int value) {
        return switch (value) {
            case 0 -> WORLD;
            case 1 -> PERSONAL;
            default -> {
                LogUtils.logger.error("SceneType is not find value:{}",value);
                yield null;
            }
        };
    }
}
