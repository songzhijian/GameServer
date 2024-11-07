package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AllianceChatType
 */
public enum AllianceChatType {

    /**
     * 新成员加入
     */
    NEW_MEMBER_JOIN(1),

    /**
     * 成员退盟
     */
    MEMBER_LEAVE(2),

    /**
     * 阶级调整（提升）
     */
    RANK_CHANGE(3),

    /**
     * 踢人
     */
    KICK_MEMBER(4),

    /**
     * 转让盟主
     */
    TRANSFER_LEADER(5),

    /**
     * 官职任命
     */
    APPOINT_OFFICIAL(6),

    /**
     * 官职卸任
     */
    REMOVE_OFFICIAL(7),

    /**
     * 阶级调整（降低）
     */
    RANK_CHANGE_DOWN(8),

    ;
    private int value;

    public static AllianceChatType[] ARRAY = {
            NEW_MEMBER_JOIN,
            MEMBER_LEAVE,
            RANK_CHANGE,
            KICK_MEMBER,
            TRANSFER_LEADER,
            APPOINT_OFFICIAL,
            REMOVE_OFFICIAL,
            RANK_CHANGE_DOWN
    };

    AllianceChatType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AllianceChatType getType(int value) {
        return switch (value) {
            case 1 -> NEW_MEMBER_JOIN;
            case 2 -> MEMBER_LEAVE;
            case 3 -> RANK_CHANGE;
            case 4 -> KICK_MEMBER;
            case 5 -> TRANSFER_LEADER;
            case 6 -> APPOINT_OFFICIAL;
            case 7 -> REMOVE_OFFICIAL;
            case 8 -> RANK_CHANGE_DOWN;
            default -> {
                LogUtils.logger.error("AllianceChatType is not find value:{}",value);
                yield null;
            }
        };
    }
}
