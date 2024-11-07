package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成BusinessType
 */
public enum BusinessType {

    /**
     * 抽卡
     */
    GACHA_REWARD(1),

    /**
     * 出生奖励
     */
    BORN(2),

    /**
     * 任务
     */
    TASK_REWARD(3),

    /**
     * 使用道具
     */
    USE_ITEM(4),

    /**
     * 英雄升级
     */
    HERO_LEVEL_UP(5),

    /**
     * 英雄专属装备升级
     */
    HERO_EXCLUSIVE_LEVEL_UP(6),

    /**
     * 装备强化
     */
    EQUIP_STRENGTHEN(7),

    /**
     * 装备洗练
     */
    EQUIP_RECOIN(8),

    /**
     * 装备进阶
     */
    EQUIP_ENHANCE(9),

    /**
     * 捡垃圾奖励
     */
    DRIFTING_REWARD(10),

    /**
     * 木筏物品制作
     */
    RAFT_ITEM_CRAFTING(11),

    /**
     * 钓鱼
     */
    FISHING(12),

    /**
     * 木筏建造
     */
    RAFT_CREATE(13),

    /**
     * 创建联盟
     */
    ALLIANCE_CREATE(14),

    /**
     * 联盟名称修改
     */
    ALLIANCE_NAME_CHANGE(15),

    /**
     * 联盟简称修改
     */
    ALLIANCE_ABBR_CHANGE(16),

    /**
     * 联盟旗帜修改
     */
    ALLIANCE_ICON_CHANGE(17),

    /**
     * 活跃
     */
    ACTIVE(18),

    /**
     * 购买新船只
     */
    BUY_SHIP(19),

    /**
     * 饱腹度0后修改
     */
    HUNGER(20),

    /**
     * 建筑消耗
     */
    BUILDING(21),

    /**
     * 贸易
     */
    TRADE(22),

    /**
     * 推图奖励
     */
    CHAPTER_STAGE_REWARD(23),

    /**
     * 训练士兵消耗
     */
    TRAIN_NAVY(24),

    /**
     * 升级士兵消耗
     */
    UPGRADE_NAVY(25),

    /**
     * 击败普通怪
     */
    ATT_WIN_NORMAL_MONSTER(26),

    /**
     * 世界小船立即回家
     */
    WORLD_BOAT_IMMEDIATELY_RETURN_HOME(27),

    /**
     * 打击海盗分支解锁消耗
     */
    STRIKE_PIRATE_UNLOCK_BRANCH(28),

    /**
     * 打击海盗挂机奖励
     */
    STRIKE_PIRATE_HANG_UP(29),

    /**
     * 打击海盗分支奖励
     */
    STRIKE_PIRATE_BOUNDS(30),

    /**
     * 采矿
     */
    WORLD_EXPLOIT_MINE(31),

    /**
     * 世界 抢劫掠夺
     */
    WORLD_ROB(32),

    /**
     * 更换船装饰消耗
     */
    SHIP_DECORATE(33),

    /**
     * 英雄重置
     */
    HERO_RESET(34),

    /**
     * 英雄回退
     */
    HERO_ROLLBACK(35),

    /**
     * 英雄遣散
     */
    HERO_DISMISS(36),

    /**
     * 英雄升阶
     */
    HERO_QUALITY_UP(37),

    /**
     * 加入联盟
     */
    ALLIANCE_JOIN(38),

    /**
     * 仓库制作
     */
    STORAGE_MAKE_ITEM(39),

    /**
     * 港口商店
     */
    PORT_SHOP(40),

    /**
     * 竞技场
     */
    ARENA(41),

    /**
     * 科技
     */
    TECH_RESEARCH(42),

    /**
     * 怪物首通
     */
    MONSTER_FIRST_KILL(43),

    /**
     * 无字之书升级
     */
    WORD_LESS_BOOK_LV_UP(44),

    /**
     * 世界标记
     */
    WORLD_FLAG(45),

    /**
     * 图鉴领奖
     */
    HAND_BOOK_REWARD(46),

    /**
     * 掠夺资源
     */
    PLUNDER_RESOURCE(47),

    /**
     * 抢夺贸易
     */
    PLUNDER_TRADE(48),

    /**
     * 占领港口
     */
    OCCUPY_PORT(49),

    /**
     * 玩家改名
     */
    CHANGE_NAME(50),

