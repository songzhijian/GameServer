package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成DestroyType
 */
public enum DestroyType {

    /**
     * 无操作
     */
    NONE(0),

    /**
     * 只保存玩家worldPlayer数据
     */
    WORLD_PLAYER_SAVE(1),

    /**
     * 玩家所有单位删除
     */
    PLAYER_ALL_UNIT_DELETE(2),

    /**
     * 迷雾删除
     */
    FOG_CLEAR(3),

    ;
    private int value;

    public static DestroyType[] ARRAY = {
            NONE,
            WORLD_PLAYER_SAVE,
            PLAYER_ALL_UNIT_DELETE,
            FOG_CLEAR
    };

    DestroyType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DestroyType getType(int value) {
        return switch (value) {
            case 0 -> NONE;
            case 1 -> WORLD_PLAYER_SAVE;
            case 2 -> PLAYER_ALL_UNIT_DELETE;
            case 3 -> FOG_CLEAR;
            default -> {
                LogUtils.logger.error("DestroyType is not find value:{}",value);
                yield null;
            }
        };
    }
}
