package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AllianceAuthorityType
 */
public enum AllianceAuthorityType {

    /**
     * 修改联盟公告
     */
    ANNOUNCEMENT(1),

    /**
     * 发布世界招募
     */
    WORLD_RECRUITMENT(2),

    /**
     * 审批权限
     */
    APPLY(3),

    /**
     * 修改联盟名称
     */
    CHANGE_NAME(4),

    /**
     * 修改联盟简称
     */
    CHANGE_BRIEF_NAME(5),

    /**
     * 修改联盟旗帜
     */
    ALLIANCE_FLAG(6),

    /**
     * 解散联盟
     */
    DISSOLVE(7),

    /**
     * 转让盟主
     */
    TRANSFER(8),

    /**
     * 邀请入盟
     */
    INVITE(9),

    /**
     * 请离联盟
     */
    KICK(10),

    /**
     * 调整成员阶级
     */
    CHANGE_RANK(11),

    /**
     * 退出联盟
     */
    QUIT(12),

    /**
     * 联盟基本设置
     */
    ALLIANCE_SETTING(13),

    /**
     * 更换联盟母港
     */
    CHANGE_HOME_PORT(14),

    /**
     * 放弃联盟港口
     */
    ABANDON_PORT(15),

    /**
     * 查看成员在线状态
     */
    ONLINE_STATE(16),

    /**
     * 任命官员
     */
    APPOINTMENT(17),

    /**
     * 开启联盟活动
     */
    ALLIANCE_ACTIVITY(18),

    /**
     * 发起战区转移
     */
    TRANSFER_ZONE(19),

    /**
     * 发起投票
     */
    INITIATE_VOTE(20),

    /**
     * @所有人
     */
    REMIND_ALL(21),

    /**
     * 遣返港口援助
     */
    KICK_PORT_GARRISON(22),

    ;
    private int value;

    public static AllianceAuthorityType[] ARRAY = {
            ANNOUNCEMENT,
            WORLD_RECRUITMENT,
            APPLY,
            CHANGE_NAME,
            CHANGE_BRIEF_NAME,
            ALLIANCE_FLAG,
            DISSOLVE,
            TRANSFER,
            INVITE,
            KICK,
            CHANGE_RANK,
            QUIT,
            ALLIANCE_SETTING,
            CHANGE_HOME_PORT,
            ABANDON_PORT,
            ONLINE_STATE,
            APPOINTMENT,
            ALLIANCE_ACTIVITY,
            TRANSFER_ZONE,
            INITIATE_VOTE,
            REMIND_ALL,
            KICK_PORT_GARRISON
    };

    AllianceAuthorityType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AllianceAuthorityType getType(int value) {
        return switch (value) {
            case 1 -> ANNOUNCEMENT;
            case 2 -> WORLD_RECRUITMENT;
            case 3 -> APPLY;
            case 4 -> CHANGE_NAME;
            case 5 -> CHANGE_BRIEF_NAME;
            case 6 -> ALLIANCE_FLAG;
            case 7 -> DISSOLVE;
            case 8 -> TRANSFER;
            case 9 -> INVITE;
            case 10 -> KICK;
            case 11 -> CHANGE_RANK;
            case 12 -> QUIT;
            case 13 -> ALLIANCE_SETTING;
            case 14 -> CHANGE_HOME_PORT;
            case 15 -> ABANDON_PORT;
            case 16 -> ONLINE_STATE;
            case 17 -> APPOINTMENT;
            case 18 -> ALLIANCE_ACTIVITY;
            case 19 -> TRANSFER_ZONE;
            case 20 -> INITIATE_VOTE;
            case 21 -> REMIND_ALL;
            case 22 -> KICK_PORT_GARRISON;
            default -> {
                LogUtils.logger.error("AllianceAuthorityType is not find value:{}",value);
                yield null;
            }
        };
    }
}