    /**
     * 神器阶段提升
     */
    ARTIFACT_PHASE_UP(51),

    /**
     * 联盟帮助
     */
    ALLIANCE_HELP(52),

    /**
     * 首充双倍
     */
    PAY_FIRST(53),

    /**
     * 支付礼包
     */
    PAY_GIFT(54),

    /**
     * 月卡
     */
    MONTHLY_CARD(55),

    /**
     * vip每日奖励
     */
    VIP_DAILY_REWARD(56),

    /**
     * 无字之书能量收集
     */
    WORD_LESS_BOOK_COLLECTION_ENERGY(57),

    /**
     * 迁城
     */
    TELEPORT(58),

    /**
     * 瞭望塔情报领奖
     */
    TOWER_POINT(59),

    /**
     * 大世界出生选择推荐
     */
    CHOOSE_BORN_BUSINESSID(60),

    /**
     * 天下大势领奖
     */
    TREND_TASK_AWARD(61),

    /**
     * 港口势力值每日奖励
     */
    PORT_FORCE_DAILY_REWARD(62),

    /**
     * 联盟礼物
     */
    ALLIANCE_GIFT(63),

    /**
     * 联盟宝藏
     */
    ALLIANCE_TREASURE(64),

    /**
     * 快捷补齐
     */
    QUICK_SUPPLY(65),

    /**
     * 搜寻室领奖
     */
    SEARCH_ROOM_REWARD(66),

    /**
     * VIP商店
     */
    VIP_SHOP(67),

    /**
     * 搜寻室的船升级
     */
    SEARCH_ROOM_SHIP_LV_UP(68),

    /**
     * 引导
     */
    GUIDE(69),

    /**
     * 使用资源道具
     */
    USE_ITEM_RESOURCE(70),

    /**
     * 排行榜奖励邮件
     */
    RANK_REWARD_MAIL(71),

    /**
     * 排行榜奖励领取
     */
    RANK_REWARD_GET(72),

    /**
     * 销毁仓库里的物品
     */
    DESTROY_STORAGE_ITEM(73),

    /**
     * 首次驻港奖励
     */
    FIRST_DISCOVERY_REWARD(74),

    /**
     * 水兵、驻扎英雄定时消耗食物
     */
    FOOD_PERIOD_CONSUME(75),

    /**
     * 水兵、驻扎英雄定时消耗水
     */
    WATER_PERIOD_CONSUME(76),

    /**
     * 联盟战功商店
     */
    MILITARY_SHOP(77),

    /**
     * 联盟每日特惠
     */
    ALLIANCE_DAILY_SHOP(78),

    /**
     * 活动
     */
    ACTIVITY(79),

    /**
     * 英雄自动遣散
     */
    HERO_AUTO_DISMISS(80),

    /**
     * 战利品宝箱
     */
    TROPHY_PICK(81),

    /**
     * 新手战斗奖励
     */
    NEWBIE_BATTLE_REWARD(82),

    /**
     * 开服嘉年华福利奖励
     */
    ACTIVITY_CARNIVAL_BENEFITS_REWARD(83),

    /**
     * 开服嘉年华折扣礼包消耗
     */
    ACTIVITY_CARNIVAL_BUY_PRODUCT_CONSUME(84),

    /**
     * 开服嘉年华折扣礼包奖励
     */
    ACTIVITY_CARNIVAL_BUY_PRODUCT_REWARD(85),

    /**
     * 开服嘉年华活跃奖励
     */
    ACTIVITY_CARNIVAL_ACTIVE_REWARD(86),

    /**
     * 开服嘉年华活动奖励补发
     */
    ACTIVITY_CARNIVAL_REWARD_MAIL(87),

    /**
     * 冲榜活动任务奖励补发
     */
    CLIMB_RANK_ACTIVITY_TASK_REWARD_MAIL(88),

    /**
     * 开服在线活动奖励
     */
    ACTIVITY_ONLINE_TIME_REWARD(89),

    /**
     * 开服在线活动奖励补发邮件
     */
    ACTIVITY_ONLINE_TIME_REWARD_MAIL(90),

    /**
     * 遣返商店
     */
    COIN_DISBAND_SHOP(91),

    /**
     * 兑换码
     */
    CDKEY_REWARD(92),

    /**
     * 战令BP
     */
    BATTLE_PASS(93),

    /**
     * 成长基金
     */
    GROWTH_FUND(94),

