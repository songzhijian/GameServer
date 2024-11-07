package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ChatPostType
 */
public enum ChatPostType {

    /**
     * 普通聊天
     */
    COMMON(0),

    /**
     * 联盟新成员加入
     */
    ALLIANCE_MEMBER_JOIN(1),

    /**
     * 联盟成员退盟
     */
    ALLIANCE_MEMBER_LEAVE(2),

    /**
     * 联盟阶级rank提升
     */
    ALLIANCE_RANK_UP(3),

    /**
     * 联盟阶级rank降低
     */
    ALLIANCE_RANK_DOWN(4),

    /**
     * 联盟踢人
     */
    ALLIANCE_KICK(5),

    /**
     * 转让盟主
     */
    ALLIANCE_TRANSFER_LEADER(6),

    /**
     * 官职任命
     */
    ALLIANCE_APPOINT_OFFICIAL(7),

    /**
     * 官职卸任
     */
    ALLIANCE_REMOVE_OFFICIAL(8),

    ;
    private int value;

    public static ChatPostType[] ARRAY = {
            COMMON,
            ALLIANCE_MEMBER_JOIN,
            ALLIANCE_MEMBER_LEAVE,
            ALLIANCE_RANK_UP,
            ALLIANCE_RANK_DOWN,
            ALLIANCE_KICK,
            ALLIANCE_TRANSFER_LEADER,
            ALLIANCE_APPOINT_OFFICIAL,
            ALLIANCE_REMOVE_OFFICIAL
    };

    ChatPostType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ChatPostType getType(int value) {
        return switch (value) {
            case 0 -> COMMON;
            case 1 -> ALLIANCE_MEMBER_JOIN;
            case 2 -> ALLIANCE_MEMBER_LEAVE;
            case 3 -> ALLIANCE_RANK_UP;
            case 4 -> ALLIANCE_RANK_DOWN;
            case 5 -> ALLIANCE_KICK;
            case 6 -> ALLIANCE_TRANSFER_LEADER;
            case 7 -> ALLIANCE_APPOINT_OFFICIAL;
            case 8 -> ALLIANCE_REMOVE_OFFICIAL;
            default -> {
                LogUtils.logger.error("ChatPostType is not find value:{}",value);
                yield null;
            }
        };
    }
}
