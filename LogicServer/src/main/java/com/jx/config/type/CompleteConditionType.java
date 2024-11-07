package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成CompleteConditionType
 */
public enum CompleteConditionType {

    /**
     * 检查历史记录，新接任务判断是否能直接完成
     */
    NULL(0),

    /**
     * 捡垃圾获得物品（arg1：rewardType arg2:ID  arg3：数量）
     */
    DRIFTING(1),

    /**
     * 建造木筏填满（arg1：长，arg2：宽）
     */
    BUILD_RAFT(2),

    /**
     * 木筏建造某个建筑（arg1:buildingConfigID)
     */
    RAFT_BUILD_BUILDING(3),

    /**
     * 钓鱼几次 （arg1：num)
     */
    FISHING(4),

    /**
     * 资源获得（arg1：resourceType，arg2：数量)
     */
    RESOURCE_GET(5),

    /**
     * 获得物品（arg1：物品ID，arg2：数量)
     */
    ITEM_GET(6),

    /**
     * 客户端直接完成的任务（arg1:唯一识别码）
     */
    CLIENT_COMPLETE(7),

    /**
     * 完成某个章节任务章节 (arg1：章节ID)
     */
    CHAPTER_TASK_COMPLETE(8),

    /**
     * 升级英雄次数 (arg1：次数)
     */
    HERO_LEVEL_UP_COUNT(9),

    /**
     * 使用道具（arg1：物品ID，arg2：数量)
     */
    ITEM_USE(10),

    /**
     * 使用某个类型道具（arg1：item的type列说明，arg2：数量)
     */
    ITEM_TYPE_USE(11),

    /**
     * 完成N次指定ID关卡战斗并结算（arg1：关卡ID，arg2：胜负要求，arg3：次数）
     */
    BATTLE_COMPLETE(12),

    /**
     * 完成主线关卡的指定章节(arg1：章节ID）
     */
    CHAPTER_BATTLE_COMPLETE(13),

    /**
     * 成功拾取几次垃圾（arg1：num）
     */
    RAFT_RUBBISH(14),

    /**
     * 航行多少里（arg1：num）
     */
    RAFT_SAILING(15),

    /**
     * 饥饿度回复到多少（arg1：num）
     */
    RAFT_HUNGER(16),

    /**
     * 捡某种特定类型的垃圾（arg1：DrifterID   arg2:数量）
     */
    RAFT_DRIFTING(17),

    /**
     * 修复建造（arg1:buildingConfigID   arg2：次数 )
     */
    RAFT_REPAIR(18),

    /**
     * 累计采集X类型资源Y（arg1 资源类型 arg2：资源数量 ）
     */
    GATHER_SPECIFIED_RESOURCE(19),

    /**
     * 累计采集X任意资源（arg1：资源数量)
     */
    GATHER_ANY_RESOURCE(20),

    /**
     * 队伍X进行采集Y次（arg1：队伍标号 arg2:采集次数)
     */
    TROOPS_GATHER_TIMES(21),

    /**
     * 任意部队采集X次数（arg1：采集次数)
     */
    ANY_TROOPS_GATHER_TIMES(22),

    /**
     * 成功守城X次(arg1:次数)
     */
    DEFENSE_CITY_TIMES(23),

    /**
     * 成功攻城X次(arg1:次数)
     */
    ATTACK_CITY_TIMES(24),

    /**
     * 驻守攻城X次(arg1:次数)
     */
    GARRISON_NEUTRALITY_CITY_TIMES(25),

    /**
     * 参与进攻X次中立城(arg1:次数)
     */
    ATTACK_NEUTRALITY_CITY_TIMES(26),

    /**
     * 修复X次中立城(arg1:次数) 目前是自动恢复没有玩家行为  暂时不做
     */
    REPIRE_NEUTRALITY_CITY(27),

    /**
     * 累计掠夺X类型资源Y（arg1 资源类型 arg2：资源数量 ）
     */
    PLUNDER_SPECIFIED_RESOURCE(28),

    /**
     * 累计掠夺X任意资源（arg1：资源数量)
     */
    PLUNDER_ANY_RESOURCE(29),

    /**
     * 累计侦查X次(arg1:次数)
     */
    INVESTIGATE_TIMES(30),

    /**
     * 累计攻击X次海盗(arg1:次数 arg2，胜负要求)
     */
    ATTACK_MONSTER_TIMES(31),