    /**
     * 打击海盗主线奖励
     */
    STRIKE_PIRATE_MAIN_BONUS(95),

    /**
     * 普通抽卡
     */
    NORMAL_GACHA(96),

    /**
     * 阵营抽1
     */
    CAMP_GACHA_1(97),

    /**
     * 阵营抽2
     */
    CAMP_GACHA_2(98),

    /**
     * 阵营抽3
     */
    CAMP_GACHA_3(99),

    /**
     * 阵营抽4
     */
    CAMP_GACHA_4(100),

    /**
     * 占星
     */
    ASTROLOGY_GACHA(101),

    /**
     * 秘境奖励
     */
    MAZE_REWARD(102),

    /**
     * 秘境复活币消耗
     */
    MAZE_RESURRECT_COST(103),

    /**
     * 打击海盗快速挂机消耗
     */
    STRIKE_PIRATE_QUICK_HANG_UP_CONSUME(104),

    /**
     * 打击海盗快速挂机奖励
     */
    STRIKE_PIRATE_QUICK_HANG_UP_REWARD(105),

    /**
     * 章鱼宝箱奖励
     */
    OCTOPUS_TREASURE_CHEST(106),

    /**
     * 加速界面购买加速道具
     */
    ACCELERATE_ITEM_BUY(107),

    /**
     * 委托任务
     */
    ENTRUST_COST(108),

    /**
     * 联盟BOSS奖励
     */
    ALLIANCE_BOSS(109),

    /**
     * 押镖奖励
     */
    TRANSPORT_REWARD(110),

    /**
     * 劫镖奖励
     */
    ROBBERY_REWARD(111),

    /**
     * GM奖励
     */
    GM_REWARD(1001),

    ;
    private int value;

    public static BusinessType[] ARRAY = {
            GACHA_REWARD,
            BORN,
            TASK_REWARD,
            USE_ITEM,
            HERO_LEVEL_UP,
            HERO_EXCLUSIVE_LEVEL_UP,
            EQUIP_STRENGTHEN,
            EQUIP_RECOIN,
            EQUIP_ENHANCE,
            DRIFTING_REWARD,
            RAFT_ITEM_CRAFTING,
            FISHING,
            RAFT_CREATE,
            ALLIANCE_CREATE,
            ALLIANCE_NAME_CHANGE,
            ALLIANCE_ABBR_CHANGE,
            ALLIANCE_ICON_CHANGE,
            ACTIVE,
            BUY_SHIP,
            HUNGER,
            BUILDING,
            TRADE,
            CHAPTER_STAGE_REWARD,
            TRAIN_NAVY,
            UPGRADE_NAVY,
            ATT_WIN_NORMAL_MONSTER,
            WORLD_BOAT_IMMEDIATELY_RETURN_HOME,
            STRIKE_PIRATE_UNLOCK_BRANCH,
            STRIKE_PIRATE_HANG_UP,
            STRIKE_PIRATE_BOUNDS,
            WORLD_EXPLOIT_MINE,
            WORLD_ROB,
            SHIP_DECORATE,
            HERO_RESET,
            HERO_ROLLBACK,
            HERO_DISMISS,
            HERO_QUALITY_UP,
            ALLIANCE_JOIN,
            STORAGE_MAKE_ITEM,
            PORT_SHOP,
            ARENA,
            TECH_RESEARCH,
            MONSTER_FIRST_KILL,
            WORD_LESS_BOOK_LV_UP,
            WORLD_FLAG,
            HAND_BOOK_REWARD,
            PLUNDER_RESOURCE,
            PLUNDER_TRADE,
            OCCUPY_PORT,
            CHANGE_NAME,
            ARTIFACT_PHASE_UP,
            ALLIANCE_HELP,
            PAY_FIRST,
            PAY_GIFT,
            MONTHLY_CARD,
            VIP_DAILY_REWARD,
            WORD_LESS_BOOK_COLLECTION_ENERGY,
            TELEPORT,
            TOWER_POINT,
            CHOOSE_BORN_BUSINESSID,
            TREND_TASK_AWARD,
            PORT_FORCE_DAILY_REWARD,
            ALLIANCE_GIFT,
            ALLIANCE_TREASURE,
            QUICK_SUPPLY,
            SEARCH_ROOM_REWARD,
            VIP_SHOP,
            SEARCH_ROOM_SHIP_LV_UP,
            GUIDE,
            USE_ITEM_RESOURCE,
            RANK_REWARD_MAIL,
            RANK_REWARD_GET,
            DESTROY_STORAGE_ITEM,
            FIRST_DISCOVERY_REWARD,
            FOOD_PERIOD_CONSUME,
            WATER_PERIOD_CONSUME,
            MILITARY_SHOP,
            ALLIANCE_DAILY_SHOP,
            ACTIVITY,
            HERO_AUTO_DISMISS,
            TROPHY_PICK,
            NEWBIE_BATTLE_REWARD,
            ACTIVITY_CARNIVAL_BENEFITS_REWARD,
            ACTIVITY_CARNIVAL_BUY_PRODUCT_CONSUME,
            ACTIVITY_CARNIVAL_BUY_PRODUCT_REWARD,
            ACTIVITY_CARNIVAL_ACTIVE_REWARD,
            ACTIVITY_CARNIVAL_REWARD_MAIL,
            CLIMB_RANK_ACTIVITY_TASK_REWARD_MAIL,
            ACTIVITY_ONLINE_TIME_REWARD,
            ACTIVITY_ONLINE_TIME_REWARD_MAIL,
            COIN_DISBAND_SHOP,
            CDKEY_REWARD,
            BATTLE_PASS,
            GROWTH_FUND,
            STRIKE_PIRATE_MAIN_BONUS,
            NORMAL_GACHA,
            CAMP_GACHA_1,
            CAMP_GACHA_2,
            CAMP_GACHA_3,
            CAMP_GACHA_4,
            ASTROLOGY_GACHA,
            MAZE_REWARD,
            MAZE_RESURRECT_COST,
            STRIKE_PIRATE_QUICK_HANG_UP_CONSUME,
            STRIKE_PIRATE_QUICK_HANG_UP_REWARD,
            OCTOPUS_TREASURE_CHEST,
            ACCELERATE_ITEM_BUY,
            ENTRUST_COST,
            ALLIANCE_BOSS,
            TRANSPORT_REWARD,
            ROBBERY_REWARD,
            GM_REWARD
    };

