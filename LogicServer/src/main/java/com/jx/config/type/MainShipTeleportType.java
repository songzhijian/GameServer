package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成MainShipTeleportType
 */
public enum MainShipTeleportType {

    /**
     * 高级迁城
     */
    ADVANCED_TELEPORT(1),

    /**
     * 联盟迁城
     */
    ALLIANCE_TELEPORT(2),

    /**
     * 随机迁城
     */
    RANDOM_TELEPORT(3),

    /**
     * 新手传送
     */
    NEWBIES_TELEPORT(4),

    ;
    private int value;

    public static MainShipTeleportType[] ARRAY = {
            ADVANCED_TELEPORT,
            ALLIANCE_TELEPORT,
            RANDOM_TELEPORT,
            NEWBIES_TELEPORT
    };

    MainShipTeleportType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MainShipTeleportType getType(int value) {
        return switch (value) {
            case 1 -> ADVANCED_TELEPORT;
            case 2 -> ALLIANCE_TELEPORT;
            case 3 -> RANDOM_TELEPORT;
            case 4 -> NEWBIES_TELEPORT;
            default -> {
                LogUtils.logger.error("MainShipTeleportType is not find value:{}",value);
                yield null;
            }
        };
    }
}