    /**
     * 累计击杀X次海盗(arg1:次数 arg2，胜负要求)
     */
    KILL_MONSTER_TIMES(32),

    /**
     * 累计攻击X级海盗Y次(arg1:等级，arg2：次数 arg2，胜负要求)
     */
    ATTACK_LEVEL_MONSTER_TIMES(33),

    /**
     * 累计击杀X级海盗Y次 （arg1 等级 arg2：次数 arg2，胜负要求 ）
     */
    KILL_LEVEL_MONSTER_TIMES(34),

    /**
     * 通过击杀海盗获得X道具Y个 （arg1 资源类型 arg2：资源数量 ）
     */
    KILL_MONSTER_GET_ITEM(35),

    /**
     * 派出部队X次(arg1:次数)
     */
    TROOPS_GO_TIMES(36),

    /**
     * 布置X只部队 (arg1:个数 上将 上小兵保存就算)
     */
    CONFIGURE_TROOPS(37),

    /**
     * 选择一级城市建立标记 (arg1:次数 联盟标记) 暂时不做
     */
    SIGN_ON_CITY(38),

    /**
     * 迁移至联盟主城附近 (arg1:次数) 暂时不做
     */
    MOVE_TO_MAIN_CITY(39),

    /**
     * 发动一次群体迁城的城市技能 (arg1:次数) 暂时不做
     */
    USE_MOVE_SKILL(40),

    /**
     * 联盟占领X级城市Y座( arg1：等级 arg2:个数) 暂时不做
     */
    CAPTURE_LEVEL_CITY(41),

    /**
     * 掠夺或采集X资源Y （arg1 资源类型 arg2：资源数量 ）
     */
    PLUNDER_GATHER_SPECIFIED_RESOURCE(42),

    /**
     * 驻港X个港口(arg1:scene，arg2:次数,)
     */
    ACTIVATION_CITYS(43),

    /**
     * 解锁X块迷雾(arg1:块数)
     */
    UNLOCK_FOGS(44),

    /**
     * 完成X次事件(arg1:次数) 瞭望塔
     */
    ACCOMPLISH_EVENT_TIMES(45),

    /**
     * 拜访港口（arg1：scee，arg2：portID）
     */
    VISIT_PORT(46),

    /**
     * 成功通关相应打击海盗层数（arg1：Stage_BattleID）
     */
    FIGHT_PIRATES(47),

    /**
     * 英雄升级X次（arg1：heroID，arg2：num）
     */
    HERO_ID_LEVEL_UP_NUM(48),

    /**
     * 英雄升到X级（arg1：heroID，arg2：level）
     */
    HERO_ID_LEVEL_UP(49),

    /**
     * 给英雄穿戴装备（arg1:heroID)
     */
    WEAR_EQUIPMENT(50),

    /**
     * 前往港口出售货物（arg1:portID，arg2：tradeGoodsID，arg3:num）
     */
    SALE_GOODS(51),

    /**
     * 前往港口购买货物（arg1:portID，arg2：tradeGoodsID，arg3:num）
     */
    BUY_GOODS(52),

    /**
     * 派遣英雄在某房间工作（arg1:ship_groupID,arg2:heroID)
     */
    DISPATCH_WORK(53),

    /**
     * 将船舱升至X级（arg1:Ship_BuildingGroupID，arg2：level)
     */
    CABIN_UPGRADE(54),

    /**
     * 建造指定类型的船舱（arg1:Ship_BuildingGroupID)
     */
    BUILD_CABIN(55),

    /**
     * 学习特定科技（arg1:TechInfoID)
     */
    LEARNING_TECHNOLOGY(56),

    /**
     * 购买X级船（arg1:ShipID)
     */
    BUY_SHIP(57),

    /**
     * 击败X级Y个士兵（arg1：等级 arg2 个数  PVP玩家士兵）
     */
    KILL_ENEMY_SOLDIERS(58),

    /**
     * 参与集结X次（arg1：次数）
     */
    MASS_NUM(59),

    /**
     * 参与集结击杀X等级野怪Y次（arg1：等级 arg2 个数）
     */
    MASS_KILL_NUM(60),

    /**
     * 每日登录次数（arg1：num）
     */
    LOGINS_NUMBER(61),

    /**
     * 联盟捐献次数（arg1：num）
     */
    ALLIANCE_DONATION(62),

    /**
     * 联盟互助次数（arg1：num）
     */
    ALLIANCE_HELP(63),

    /**
     * 打击海盗领取奖励次数（arg1：num）
     */
    PIRATES_REWARDS_NUM(64),

