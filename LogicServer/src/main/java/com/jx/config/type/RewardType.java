package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成RewardType
 */
public enum RewardType {

    /**
     * 随机(随机组)
     */
    RANDOM(0),

    /**
     * 固定物品（arg1：物品id,arg2:数量）
     */
    ITEM(1),

    /**
     * 固定资源（arg1：资源id,arg2:数量）
     */
    RESOURCE(2),

    /**
     * 固定英雄（arg1：英雄id,arg2:品质，arg3：数量，arg4：等级-缺省按1级处理）
     */
    HERO(3),

    /**
     * 固定装备（arg1：装备id,arg2:强化星级，arg3：raceBuff，arg4：数量）
     */
    EQUIP(4),

    /**
     * 固定水兵（arg1：等级id,arg2:数量）
     */
    NAVY(5),

    /**
     * 固定交易品（arg1：物品id,arg2：星级,arg3:数量）
     */
    GOOD(6),

    /**
     * 固定药品-饮用水-食品（arg1：typeid,arg2：物品id,arg3:数量）
     */
    STORAGE(7),

    /**
     * 固定船（arg1：船Id）
     */
    SHIP(11),

    /**
     * 固定船装备（arg1：船装备id,arg2：数量）
     */
    SHIPEQUIP(12),

    /**
     * 固定航海装备（arg1：航海装备id,arg2:强化星级,arg3：数量）
     */
    NAUTICSEQUIP(13),

    /**
     * 固定船装饰（arg1：装饰id）
     */
    SHIPDECORATE(14),

    /**
     * 固定小船（arg1：boatid，arg2:数量）
     */
    BOAT(15),

    /**
     * 固定财宝（arg1：财宝id，arg2:数量）
     */
    TREASURE(16),

    /**
     * 固定圣物（arg1：圣物id，arg2:数量）
     */
    HOLYRELIC(17),

    /**
     * 固定神器（arg1：神器id）
     */
    ARTIFACT(18),

    /**
     * 无字之书能量（arg1：0=占位符，arg2：数量）
     */
    WORD_LESS_BOOK_ENERGY(19),

    /**
     * VIP经验（arg1：数量）
     */
    VIP_EXP(20),

    /**
     * 宝盒金币（arg1:进度）0给宝箱，数字给金币进度
     */
    CHEST_GOLD(21),

    /**
     * battlePass经验（arg1:battlePassId，arg2:数量）
     */
    BATTLE_PASS(22),

    /**
     * 增加冒险经验（arg1：9500，arg2:数量）9500为item_info表中用于显示的假道具
     */
    ADVENTURE_EXP(23),

    /**
     * 委托任务次数（arg1:数量）
     */
    ENTRUST(24),

    /**
     * 添加活跃值（arg1:activeType，arg2：类型对应参数，arg3:数量）
     */
    ACTIVE(101),

    /**
     * 饱腹度（arg1：数量）
     */
    SATIETY(102),

    /**
     * 联盟礼物（arg1：联盟礼物id,arg2:数量）
     */
    ALLIANCE_GIFT(103),

    /**
     * 外显（arg1：外显id，arg2：持续时间（秒，永久填-1））
     */
    SHOW(104),

    /**
     * 积分（arg1：积分id，arg2：数量）关联Points表
     */
    POINT(105),

    /**
     * 主城全局Buff（arg1：buffid）
     */
    MAIN_SHIP_BUFF(201),

    ;
    private int value;

    public static RewardType[] ARRAY = {
            RANDOM,
            ITEM,
            RESOURCE,
            HERO,
            EQUIP,
            NAVY,
            GOOD,
            STORAGE,
            SHIP,
            SHIPEQUIP,
            NAUTICSEQUIP,
            SHIPDECORATE,
            BOAT,
            TREASURE,
            HOLYRELIC,
            ARTIFACT,
            WORD_LESS_BOOK_ENERGY,
            VIP_EXP,
            CHEST_GOLD,
            BATTLE_PASS,
            ADVENTURE_EXP,
            ENTRUST,
            ACTIVE,
            SATIETY,
            ALLIANCE_GIFT,
            SHOW,
            POINT,
            MAIN_SHIP_BUFF
    };

    RewardType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RewardType getType(int value) {
        return switch (value) {
            case 0 -> RANDOM;
            case 1 -> ITEM;
            case 2 -> RESOURCE;
            case 3 -> HERO;
            case 4 -> EQUIP;
            case 5 -> NAVY;
            case 6 -> GOOD;
            case 7 -> STORAGE;
            case 11 -> SHIP;
            case 12 -> SHIPEQUIP;
            case 13 -> NAUTICSEQUIP;
            case 14 -> SHIPDECORATE;
            case 15 -> BOAT;
            case 16 -> TREASURE;
            case 17 -> HOLYRELIC;
            case 18 -> ARTIFACT;
            case 19 -> WORD_LESS_BOOK_ENERGY;
            case 20 -> VIP_EXP;
            case 21 -> CHEST_GOLD;
            case 22 -> BATTLE_PASS;
            case 23 -> ADVENTURE_EXP;
            case 24 -> ENTRUST;
            case 101 -> ACTIVE;
            case 102 -> SATIETY;
            case 103 -> ALLIANCE_GIFT;
            case 104 -> SHOW;
            case 105 -> POINT;
            case 201 -> MAIN_SHIP_BUFF;
            default -> {
                LogUtils.logger.error("RewardType is not find value:{}",value);
                yield null;
            }
        };
    }
}
