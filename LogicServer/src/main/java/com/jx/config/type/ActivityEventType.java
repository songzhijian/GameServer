package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ActivityEventType
 */
public enum ActivityEventType {

    /**
     * 个人杀怪（ arg1:monsterId  arg2:num）
     */
    PERSON_KILL_MONSTER(0),

    /**
     * 联盟杀怪（ arg1:monsterId  arg2:num）
     */
    ALLIANCE_KILL_MONSTER(1),

    /**
     * 船长推关（arg1:layerId  arg2:enemyIndex  arg3:passAll ）
     */
    CAPTAIN_LAYER_UP(2),

    /**
     * 采集资源（arg1:ResourceType, arg2:num ）
     */
    COLLECT_RESOURCE(3),

    /**
     * 联盟占领城市（arg1:portConfigId  arg2:num）
     */
    ALLIANCE_OCCUPIED_CITY(4),

    /**
     * 船长提升战力（arg1:power   arg2:num ）
     */
    CAPTAIN_POWER_UP(5),

    /**
     * 船长主基地升级（ arg1:num ）
     */
    CAPTAIN_LV_UP(6),

    /**
     * 联盟采矿（arg1:WorldResourcePointConfigId  arg1:num）
     */
    ALLIANCE_COLLECT_MINE(7),

    /**
     * 贸易（arg1:港口id,arg2:num）
     */
    TRAD(8),

    /**
     * 收取队列（arg1:queueType,arg2:level（-1不限制）,arg3:num)
     */
    COLLECT_QUEUE(9),

    /**
     * 加速队列（arg1:queueType,arg2:level（-1不限制）,arg3:num)
     */
    ACCELERATE_QUEUE(10),

    /**
     * 招募（arg1:gachaId1,arg2:gachaid2……...argN:garchaNum) 最后一位默认为抽取次数，前面都是卡池id，表示在这些卡池抽卡都将被统计在计数中；arg1填-1默认为在所有卡池抽卡，后面卡池id无效
     */
    GACHA(11),

    /**
     * 商店 （arg1:shopId（-1不限制） arg2:num) 无
     */
    SHOP(12),

    /**
     * 击败（arg1:士兵等级，arg2:num）无
     */
    DEFEAT_SOLDIER_NUM(13),

    /**
     * 掠夺 （arg1:资源id，arg2:num）无
     */
    WORLD_ROB(14),

    /**
     * 购买钻石 （arg1:num）无
     */
    BUY_DIAMOND(15),

    /**
     * 加速士兵包括生产和升级（arg1:level（-1不限制）,arg2:num)
     */
    ACCELERATE_SOLDIER(16),

    /**
     * 集结或者单人都单独算分（ arg1:monsterId  arg2:num）
     */
    EVERYONE_KILL_MONSTER(17),

    /**
     * 贸易获取金币数量（arg1:num）
     */
    TRADE_GOLD(18),

    ;
    private int value;

    public static ActivityEventType[] ARRAY = {
            PERSON_KILL_MONSTER,
            ALLIANCE_KILL_MONSTER,
            CAPTAIN_LAYER_UP,
            COLLECT_RESOURCE,
            ALLIANCE_OCCUPIED_CITY,
            CAPTAIN_POWER_UP,
            CAPTAIN_LV_UP,
            ALLIANCE_COLLECT_MINE,
            TRAD,
            COLLECT_QUEUE,
            ACCELERATE_QUEUE,
            GACHA,
            SHOP,
            DEFEAT_SOLDIER_NUM,
            WORLD_ROB,
            BUY_DIAMOND,
            ACCELERATE_SOLDIER,
            EVERYONE_KILL_MONSTER,
            TRADE_GOLD
    };

    ActivityEventType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ActivityEventType getType(int value) {
        return switch (value) {
            case 0 -> PERSON_KILL_MONSTER;
            case 1 -> ALLIANCE_KILL_MONSTER;
            case 2 -> CAPTAIN_LAYER_UP;
            case 3 -> COLLECT_RESOURCE;
            case 4 -> ALLIANCE_OCCUPIED_CITY;
            case 5 -> CAPTAIN_POWER_UP;
            case 6 -> CAPTAIN_LV_UP;
            case 7 -> ALLIANCE_COLLECT_MINE;
            case 8 -> TRAD;
            case 9 -> COLLECT_QUEUE;
            case 10 -> ACCELERATE_QUEUE;
            case 11 -> GACHA;
            case 12 -> SHOP;
            case 13 -> DEFEAT_SOLDIER_NUM;
            case 14 -> WORLD_ROB;
            case 15 -> BUY_DIAMOND;
            case 16 -> ACCELERATE_SOLDIER;
            case 17 -> EVERYONE_KILL_MONSTER;
            case 18 -> TRADE_GOLD;
            default -> {
                LogUtils.logger.error("ActivityEventType is not find value:{}",value);
                yield null;
            }
        };
    }
}