    /**
     * 挑战竞技场次数（arg1：胜负要求，arg2：num）
     */
    CHALLENGE_ARENA_NUM(65),

    /**
     * 训练X级士兵Y个（arg1：type，arg2：等级, arg3：num）
     */
    TRAIN_NAVY_NUM(66),

    /**
     * 装备强化x次（arg1：num）
     */
    EQUIPMENT_ENHANCEMENT_NUM(67),

    /**
     * 招募英雄X次（arg1：type, arg2：num）
     */
    RECRUIT_HERO_NUM(68),

    /**
     * 商店购买商品（arg1：shipid,arg2：Shop_Prodid,arg3:num）
     */
    BUY_PROD_NUM(69),

    /**
     * 累计加速时长（arg1：type, arg2：秒）
     */
    CUMULATIVE_ACCELERATION_TIME(70),

    /**
     * 领取月卡奖励（arg1：num）
     */
    GET_MONTHLY_CARD_REWARDS(71),

    /**
     * 世界贸易购买X次（arg1：num）
     */
    WORLD_TRADE_BUY(72),

    /**
     * Y个英雄升到X级（arg1：level，arg2：num）
     */
    HERO_LEVEL_UP_NUM(73),

    /**
     * Y个英雄升到X品质（arg1：品质，arg2：num）
     */
    HERO_QUALITY_NUM(74),

    /**
     * 分解Y个X品质的英雄（arg1：品质，arg2：num）
     */
    HERO_LAYOFF_COUNT(75),

    /**
     * 英雄装备Y件X品质的装备（arg1：品质，arg2：num）
     */
    HERO_EQUIP_QUALITY_COUNT(76),

    /**
     * 队伍X战斗力达到Y（arg1：队伍编号，arg2：num）
     */
    TEAM_POWER(77),

    /**
     * 创建或加入联盟（arg1：num）
     */
    JOIN_ALLIANCE(78),

    /**
     * 将搜寻船升至X级（arg1:Search_Room_ListID，arg2：level)
     */
    SEARCHROOM_UPGRADE(79),

    /**
     * 科技树X研究进度达到Y%（arg1：Tech_TreeID，arg2：万分比）
     */
    TECHTREE_PROGRESS(80),

    /**
     * 拥有X级及以上的士兵Y个（arg1：等级，arg2：num）
     */
    HAVE_NAVY_NUM(81),

    /**
     * 世界PVP次数（arg1：胜负要求，arg2：num）
     */
    WORLD_PVP_NUM(82),

    /**
     * 烹饪次数（arg1：食物id【-1表示全部】，arg2：num）
     */
    COOKING_NUM(83),

    /**
     * 角色状态改变至对应阶段（arg1:heroid，arg2：状态编号）【木筏任务专用】
     */
    CHARACTER_STATUS(84),

    /**
     * 航海里程数（arg1：num）
     */
    NAUTICAL_MILES(85),

    /**
     * 通过贸易赚取利润（arg1：profit）
     */
    TRADE_PROFIT(86),

    /**
     * 木筏建筑状态改变至对应阶段（arg1:配置id，关联RaftConstruct表的id，
arg2：状态）【木筏任务专用】
     */
    RAFT_CONSTRUCT_STATUS(87),

    /**
     * 拾取X次宝箱（arg1:num，拾取次数）
     */
    PICKUP_BOX(88),

    /**
     * 个人活动开启天数(arg1：活动id  arg2：天数)
     */
    PERSONAL_ACTIVITY_OPEN_DAYS(89),

    /**
     * 新手战斗任务（arg1：Stage_BattleID）
     */
    NEWBIE_BATTLE(90),

    /**
     * 完成交互点（arg1：Newbies_Points_LocationID）
     */
    NEWBIES_POINTS_COMPLETION(91),

    /**
     * 玩家总战力达到X（arg1：玩家总战力值）
     */
    TOTAL_FIGHT_POWER(92),

    /**
     * 宝箱金币激活进度（arg1：num）1,2,3三个进度
     */
    GOLD_PROGRESS(93),

    /**
     * 玩家获得装备（arg1：装备id,arg2:num）Equip_Detail表
     */
    GET_EQUIPMENT(94),

    /**
     * 玩家累计充值钻石（arg1：钻石数量，和purchase表的 baseGem字段关联）
     */
    RECHARGE_GEM(95),

