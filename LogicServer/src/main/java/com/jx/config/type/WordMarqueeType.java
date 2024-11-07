package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成WordMarqueeType
 */
public enum WordMarqueeType {

    /**
     * {0}通过途径{1}获得了英雄{2}！
     */
    GERHEROBROADCAST(1),

    /**
     * {0}发动了联盟技能{1}！
     */
    USEALLIANCESKILLBROADCAST(2),

    /**
     * 游戏将在{0}分钟后进行维护，请玩家及时下线，避免损失
     */
    MAINTENANCEBROADCAST(3),

    /**
     * 活动{0}将在{1}分钟后开启！
     */
    ACTIVITYOPENBROADCAST(4),

    /**
     * 天下大势阶段{0}达成
     */
    TRENDREACHBROADCAST(5),

    /**
     * 联盟{0}占领了{1}！
     */
    ALLIANCEGETCITYBROADCASTALL(6),

    /**
     * 联盟{0}占领了{1}！
     */
    ALLIANCEGETCITYBROADCAST(7),

    /**
     * 联盟{0}首次占领了{1}！
     */
    ALLIANCEFIRSTGETCITYBROADCAST(8),

    ;
    private int value;

    public static WordMarqueeType[] ARRAY = {
            GERHEROBROADCAST,
            USEALLIANCESKILLBROADCAST,
            MAINTENANCEBROADCAST,
            ACTIVITYOPENBROADCAST,
            TRENDREACHBROADCAST,
            ALLIANCEGETCITYBROADCASTALL,
            ALLIANCEGETCITYBROADCAST,
            ALLIANCEFIRSTGETCITYBROADCAST
    };

    WordMarqueeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static WordMarqueeType getType(int value) {
        return switch (value) {
            case 1 -> GERHEROBROADCAST;
            case 2 -> USEALLIANCESKILLBROADCAST;
            case 3 -> MAINTENANCEBROADCAST;
            case 4 -> ACTIVITYOPENBROADCAST;
            case 5 -> TRENDREACHBROADCAST;
            case 6 -> ALLIANCEGETCITYBROADCASTALL;
            case 7 -> ALLIANCEGETCITYBROADCAST;
            case 8 -> ALLIANCEFIRSTGETCITYBROADCAST;
            default -> {
                LogUtils.logger.error("WordMarqueeType is not find value:{}",value);
                yield null;
            }
        };
    }
}