    BusinessType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BusinessType getType(int value) {
        return switch (value) {
            case 1 -> GACHA_REWARD;
            case 2 -> BORN;
            case 3 -> TASK_REWARD;
            case 4 -> USE_ITEM;
            case 5 -> HERO_LEVEL_UP;
            case 6 -> HERO_EXCLUSIVE_LEVEL_UP;
            case 7 -> EQUIP_STRENGTHEN;
            case 8 -> EQUIP_RECOIN;
            case 9 -> EQUIP_ENHANCE;
            case 10 -> DRIFTING_REWARD;
            case 11 -> RAFT_ITEM_CRAFTING;
            case 12 -> FISHING;
            case 13 -> RAFT_CREATE;
            case 14 -> ALLIANCE_CREATE;
            case 15 -> ALLIANCE_NAME_CHANGE;
            case 16 -> ALLIANCE_ABBR_CHANGE;
            case 17 -> ALLIANCE_ICON_CHANGE;
            case 18 -> ACTIVE;
            case 19 -> BUY_SHIP;
            case 20 -> HUNGER;
            case 21 -> BUILDING;
            case 22 -> TRADE;
            case 23 -> CHAPTER_STAGE_REWARD;
            case 24 -> TRAIN_NAVY;
            case 25 -> UPGRADE_NAVY;
            case 26 -> ATT_WIN_NORMAL_MONSTER;
            case 27 -> WORLD_BOAT_IMMEDIATELY_RETURN_HOME;
            case 28 -> STRIKE_PIRATE_UNLOCK_BRANCH;
            case 29 -> STRIKE_PIRATE_HANG_UP;
            case 30 -> STRIKE_PIRATE_BOUNDS;
            case 31 -> WORLD_EXPLOIT_MINE;
            case 32 -> WORLD_ROB;
            case 33 -> SHIP_DECORATE;
            case 34 -> HERO_RESET;
            case 35 -> HERO_ROLLBACK;
            case 36 -> HERO_DISMISS;
            case 37 -> HERO_QUALITY_UP;
            case 38 -> ALLIANCE_JOIN;
            case 39 -> STORAGE_MAKE_ITEM;
            case 40 -> PORT_SHOP;
            case 41 -> ARENA;
            case 42 -> TECH_RESEARCH;
            case 43 -> MONSTER_FIRST_KILL;
            case 44 -> WORD_LESS_BOOK_LV_UP;
            case 45 -> WORLD_FLAG;
            case 46 -> HAND_BOOK_REWARD;
            case 47 -> PLUNDER_RESOURCE;
            case 48 -> PLUNDER_TRADE;
            case 49 -> OCCUPY_PORT;
            case 50 -> CHANGE_NAME;
            case 51 -> ARTIFACT_PHASE_UP;
            case 52 -> ALLIANCE_HELP;
            case 53 -> PAY_FIRST;
            case 54 -> PAY_GIFT;
            case 55 -> MONTHLY_CARD;
            case 56 -> VIP_DAILY_REWARD;
            case 57 -> WORD_LESS_BOOK_COLLECTION_ENERGY;
            case 58 -> TELEPORT;
            case 59 -> TOWER_POINT;
            case 60 -> CHOOSE_BORN_BUSINESSID;
            case 61 -> TREND_TASK_AWARD;
            case 62 -> PORT_FORCE_DAILY_REWARD;
            case 63 -> ALLIANCE_GIFT;
            case 64 -> ALLIANCE_TREASURE;
            case 65 -> QUICK_SUPPLY;
            case 66 -> SEARCH_ROOM_REWARD;
            case 67 -> VIP_SHOP;
            case 68 -> SEARCH_ROOM_SHIP_LV_UP;
            case 69 -> GUIDE;
            case 70 -> USE_ITEM_RESOURCE;
            case 71 -> RANK_REWARD_MAIL;
            case 72 -> RANK_REWARD_GET;
            case 73 -> DESTROY_STORAGE_ITEM;
            case 74 -> FIRST_DISCOVERY_REWARD;
            case 75 -> FOOD_PERIOD_CONSUME;
            case 76 -> WATER_PERIOD_CONSUME;
            case 77 -> MILITARY_SHOP;
            case 78 -> ALLIANCE_DAILY_SHOP;
            case 79 -> ACTIVITY;
            case 80 -> HERO_AUTO_DISMISS;
            case 81 -> TROPHY_PICK;
            case 82 -> NEWBIE_BATTLE_REWARD;
            case 83 -> ACTIVITY_CARNIVAL_BENEFITS_REWARD;
            case 84 -> ACTIVITY_CARNIVAL_BUY_PRODUCT_CONSUME;
            case 85 -> ACTIVITY_CARNIVAL_BUY_PRODUCT_REWARD;
            case 86 -> ACTIVITY_CARNIVAL_ACTIVE_REWARD;
            case 87 -> ACTIVITY_CARNIVAL_REWARD_MAIL;
            case 88 -> CLIMB_RANK_ACTIVITY_TASK_REWARD_MAIL;
            case 89 -> ACTIVITY_ONLINE_TIME_REWARD;
            case 90 -> ACTIVITY_ONLINE_TIME_REWARD_MAIL;
            case 91 -> COIN_DISBAND_SHOP;
            case 92 -> CDKEY_REWARD;
            case 93 -> BATTLE_PASS;
            case 94 -> GROWTH_FUND;
            case 95 -> STRIKE_PIRATE_MAIN_BONUS;
            case 96 -> NORMAL_GACHA;
            case 97 -> CAMP_GACHA_1;
            case 98 -> CAMP_GACHA_2;
            case 99 -> CAMP_GACHA_3;
            case 100 -> CAMP_GACHA_4;
            case 101 -> ASTROLOGY_GACHA;
            case 102 -> MAZE_REWARD;
            case 103 -> MAZE_RESURRECT_COST;
            case 104 -> STRIKE_PIRATE_QUICK_HANG_UP_CONSUME;
            case 105 -> STRIKE_PIRATE_QUICK_HANG_UP_REWARD;
            case 106 -> OCTOPUS_TREASURE_CHEST;
            case 107 -> ACCELERATE_ITEM_BUY;
            case 108 -> ENTRUST_COST;
            case 109 -> ALLIANCE_BOSS;
            case 110 -> TRANSPORT_REWARD;
            case 111 -> ROBBERY_REWARD;
            case 1001 -> GM_REWARD;
            default -> {
                LogUtils.logger.error("BusinessType is not find value:{}",value);
                yield null;
            }
        };
    }
}