    /**
     * 采集/搜寻（眺望台任务）X类型资源Y（arg1  类型  arg2 资源数量）
     */
    FIND_GATHER_SPECIFIED_RESOURCE(96),

    /**
     * 治疗/训练X级士兵Y个（arg1：type，arg2：等级, arg3：num）
     */
    TREAD_TRAIN_NAVY_NUM(97),

    /**
     * 领取某活动X档奖励Y次（arg1：活动类型 arg2 档位 arg3 次数 ）
     */
    GET_ACTIVITY_REWARD(98),

    /**
     * 拥有、获得指定英雄（arg1：heroid）
     */
    GET_SPECIFIED_HERO(99),

    /**
     * 推图副本战斗连续失败次数（arg1:连续失败次数）
     */
    CHAPTER_BATTLE_FAIL_TIMES(100),

    /**
     * 通过某个卡池招募到某个英雄（arg1:卡池id arg2:英雄id(-1=任何英雄) arg3:英雄品质）
     */
    GACHA_GET_HERO(101),

    /**
     * 驱逐鲨鱼X次（arg1：num）
     */
    EXPEL_SHARKS_NUM(102),

    /**
     * X部队上阵Y个英雄 (arg1:部队ID arg2:英雄数量)
     */
    TROOP_HERO(103),

    /**
     * 修改名称成功
     */
    CHANGE_NAME(104),

    /**
     * 冒险等级达到X级（arg1：冒险等级）
     */
    ADVENTURE_LEVEL(105),

    /**
     * 当前编队士兵数量（arg1：编队类型TeamType， arg2：编队索引1、2、3， arg3：士兵数量）
     */
    TEAM_SOLDIER_NUMBER(106),

    /**
     * 当前资源拥有数量（arg1：资源类型，arg2：资源数量）
     */
    RESOURCE_HAVE_NUMBER(107),

    /**
     * 拥有X货物Y个(arg1:goodsId arg2:num)
     */
    HAVE_GOODSID_NUM(108),

    /**
     * 客户端主动完成交互点（arg1：Newbies_Points_Location）
     */
    COMPLETE_NEWBIE_POINT(1000),

    ;
    private int value;

