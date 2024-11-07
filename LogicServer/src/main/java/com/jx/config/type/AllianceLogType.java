package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AllianceLogType
 */
public enum AllianceLogType {

    /**
     * 创建联盟
     */
    ALLIANCE_CREATE(1),

    /**
     * 新成员加入联盟
     */
    MEMBER_ADD(2),

    /**
     * 成员离开联盟
     */
    MEMBER_LEAVE(3),

    /**
     * 成员被请离联盟
     */
    MEMBER_KICK(4),

    ;
    private int value;

    public static AllianceLogType[] ARRAY = {
            ALLIANCE_CREATE,
            MEMBER_ADD,
            MEMBER_LEAVE,
            MEMBER_KICK
    };

    AllianceLogType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AllianceLogType getType(int value) {
        return switch (value) {
            case 1 -> ALLIANCE_CREATE;
            case 2 -> MEMBER_ADD;
            case 3 -> MEMBER_LEAVE;
            case 4 -> MEMBER_KICK;
            default -> {
                LogUtils.logger.error("AllianceLogType is not find value:{}",value);
                yield null;
            }
        };
    }
}