    public static CompleteConditionType[] ARRAY = {
            NULL,
            DRIFTING,
            BUILD_RAFT,
            RAFT_BUILD_BUILDING,
            FISHING,
            RESOURCE_GET,
            ITEM_GET,
            CLIENT_COMPLETE,
            CHAPTER_TASK_COMPLETE,
            HERO_LEVEL_UP_COUNT,
            ITEM_USE,
            ITEM_TYPE_USE,
            BATTLE_COMPLETE,
            CHAPTER_BATTLE_COMPLETE,
            RAFT_RUBBISH,
            RAFT_SAILING,
            RAFT_HUNGER,
            RAFT_DRIFTING,
            RAFT_REPAIR,
            GATHER_SPECIFIED_RESOURCE,
            GATHER_ANY_RESOURCE,
            TROOPS_GATHER_TIMES,
            ANY_TROOPS_GATHER_TIMES,
            DEFENSE_CITY_TIMES,
            ATTACK_CITY_TIMES,
            GARRISON_NEUTRALITY_CITY_TIMES,
            ATTACK_NEUTRALITY_CITY_TIMES,
            REPIRE_NEUTRALITY_CITY,
            PLUNDER_SPECIFIED_RESOURCE,
            PLUNDER_ANY_RESOURCE,
            INVESTIGATE_TIMES,
            ATTACK_MONSTER_TIMES,
            KILL_MONSTER_TIMES,
            ATTACK_LEVEL_MONSTER_TIMES,
            KILL_LEVEL_MONSTER_TIMES,
            KILL_MONSTER_GET_ITEM,
            TROOPS_GO_TIMES,
            CONFIGURE_TROOPS,
            SIGN_ON_CITY,
            MOVE_TO_MAIN_CITY,
            USE_MOVE_SKILL,
            CAPTURE_LEVEL_CITY,
            PLUNDER_GATHER_SPECIFIED_RESOURCE,
            ACTIVATION_CITYS,
            UNLOCK_FOGS,
            ACCOMPLISH_EVENT_TIMES,
            VISIT_PORT,
            FIGHT_PIRATES,
            HERO_ID_LEVEL_UP_NUM,
            HERO_ID_LEVEL_UP,
            WEAR_EQUIPMENT,
            SALE_GOODS,
            BUY_GOODS,
            DISPATCH_WORK,
            CABIN_UPGRADE,
            BUILD_CABIN,
            LEARNING_TECHNOLOGY,
            BUY_SHIP,
            KILL_ENEMY_SOLDIERS,
            MASS_NUM,
            MASS_KILL_NUM,
            LOGINS_NUMBER,
            ALLIANCE_DONATION,
            ALLIANCE_HELP,
            PIRATES_REWARDS_NUM,
            CHALLENGE_ARENA_NUM,
            TRAIN_NAVY_NUM,
            EQUIPMENT_ENHANCEMENT_NUM,
            RECRUIT_HERO_NUM,
            BUY_PROD_NUM,
            CUMULATIVE_ACCELERATION_TIME,
            GET_MONTHLY_CARD_REWARDS,
            WORLD_TRADE_BUY,
            HERO_LEVEL_UP_NUM,
            HERO_QUALITY_NUM,
            HERO_LAYOFF_COUNT,
            HERO_EQUIP_QUALITY_COUNT,
            TEAM_POWER,
            JOIN_ALLIANCE,
            SEARCHROOM_UPGRADE,
            TECHTREE_PROGRESS,
            HAVE_NAVY_NUM,
            WORLD_PVP_NUM,
            COOKING_NUM,
            CHARACTER_STATUS,
            NAUTICAL_MILES,
            TRADE_PROFIT,
            RAFT_CONSTRUCT_STATUS,
            PICKUP_BOX,
            PERSONAL_ACTIVITY_OPEN_DAYS,
            NEWBIE_BATTLE,
            NEWBIES_POINTS_COMPLETION,
            TOTAL_FIGHT_POWER,
            GOLD_PROGRESS,
            GET_EQUIPMENT,
            RECHARGE_GEM,
            FIND_GATHER_SPECIFIED_RESOURCE,
            TREAD_TRAIN_NAVY_NUM,
            GET_ACTIVITY_REWARD,
            GET_SPECIFIED_HERO,
            CHAPTER_BATTLE_FAIL_TIMES,
            GACHA_GET_HERO,
            EXPEL_SHARKS_NUM,
            TROOP_HERO,
            CHANGE_NAME,
            ADVENTURE_LEVEL,
            TEAM_SOLDIER_NUMBER,
            RESOURCE_HAVE_NUMBER,
            HAVE_GOODSID_NUM,
            COMPLETE_NEWBIE_POINT
    };

    CompleteConditionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CompleteConditionType getType(int value) {
        return switch (value) {
            case 0 -> NULL;
            case 1 -> DRIFTING;
            case 2 -> BUILD_RAFT;
            case 3 -> RAFT_BUILD_BUILDING;
            case 4 -> FISHING;
            case 5 -> RESOURCE_GET;
            case 6 -> ITEM_GET;
            case 7 -> CLIENT_COMPLETE;
            case 8 -> CHAPTER_TASK_COMPLETE;
            case 9 -> HERO_LEVEL_UP_COUNT;
            case 10 -> ITEM_USE;
            case 11 -> ITEM_TYPE_USE;
            case 12 -> BATTLE_COMPLETE;
            case 13 -> CHAPTER_BATTLE_COMPLETE;
            case 14 -> RAFT_RUBBISH;
            case 15 -> RAFT_SAILING;
            case 16 -> RAFT_HUNGER;
            case 17 -> RAFT_DRIFTING;
            case 18 -> RAFT_REPAIR;
            case 19 -> GATHER_SPECIFIED_RESOURCE;
            case 20 -> GATHER_ANY_RESOURCE;
            case 21 -> TROOPS_GATHER_TIMES;
            case 22 -> ANY_TROOPS_GATHER_TIMES;
            case 23 -> DEFENSE_CITY_TIMES;
            case 24 -> ATTACK_CITY_TIMES;
            case 25 -> GARRISON_NEUTRALITY_CITY_TIMES;
            case 26 -> ATTACK_NEUTRALITY_CITY_TIMES;
            case 27 -> REPIRE_NEUTRALITY_CITY;
            case 28 -> PLUNDER_SPECIFIED_RESOURCE;
            case 29 -> PLUNDER_ANY_RESOURCE;
            case 30 -> INVESTIGATE_TIMES;
            case 31 -> ATTACK_MONSTER_TIMES;
            case 32 -> KILL_MONSTER_TIMES;
            case 33 -> ATTACK_LEVEL_MONSTER_TIMES;
            case 34 -> KILL_LEVEL_MONSTER_TIMES;
            case 35 -> KILL_MONSTER_GET_ITEM;
            case 36 -> TROOPS_GO_TIMES;
            case 37 -> CONFIGURE_TROOPS;
            case 38 -> SIGN_ON_CITY;
            case 39 -> MOVE_TO_MAIN_CITY;
            case 40 -> USE_MOVE_SKILL;
            case 41 -> CAPTURE_LEVEL_CITY;
            case 42 -> PLUNDER_GATHER_SPECIFIED_RESOURCE;
            case 43 -> ACTIVATION_CITYS;
            case 44 -> UNLOCK_FOGS;
            case 45 -> ACCOMPLISH_EVENT_TIMES;
            case 46 -> VISIT_PORT;
            case 47 -> FIGHT_PIRATES;
            case 48 -> HERO_ID_LEVEL_UP_NUM;
            case 49 -> HERO_ID_LEVEL_UP;
            case 50 -> WEAR_EQUIPMENT;
            case 51 -> SALE_GOODS;
            case 52 -> BUY_GOODS;
            case 53 -> DISPATCH_WORK;
            case 54 -> CABIN_UPGRADE;
            case 55 -> BUILD_CABIN;
            case 56 -> LEARNING_TECHNOLOGY;
            case 57 -> BUY_SHIP;
            case 58 -> KILL_ENEMY_SOLDIERS;
            case 59 -> MASS_NUM;
            case 60 -> MASS_KILL_NUM;
            case 61 -> LOGINS_NUMBER;
            case 62 -> ALLIANCE_DONATION;
            case 63 -> ALLIANCE_HELP;
            case 64 -> PIRATES_REWARDS_NUM;
            case 65 -> CHALLENGE_ARENA_NUM;
            case 66 -> TRAIN_NAVY_NUM;
            case 67 -> EQUIPMENT_ENHANCEMENT_NUM;
            case 68 -> RECRUIT_HERO_NUM;
            case 69 -> BUY_PROD_NUM;
            case 70 -> CUMULATIVE_ACCELERATION_TIME;
            case 71 -> GET_MONTHLY_CARD_REWARDS;
            case 72 -> WORLD_TRADE_BUY;
            case 73 -> HERO_LEVEL_UP_NUM;
            case 74 -> HERO_QUALITY_NUM;
            case 75 -> HERO_LAYOFF_COUNT;
            case 76 -> HERO_EQUIP_QUALITY_COUNT;
            case 77 -> TEAM_POWER;
            case 78 -> JOIN_ALLIANCE;
            case 79 -> SEARCHROOM_UPGRADE;
            case 80 -> TECHTREE_PROGRESS;
            case 81 -> HAVE_NAVY_NUM;
            case 82 -> WORLD_PVP_NUM;
            case 83 -> COOKING_NUM;
            case 84 -> CHARACTER_STATUS;
            case 85 -> NAUTICAL_MILES;
            case 86 -> TRADE_PROFIT;
            case 87 -> RAFT_CONSTRUCT_STATUS;
            case 88 -> PICKUP_BOX;
            case 89 -> PERSONAL_ACTIVITY_OPEN_DAYS;
            case 90 -> NEWBIE_BATTLE;
            case 91 -> NEWBIES_POINTS_COMPLETION;
            case 92 -> TOTAL_FIGHT_POWER;
            case 93 -> GOLD_PROGRESS;
            case 94 -> GET_EQUIPMENT;
            case 95 -> RECHARGE_GEM;
            case 96 -> FIND_GATHER_SPECIFIED_RESOURCE;
            case 97 -> TREAD_TRAIN_NAVY_NUM;
            case 98 -> GET_ACTIVITY_REWARD;
            case 99 -> GET_SPECIFIED_HERO;
            case 100 -> CHAPTER_BATTLE_FAIL_TIMES;
            case 101 -> GACHA_GET_HERO;
            case 102 -> EXPEL_SHARKS_NUM;
            case 103 -> TROOP_HERO;
            case 104 -> CHANGE_NAME;
            case 105 -> ADVENTURE_LEVEL;
            case 106 -> TEAM_SOLDIER_NUMBER;
            case 107 -> RESOURCE_HAVE_NUMBER;
            case 108 -> HAVE_GOODSID_NUM;
            case 1000 -> COMPLETE_NEWBIE_POINT;
            default -> {
                LogUtils.logger.error("CompleteConditionType is not find value:{}",value);
                yield null;
            }
        };
    }
}
