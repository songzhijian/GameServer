package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成EffectType
 */
public enum EffectType {

    /**
     * 客户端城建占位使用的作用号
     */
    BUIDLING_NO_USE(1000),

    /**
     * 【全局】建筑工作队列速度加速{0}%
     */
    BUILDING_SPEED_UP_RATIO(1001),

    /**
     * 【全局】【甲板下建筑】建筑工作队列速度加速{0}%
     */
    CABIN_BUILDING_SPEED_UP_RATIO(1002),

    /**
     * 【全局】建筑工作队列，直接减少{0}秒的时间
     */
    BUILDING_TIME_DOWN(1003),

    /**
     * 【全局】训练士兵加速{0}%
     */
    NAVY_SPEED_UP_RATIO(1004),

    /**
     * 【全局】训练士兵时物资消耗减少{0}%
     */
    NAVY_COST_DOWN_RATIO(1005),

    /**
     * 【全局】晋升士兵时加速{0}%
     */
    NAVY_UPGRADE_SPEED_UP_RATIO(1006),

    /**
     * 【全局】治疗伤兵的速度，加快{0}%
     */
    NAVY_HEAL_SPEED_UP_RATIO(1007),

    /**
     * 【全局】鸡蛋产生效率为{0}%
     */
    EGG_SPEED_UP_RATIO(1008),

    /**
     * 【全局】淡水产生效率为{0}%
     */
    WATER_SPEED_UP_RATIO(1009),

    /**
     * 【全局】制作食物时，消耗资源减少{0}%
     */
    FOOD_COST_DOWN_RATIO(1010),

    /**
     * 【全局】食物产出速度增加{0}%
     */
    FOOD_SPEED_UP_RATIO(1011),

    /**
     * 【全局】水兵训练队列上限+{0}
     */
    NAVY_TRAIN_COUNT_UP(1012),

    /**
     * 解锁医疗药品Lv{0}
     */
    MEDICINE_LEVEL_UNLOCK(1013),

    /**
     * 解锁烹饪食品Lv{0}
     */
    FOOD_LEVEL_UNLOCK(1014),

    /**
     * 水兵上限+{0}
     */
    NAVY_LIMIT_MAX(1015),

    /**
     * 交易品存储上限+{0}
     */
    TRADE_GOODS_LIMIT_UP(1016),

    /**
     * 伤兵上限+{0}
     */
    WOUNDED_SOLDIER_LIMIT_UP(1017),

    /**
     * 药品存储上限+{0}
     */
    MEDICINE_LIMIT_UP(1018),

    /**
     * 饮用水仓库存储上限+{0}
     */
    WATER_LIMIT_UP(1019),

    /**
     * 食品仓库存储上限+{0}
     */
    FOOD_LIMIT_UP(1020),

    /**
     * 鸡蛋产生上限为{0}秒
     */
    EGG_STORED_TIME_UP(1021),

    /**
     * 淡水产生上限为{0}秒
     */
    WATER_STORED_TIME_UP(1022),

    /**
     * 仓库-金币的存储上限【单独】
     */
    WAREHOUSE_GOLD_LIMIT(1023),

    /**
     * 仓库-木材/金属/布匹的存储上限【单独】
     */
    WAREHOUSE_RESOURCE_LIMIT(1024),

    /**
     * 仓库-金币的保护上限【单独】
     */
    WAREHOUSE_GOLD_PROTECT_LIMIT(1025),

    /**
     * 仓库-木材/金属/布匹的保护上限【单独】
     */
    WAREHOUSE_RESOURCE_PROTECT_LIMIT(1026),

    /**
     * 【全局】木材生产效率提升
     */
    COLLECT_WOOD_SPEED_UP_RATIO(1031),

    /**
     * 【全局】织物生产效率提升
     */
    COLLECT_CLOTH_SPEED_UP_RATIO(1032),

    /**
     * 【全局】金属生产效率提升
     */
    COLLECT_METAL_SPEED_UP_RATIO(1033),

    /**
     * 【全局】木材、织物、金属生产效率提升
     */
    COLLECT_WOOD_CLOTH_METAL_SPEED_UP_RATIO(1034),

    /**
     * 【全局】木材生产库存提升
     */
    COLLECT_WOOD_BANK_UP_RATIO(1035),

    /**
     * 【全局】织物生产库存提升
     */
    COLLECT_CLOTH_BANK_UP_RATIO(1036),

    /**
     * 【全局】金属生产库存提升
     */
    COLLECT_METAL_BANK_UP_RATIO(1037),

    /**
     * 【全局】木材、织物、金属生产库存提升
     */
    COLLECT_WOOD_CLOTH_METAL_BANK_UP_RATIO(1038),

    /**
     * 解锁自动烹饪
     */
    AUTO_COOK_UNLOCK(1039),

    /**
     * 【全局】草药产出速度增加{0}%
     */
    MEDICINE_MATERIAL_SPEED_UP_RATIO(1043),

    /**
     * 【全局】药品产出速度增加{0}%
     */
    MEDICINE_SPEED_UP_RATIO(1044),

    /**
     * 【全局】治疗士兵时物资消耗减少{0}%
     */
    CURE_NAVY_COST_DOWN_RATIO(1046),

    /**
     * 草药产生上限为{0}秒
     */
    MEDICINE_MATERIAL_TIME_LIMIT(1047),

    /**
     * 草药存储上限+{0}
     */
    MEDICINE_MATERIAL_LIMIT(1048),

    /**
     * 食材存储上限+{0}
     */
    FOOD_MATERIAL_LIMIT(1049),

    /**
     * 【单一队列】单人带兵上限+{0}
     */
    BOAT_QUEUE_NAVY_LIMIT_UP(1050),

    /**
     * 所有（木材、织物、金属）搜寻船的产量上限提升
     */
    ALL_SEARCH_SHIP_PRODUCTION_LIMIT_INCR(1051),

    /**
     * 木材搜寻船的产量上限提升
     */
    WOOD_SEARCH_SHIP_PRODUCTION_LIMIT_INCR(1052),

    /**
     * 织物搜寻船的产量上限提升
     */
    CLOTH_SEARCH_SHIP_PRODUCTION_LIMIT_INCR(1053),

    /**
     * 金属搜寻船的产量上限提升
     */
    METAL_SEARCH_SHIP_PRODUCTION_LIMIT_INCR(1054),

    /**
     * 当玩家，被联盟帮助时，增加可被帮助的次数
     */
    ALLIANCE_HELP_TIME_LIMIT_UP(1055),

    /**
     * 解锁食材Lv{0}
     */
    INGREDIENT_UNLOCK(1056),

    /**
     * 1101 = 研究速度加快{0}%
     */
    RESEARCH_SPEED_UP_RATIO(1101),

    /**
     * 1102 = 研究科技，减少消耗{0}%
     */
    RESEARCH_COST_DOWN_RATIO(1102),

    /**
     * 1103 = 科研时，直接减少{0}秒科研时间
     */
    RESEARCH_TIME_DOWN(1103),

    /**
     * 增加神器加速时间（分钟）
     */
    ARTIFACT_SPEED_TIME_UP(1104),

    /**
     * 增加神器加速次数上限
     */
    ARTIFACT_SPEED_COUNT_UP(1105),

    /**
     * 【单一队列】建筑工作队列速度加速{0}%
     */
    BUILDING_QUEUE_SPEED_UP_RATIO(1501),

    /**
     * 【单一队列】【甲板下建筑】建筑工作队列速度加速{0}%
     */
    CABIN_BUILDING_QUEUE_SPEED_UP_RATIO(1502),

    /**
     * 【单一队列】建筑工作队列，直接减少{0}秒的时间
     */
    BUILDING_QUEUE_TIME_DOWN(1503),

    /**
     * 【单一队列】训练士兵加速{0}%
     */
    NAVY_QUEUE_SPEED_UP_RATIO(1504),

    /**
     * 【单一队列】训练士兵时物资消耗减少{0}%
     */
    NAVY_QUEUE_COST_DOWN_RATIO(1505),

    /**
     * 【单一队列】晋升士兵时加速{0}%
     */
    NAVY_UPGRADE_QUEUE_SPEED_UP_RATIO(1506),

    /**
     * 【单一队列】解锁水兵等级Lv{0}
     */
    NAVY_QUEUE_LEVEL_UNLOCK(1507),

    /**
     * 【单一队列】水兵训练队列上限+{0}
     */
    NAVY_QUEUE_TRAIN_COUNT_UP(1508),

    /**
     * 2001 = 【工作在那个房间就加那个房间】建筑工作队列速度加速{0}%
     */
    BUILDING_HERO_SPEED_UP_RATIO(2001),

    /**
     * 2002 = 【工作在那个房间就加那个房间】【甲板下建筑】建筑工作队列速度加速{0}%
     */
    CABIN_BUILDING_HERO_SPEED_UP_RATIO(2002),

    /**
     * 2003 = 【工作在那个房间就加那个房间】建筑工作队列，直接减少{0}秒的时间
     */
    BUILDING_HERO_TIME_DOWN(2003),

    /**
     * 2004 = 【工作在那个房间就加那个房间】训练士兵加速{0}%
     */
    NAVY_HERO_SPEED_UP_RATIO(2004),

    /**
     * 2005 = 【工作在那个房间就加那个房间】训练士兵时物资消耗减少{0}%
     */
    NAVY_HERO_COST_DOWN_RATIO(2005),

    /**
     * 2006 = 【工作在那个房间就加那个房间】晋升士兵时加速{0}%
     */
    NAVY_HERO_UPGRADE_SPEED_UP_RATIO(2006),

    /**
     * 2007 = 【工作在那个房间就加那个房间】水兵训练队列上限+{0}
     */
    NAVY_HERO_TRAIN_COUNT_UP(2007),

    /**
     * 挂机收益时间上限增加
     */
    IDLE_GAIN_TIME_MAX_INCR(3001),

    /**
     * 挂机收益增加
     */
    IDLE_GAIN_OUTPUT_INCR(3002),

    /**
     * 快速挂机次数
     */
    IDLE_GAIN_QUICK_SUPPLY_TIMES(3003),

    /**
     * 4001 = 贸易卖价提高+{0}%
     */
    SELL_PRICE_UP(4001),

    /**
     * 4002 = 在本联盟麾下的港口售卖交易品售价额外增加{0}%
     */
    ALLIANCE_PORT_SELL_PRICE_UP(4002),

    /**
     * 4003 = 买卖时，获得文化圈威望增长{0}%
     */
    SELL_PRESTIGE_UP(4003),

    /**
     * 4004 = 被抢夺时的损失降低{0}%
     */
    ROB_LOSS_DOWN(4004),

    /**
     * 4005 = 出售税率相加因子(arg1:税率) 万分比整数
     */
    SELL_TAX(4005),

    /**
     * 4006 = 购买税率相加因子(arg1:税率) 万分比整数
     */
    BUY_TAX(4006),

    /**
     * 4007 = 贸易额度上限（arg1：数量）
     */
    TRADE_LINE_MAX(4007),

    /**
     * 4008 = 贸易品被抢夺时，可保留一部分贸易品
     */
    TRADE_PROTECT_AMOUNT(4008),

    /**
     * 4009 = 可以使用会计室的行情功能，港口范围{0}
     */
    MARKET_EFF(4009),

    /**
     * 4012 = 抢夺贸易品比例额外增加{0}%
     */
    ROB_RESULT_UP(4012),

    /**
     * 6001 = 航行速度增加{0}%
     */
    MOTHERSHIP_SPEED_UP_RATIO(6001),

    /**
     * 6004 = 贸易中，航速调整{0}%
     */
    MOTHERSHIP_TRADE_SPEED_DOWN_RATIO(6004),

    /**
     * 6006 = 【全局】小船的航速增加{0}%
     */
    BOAT_SPEED_UP_RATIO(6006),

    /**
     * 6007 = 【单一队列】小船的航速增加{0}%
     */
    BOAT_QUEUE_SPEED_UP_RATIO(6007),

    /**
     * 6008 = 侦察部队，速度增加{0}%
     */
    SCOUT_SPEED_UP_RATIO(6008),

    /**
     * 6009 = 大船移动速度增加{0}% - 敌方领地
     */
    MONTHERSHIP_ENEMY_TERRITORY_SPEED_UP_RATIO(6009),

    /**
     * 【全局】小船移动速度 - 返回
     */
    BOAT_BACK_SPEED_UP_RATIO(6010),

    /**
     * 【全局】小船移动速度 - 前往集结
     */
    BOAT_JOIN_ASSEMBLE_SPEED_UP_RATIO(6011),

    /**
     * 【全局】小船移动速度 - 援助港口
     */
    BOAT_ASSIST_ALLIANCE_PORT_SPEED_UP_RATIO(6012),

    /**
     * 【全局】小船移动速度 - 援助盟友
     */
    BOAT_ASSIST_ALLY_SPEED_UP_RATIO(6013),

    /**
     * 【单一队列】小船移动速度 - 返回
     */
    BOAT_QUEUE_BACK_SPEED_UP_RATIO(6014),

    /**
     * 【单一队列】小船移动速度 - 前往集结
     */
    BOAT_QUEUE_JOIN_ASSEMBLE_SPEED_UP_RATIO(6015),

    /**
     * 【单一队列】小船移动速度 - 援助港口
     */
    BOAT_QUEUE_ASSIST_ALLIANCE_PORT_SPEED_UP_RATIO(6016),

    /**
     * 【单一队列】小船移动速度 - 援助盟友
     */
    BOAT_QUEUE_ASSIST_ALLY_SPEED_UP_RATIO(6017),

    /**
     * 母船耐久增加{0}点
     */
    MOTHERSHIP_HP_UP(6018),

    /**
     * 【全局】部队负重增加{0}
     */
    BOAT_LOAD_UP(6021),

    /**
     * 【单一队列】部队负重增加{0}
     */
    BOAT_QUEUE_LOAD_UP(6022),

    /**
     * 【全局】木材采集负重提升
     */
    GATHER_WOOD_LOAD_UP_RATIO(6023),

    /**
     * 【全局】织物采集负重提升
     */
    GATHER_CLOTH_LOAD_UP_RATIO(6024),

    /**
     * 【全局】金属采集负重提升
     */
    GATHER_METAL_LOAD_UP_RATIO(6025),

    /**
     * 【全局】金币采集负重提升
     */
    GATHER_GOLD_LOAD_UP_RATIO(6026),

    /**
     * 【全局】提升部队采集速度 - 全局
     */
    GATHER_SPEED_UP_RATIO(6027),

    /**
     * 【全局】提升部队采集速度 - 木材
     */
    GATHER_WOOD_SPEED_UP_RATIO(6028),

    /**
     * 【全局】提升部队采集速度 - 织物
     */
    GATHER_CLOTH_SPEED_UP_RATIO(6029),

    /**
     * 【全局】提升部队采集速度 - 金属
     */
    GATHER_METAL_SPEED_UP_RATIO(6030),

    /**
     * 【全局】提升部队采集速度 - 金币
     */
    GATHER_GOLD_SPEED_UP_RATIO(6031),

    /**
     * 【单一队列】提升部队采集速度 - 全局
     */
    GATHER_QUEUE_SPEED_UP_RATIO(6032),

    /**
     * 【单一队列】提升部队采集速度 - 木材
     */
    GATHER_QUEUE_WOOD_SPEED_UP_RATIO(6033),

    /**
     * 【单一队列】提升部队采集速度 - 织物
     */
    GATHER_QUEUE_CLOTH_SPEED_UP_RATIO(6034),

    /**
     * 【单一队列】提升部队采集速度 - 金属
     */
    GATHER_QUEUE_METAL_SPEED_UP_RATIO(6035),

    /**
     * 【单一队列】提升部队采集速度 - 金币
     */
    GATHER_QUEUE_GOLD_SPEED_UP_RATIO(6036),

    /**
     * 解锁木材采集
     */
    WOOD_GATHER_UNLOCK(6037),

    /**
     * 解锁织物采集
     */
    CLOTH_GATHER_UNLOCK(6038),

    /**
     * 解锁金属采集
     */
    METAL_GATHER_UNLOCK(6039),

    /**
     * 解锁金币采集
     */
    GOLD_GATHER_UNLOCK(6040),

    /**
     * 【全局】部队负重增加{0} - 抢劫
     */
    BOAT_LOAD_UP_RATIO(6041),

    /**
     * 【单一队列】部队负重增加{0} - 抢劫
     */
    BOAT_QUEUE_LOAD_UP_RATIO(6042),

    /**
     * 提升战争号角数量上限
     */
    WAR_HORN_LIMIT_UP(6051),

    /**
     * 提高发起集结时部队数量上限
     */
    ASSEMBLE_MEMBER_LIMIT_UP(6052),

    /**
     * 可以向1个集结队列派出2只编队
     */
    JOIN_ASSEMBLE_BOAT_LIMIT_UP(6053),

    /**
     * 旗舰可接受援助部队上限提升
     */
    MOTHERSHIP_ASSIST_ACCEPT_LIMIT_UP(6054),

    /**
     * 禁止迁城，禁止开罩
     */
    BAN_TELEPORT(6055),

    /**
     * 防护罩，战争守护
     */
    INVINCIBLE(6056),

    /**
     * 反侦察
     */
    ANTI_SCOUT(6057),

    /**
     * 在守城战中，被破坏的耐久减少{0}点
     */
    MOTHERSHIPWAR_BEDESTROYED_DOWN(6061),

    /**
     * 【全局】在攻击港口战中，造成的破坏增加{0}%
     */
    PORTWAR_DESTROY_UP_RATIO(6062),

    /**
     * 【全局】在攻击港口战中，破坏值额外加{0}
     */
    PORTWAR_DESTROY_UP(6063),

    /**
     * 【全局】部队破坏值提升 - 攻击玩家母船
     */
    BOAT_ATTACK_MOTHERSHIP_DESTRUCTION_UP_RATIO(6064),

    /**
     * 【全局】部队破坏值提升 - 集结编队中
     */
    BOAT_ASSEMBLE_DESTRUCTION_UP_RATIO(6065),

    /**
     * 【全局】部队破坏值提升 - 全局
     */
    BOAT_DESTRUCTION_UP(6066),

    /**
     * 【单一队列】在攻击港口战中，造成的破坏增加{0}%
     */
    PORTWAR_QUEUE_DESTROY_UP_RATIO(6067),

    /**
     * 【单一队列】在攻击港口战中，破坏值额外加{0}
     */
    PORTWAR_QUEUE_DESTROY_UP(6068),

    /**
     * 【单一队列】部队破坏值提升 - 攻击玩家母船
     */
    BOAT_QUEUE_ATTACK_MOTHERSHIP_DESTRUCTION_UP_RATIO(6069),

    /**
     * 【单一队列】部队破坏值提升 - 集结编队中
     */
    BOAT_QUEUE_ASSEMBLE_DESTRUCTION_UP_RATIO(6070),

    /**
     * 【单一队列】部队破坏值提升 - 全局
     */
    BOAT_QUEUE_DESTRUCTION_UP(6071),

    /**
     * 【单一队列】指定队列解锁【召回】功能
     */
    BOAT_QUEUE_CALL_BACK_UNLOCK(6072),

    /**
     * 【单一队列】出征队列解锁第{0}个英雄
     */
    BOAT_QUEUE_HERO_LIMIT(6073),

    /**
     * 6082 = 瞭望塔获得的方晶奖励额外增加{0}%
     */
    TOWER_EXTRA_BONUS_UP_RATIO(6082),

    /**
     * 瞭望塔每次刷新可额外按照对应规则ID增加情报点
     */
    TOWER_MORE_INTEREST_POINT(6083),

    /**
     * 【全局】部队击败普通海盗时，概率获得战利品箱子
     */
    EXTRA_REWARD_DEFEAT_NORMAL_MONSTER_RATIO(6090),

    /**
     * 受重伤的水兵，有{0}%会直接转为轻伤
     */
    NAVY_BADLYHURT_DOWN_RATIO(6101),

    /**
     * 在<打击海盗>中，重伤的士兵有{0}%都会变为轻伤
     */
    STRIKEPIRATE_BADLYHURT_DOWN_RATIO(6102),

    /**
     * 采集时被击败，可保留一部分资源
     */
    WHEN_GATHER_ROBBED_KEEP_RATIO(6103),

    /**
     * 死伤转换：玩家驻守的港口被攻击，攻击方重伤转死亡 - 港口被攻击
     */
    ENEMY_ATTACK_PORT_HURT_TO_DEATH_RATIO(6104),

    /**
     * 死伤转换：母舰被攻击，攻击方重伤转死亡 - 自己旗舰被攻击
     */
    ENEMY_ATTACK_MOTHERSHIP_HURT_TO_DEATH_RATIO(6105),

    /**
     * 死伤转换：玩家驻守港口被攻击，防守方死亡转重伤 - 驻守港口
     */
    DEFENCE_PORT_DEATH_TO_HURT_RATIO(6106),

    /**
     * 死伤转换：玩家攻击他人母舰，攻击方死亡转重伤 - 攻击他人旗舰
     */
    ATTACK_MOTHERSHIP_DEATH_TO_HURT_RATIO(6107),

    /**
     * 作为集结队长，在<集结>中，重伤的士兵有{0}%都会变为轻伤
     */
    ASSEMBLE_BADLYHURT_DOWN_RATIO(6109),

    /**
     * 在守城战中，对敌伤害增加{0}%
     */
    MOTHERSHIPWAR_DAMAGE_UP_RATIO(7001),

    /**
     * 在守城战中，己方受到的伤害减少{0}%
     */
    MOTHERSHIPWAR_HURT_DOWN_RATIO(7002),

    /**
     * 【全局】部队物理攻击力提升 - 全局
     */
    ATK_UP_RATIO_GLOBAL(7008),

    /**
     * 【全局】部队物理攻击力提升 - 敌方领地
     */
    ATK_UP_RATIO_ENEMY_TERRITORY(7009),

    /**
     * 【全局】部队物理攻击力提升 - 攻击旗舰
     */
    ATK_UP_RATIO_ATTACK_MOTHERSHIP(7010),

    /**
     * 【全局】部队物理攻击力提升 - 集结编队中
     */
    ATK_UP_RATIO_ASSEMBLE(7011),

    /**
     * 【全局】部队物理攻击力提升 - 攻击海盗时
     */
    ATK_UP_RATIO_ATTACK_MONSTER(7012),

    /**
     * 【全局】部队魔法攻击力提升 - 全局
     */
    MATK_UP_RATIO_GLOBAL(7013),

    /**
     * 【全局】部队魔法攻击力提升 - 敌方领地
     */
    MATK_UP_RATIO_ENEMY_TERRITORY(7014),

    /**
     * 【全局】部队魔法攻击力提升 - 攻击旗舰
     */
    MATK_UP_RATIO_ATTACK_MOTHERSHIP(7015),

    /**
     * 【全局】部队魔法攻击力提升 - 集结编队中
     */
    MATK_UP_RATIO_ASSEMBLE(7016),

    /**
     * 【全局】部队魔法攻击力提升 - 攻击海盗时
     */
    MATK_UP_RATIO_ATTACK_MONSTER(7017),

    /**
     * 【全局】部队物理防御力提升 - 全局
     */
    DEF_UP_RATIO_GLOBAL(7018),

    /**
     * 【全局】部队物理防御力提升 - 我方领地
     */
    DEF_UP_RATIO_OUR_TERRITORY(7019),

    /**
     * 【全局】部队物理防御力提升 - 旗舰防守
     */
    DEF_UP_RATIO_DEFENCE_MOTHERSHIP(7020),

    /**
     * 【全局】部队物理防御力提升 - 援助盟友
     */
    DEF_UP_RATIO_ASSIST_FRIEND(7021),

    /**
     * 【全局】部队物理防御力提升 - 攻击海盗时
     */
    DEF_UP_RATIO_ATTACK_MONSTER(7022),

    /**
     * 【全局】部队魔法防御力提升 - 全局
     */
    MDEF_UP_RATIO_GLOBAL(7023),

    /**
     * 【全局】部队魔法防御力提升 - 我方领地
     */
    MDEF_UP_RATIO_OUR_TERRITORY(7024),

    /**
     * 【全局】部队魔法防御力提升 - 旗舰防守
     */
    MDEF_UP_RATIO_DEFENCE_MOTHERSHIP(7025),

    /**
     * 【全局】部队魔法防御力提升 - 援助盟友
     */
    MDEF_UP_RATIO_ASSIST_FRIEND(7026),

    /**
     * 【全局】部队魔法防御力提升 - 攻击海盗时
     */
    MDEF_UP_RATIO_ATTACK_MONSTER(7027),

    /**
     * 【全局】部队生命值提升 - 全局
     */
    HP_UP_RATIO_GLOBAL(7028),

    /**
     * 【全局】部队生命值提升 - 我方领地
     */
    HP_UP_RATIO_OUR_TERRITORY(7029),

    /**
     * 【全局】部队生命值提升 - 旗舰防守
     */
    HP_UP_RATIO_DEFENCE_MOTHERSHIP(7030),

    /**
     * 【全局】部队生命值提升 - 援助盟友
     */
    HP_UP_RATIO_ASSIST_FRIEND(7031),

    /**
     * 【全局】部队生命值提升 - 攻击海盗时
     */
    HP_UP_RATIO_ATTACK_MONSTER(7032),

    /**
     * 【全局】部队物理攻击力提升 - 攻击港口
     */
    ATK_UP_RATIO_ATTACK_PORTWAR(7033),

    /**
     * 【全局】部队魔法攻击力提升 - 攻击港口
     */
    MATK_UP_RATIO_ATTACK_PORTWAR(7034),

    /**
     * 【全局】部队物理防御力提升 - 驻守港口
     */
    DEF_UP_RATIO_DEFENCE_PORTWAR(7035),

    /**
     * 【全局】部队魔法防御力提升 - 驻守港口
     */
    MDEF_UP_RATIO_DEFENCE_PORTWAR(7036),

    /**
     * 【全局】部队生命值提升 - 驻守港口
     */
    HP_UP_RATIO_DEFENCE_PORTWAR(7037),

    /**
     * 【单一队列】部队物理攻击力提升 - 单一队列
     */
    QUEUE_ATK_UP_RATIO_GLOBAL(7601),

    /**
     * 【单一队列】部队物理攻击力提升 - 敌方领地
     */
    QUEUE_ATK_UP_RATIO_ENEMY_TERRITORY(7602),

    /**
     * 【单一队列】部队物理攻击力提升 - 攻击旗舰
     */
    QUEUE_ATK_UP_RATIO_ATTACK_MOTHERSHIP(7603),

    /**
     * 【单一队列】部队物理攻击力提升 - 集结编队中
     */
    QUEUE_ATK_UP_RATIO_ASSEMBLE(7604),

    /**
     * 【单一队列】部队物理攻击力提升 - 攻击海盗时
     */
    QUEUE_ATK_UP_RATIO_ATTACK_MONSTER(7605),

    /**
     * 【单一队列】部队魔法攻击力提升 - 单一队列
     */
    QUEUE_MATK_UP_RATIO_GLOBAL(7606),

    /**
     * 【单一队列】部队魔法攻击力提升 - 敌方领地
     */
    QUEUE_MATK_UP_RATIO_ENEMY_TERRITORY(7607),

    /**
     * 【单一队列】部队魔法攻击力提升 - 攻击旗舰
     */
    QUEUE_MATK_UP_RATIO_ATTACK_MOTHERSHIP(7608),

    /**
     * 【单一队列】部队魔法攻击力提升 - 集结编队中
     */
    QUEUE_MATK_UP_RATIO_ASSEMBLE(7609),

    /**
     * 【单一队列】部队魔法攻击力提升 - 攻击海盗时
     */
    QUEUE_MATK_UP_RATIO_ATTACK_MONSTER(7610),

    /**
     * 【单一队列】部队物理防御力提升 - 单一队列
     */
    QUEUE_DEF_UP_RATIO_GLOBAL(7611),

    /**
     * 【单一队列】部队物理防御力提升 - 我方领地
     */
    QUEUE_DEF_UP_RATIO_OUR_TERRITORY(7612),

    /**
     * 【单一队列】部队物理防御力提升 - 旗舰防守
     */
    QUEUE_DEF_UP_RATIO_DEFENCE_MOTHERSHIP(7613),

    /**
     * 【单一队列】部队物理防御力提升 - 援助盟友
     */
    QUEUE_DEF_UP_RATIO_ASSIST_FRIEND(7614),

    /**
     * 【单一队列】部队物理防御力提升 - 攻击海盗时
     */
    QUEUE_DEF_UP_RATIO_ATTACK_MONSTER(7615),

    /**
     * 【单一队列】部队魔法防御力提升 - 单一队列
     */
    QUEUE_MDEF_UP_RATIO_GLOBAL(7616),

    /**
     * 【单一队列】部队魔法防御力提升 - 我方领地
     */
    QUEUE_MDEF_UP_RATIO_OUR_TERRITORY(7617),

    /**
     * 【单一队列】部队魔法防御力提升 - 旗舰防守
     */
    QUEUE_MDEF_UP_RATIO_DEFENCE_MOTHERSHIP(7618),

    /**
     * 【单一队列】部队魔法防御力提升 - 援助盟友
     */
    QUEUE_MDEF_UP_RATIO_ASSIST_FRIEND(7619),

    /**
     * 【单一队列】部队魔法防御力提升 - 攻击海盗时
     */
    QUEUE_MDEF_UP_RATIO_ATTACK_MONSTER(7620),

    /**
     * 【单一队列】部队生命值提升 - 单一队列
     */
    QUEUE_HP_UP_RATIO_GLOBAL(7621),

    /**
     * 【单一队列】部队生命值提升 - 我方领地
     */
    QUEUE_HP_UP_RATIO_OUR_TERRITORY(7622),

    /**
     * 【单一队列】部队生命值提升 - 旗舰防守
     */
    QUEUE_HP_UP_RATIO_DEFENCE_MOTHERSHIP(7623),

    /**
     * 【单一队列】部队生命值提升 - 援助盟友
     */
    QUEUE_HP_UP_RATIO_ASSIST_FRIEND(7624),

    /**
     * 【单一队列】部队生命值提升 - 攻击海盗时
     */
    QUEUE_HP_UP_RATIO_ATTACK_MONSTER(7625),

    /**
     * 【单一队列】部队物理攻击力提升 - 攻击港口
     */
    QUEUE_ATK_UP_RATIO_ATTACK_PORTWAR(7626),

    /**
     * 【单一队列】部队魔法攻击力提升 - 攻击港口
     */
    QUEUE_MATK_UP_RATIO_ATTACK_PORTWAR(7627),

    /**
     * 【单一队列】部队物理防御力提升 - 驻守港口
     */
    QUEUE_DEF_UP_RATIO_DEFENCE_PORTWAR(7628),

    /**
     * 【单一队列】部队魔法防御力提升 - 驻守港口
     */
    QUEUE_MDEF_UP_RATIO_DEFENCE_PORTWAR(7629),

    /**
     * 【单一队列】部队生命值提升 - 驻守港口
     */
    QUEUE_HP_UP_RATIO_DEFENCE_PORTWAR(7630),

    /**
     * 8002 = 触发高品质任务的几率增加
     */
    RADAR_RARE_QUEST_UP_RATIO(8002),

    /**
     * 8003 = 每次刷新额外触发{0}个蓝色任务
     */
    RADAR_EXTRA_BLUE_QUEST(8003),

    /**
     * 8004 = 每次刷新额外触发{0}个紫色任务
     */
    RADAR_EXTRA_PURPLE_QUEST(8004),

    /**
     * 提升联盟捐献获得的联盟贡献值
     */
    ALLIANCE_CONTRIBUTION_BY_DONATE_UP_RATIO(8007),

    /**
     * 当玩家进行联盟帮助时，增加每次帮助获取的贡献值
     */
    ALLIANCE_CONTRIBUTION_BY_HELP_UP_RATIO(8011),

    /**
     * 冒险经验获得量提升
     */
    ADVENTURE_EXP_ACCEL(9001),

    ;
    private int value;

    public static EffectType[] ARRAY = {
            BUIDLING_NO_USE,
            BUILDING_SPEED_UP_RATIO,
            CABIN_BUILDING_SPEED_UP_RATIO,
            BUILDING_TIME_DOWN,
            NAVY_SPEED_UP_RATIO,
            NAVY_COST_DOWN_RATIO,
            NAVY_UPGRADE_SPEED_UP_RATIO,
            NAVY_HEAL_SPEED_UP_RATIO,
            EGG_SPEED_UP_RATIO,
            WATER_SPEED_UP_RATIO,
            FOOD_COST_DOWN_RATIO,
            FOOD_SPEED_UP_RATIO,
            NAVY_TRAIN_COUNT_UP,
            MEDICINE_LEVEL_UNLOCK,
            FOOD_LEVEL_UNLOCK,
            NAVY_LIMIT_MAX,
            TRADE_GOODS_LIMIT_UP,
            WOUNDED_SOLDIER_LIMIT_UP,
            MEDICINE_LIMIT_UP,
            WATER_LIMIT_UP,
            FOOD_LIMIT_UP,
            EGG_STORED_TIME_UP,
            WATER_STORED_TIME_UP,
            WAREHOUSE_GOLD_LIMIT,
            WAREHOUSE_RESOURCE_LIMIT,
            WAREHOUSE_GOLD_PROTECT_LIMIT,
            WAREHOUSE_RESOURCE_PROTECT_LIMIT,
            COLLECT_WOOD_SPEED_UP_RATIO,
            COLLECT_CLOTH_SPEED_UP_RATIO,
            COLLECT_METAL_SPEED_UP_RATIO,
            COLLECT_WOOD_CLOTH_METAL_SPEED_UP_RATIO,
            COLLECT_WOOD_BANK_UP_RATIO,
            COLLECT_CLOTH_BANK_UP_RATIO,
            COLLECT_METAL_BANK_UP_RATIO,
            COLLECT_WOOD_CLOTH_METAL_BANK_UP_RATIO,
            AUTO_COOK_UNLOCK,
            MEDICINE_MATERIAL_SPEED_UP_RATIO,
            MEDICINE_SPEED_UP_RATIO,
            CURE_NAVY_COST_DOWN_RATIO,
            MEDICINE_MATERIAL_TIME_LIMIT,
            MEDICINE_MATERIAL_LIMIT,
            FOOD_MATERIAL_LIMIT,
            BOAT_QUEUE_NAVY_LIMIT_UP,
            ALL_SEARCH_SHIP_PRODUCTION_LIMIT_INCR,
            WOOD_SEARCH_SHIP_PRODUCTION_LIMIT_INCR,
            CLOTH_SEARCH_SHIP_PRODUCTION_LIMIT_INCR,
            METAL_SEARCH_SHIP_PRODUCTION_LIMIT_INCR,
            ALLIANCE_HELP_TIME_LIMIT_UP,
            INGREDIENT_UNLOCK,
            RESEARCH_SPEED_UP_RATIO,
            RESEARCH_COST_DOWN_RATIO,
            RESEARCH_TIME_DOWN,
            ARTIFACT_SPEED_TIME_UP,
            ARTIFACT_SPEED_COUNT_UP,
            BUILDING_QUEUE_SPEED_UP_RATIO,
            CABIN_BUILDING_QUEUE_SPEED_UP_RATIO,
            BUILDING_QUEUE_TIME_DOWN,
            NAVY_QUEUE_SPEED_UP_RATIO,
            NAVY_QUEUE_COST_DOWN_RATIO,
            NAVY_UPGRADE_QUEUE_SPEED_UP_RATIO,
            NAVY_QUEUE_LEVEL_UNLOCK,
            NAVY_QUEUE_TRAIN_COUNT_UP,
            BUILDING_HERO_SPEED_UP_RATIO,
            CABIN_BUILDING_HERO_SPEED_UP_RATIO,
            BUILDING_HERO_TIME_DOWN,
            NAVY_HERO_SPEED_UP_RATIO,
            NAVY_HERO_COST_DOWN_RATIO,
            NAVY_HERO_UPGRADE_SPEED_UP_RATIO,
            NAVY_HERO_TRAIN_COUNT_UP,
            IDLE_GAIN_TIME_MAX_INCR,
            IDLE_GAIN_OUTPUT_INCR,
            IDLE_GAIN_QUICK_SUPPLY_TIMES,
            SELL_PRICE_UP,
            ALLIANCE_PORT_SELL_PRICE_UP,
            SELL_PRESTIGE_UP,
            ROB_LOSS_DOWN,
            SELL_TAX,
            BUY_TAX,
            TRADE_LINE_MAX,
            TRADE_PROTECT_AMOUNT,
            MARKET_EFF,
            ROB_RESULT_UP,
            MOTHERSHIP_SPEED_UP_RATIO,
            MOTHERSHIP_TRADE_SPEED_DOWN_RATIO,
            BOAT_SPEED_UP_RATIO,
            BOAT_QUEUE_SPEED_UP_RATIO,
            SCOUT_SPEED_UP_RATIO,
            MONTHERSHIP_ENEMY_TERRITORY_SPEED_UP_RATIO,
            BOAT_BACK_SPEED_UP_RATIO,
            BOAT_JOIN_ASSEMBLE_SPEED_UP_RATIO,
            BOAT_ASSIST_ALLIANCE_PORT_SPEED_UP_RATIO,
            BOAT_ASSIST_ALLY_SPEED_UP_RATIO,
            BOAT_QUEUE_BACK_SPEED_UP_RATIO,
            BOAT_QUEUE_JOIN_ASSEMBLE_SPEED_UP_RATIO,
            BOAT_QUEUE_ASSIST_ALLIANCE_PORT_SPEED_UP_RATIO,
            BOAT_QUEUE_ASSIST_ALLY_SPEED_UP_RATIO,
            MOTHERSHIP_HP_UP,
            BOAT_LOAD_UP,
            BOAT_QUEUE_LOAD_UP,
            GATHER_WOOD_LOAD_UP_RATIO,
            GATHER_CLOTH_LOAD_UP_RATIO,
            GATHER_METAL_LOAD_UP_RATIO,
            GATHER_GOLD_LOAD_UP_RATIO,
            GATHER_SPEED_UP_RATIO,
            GATHER_WOOD_SPEED_UP_RATIO,
            GATHER_CLOTH_SPEED_UP_RATIO,
            GATHER_METAL_SPEED_UP_RATIO,
            GATHER_GOLD_SPEED_UP_RATIO,
            GATHER_QUEUE_SPEED_UP_RATIO,
            GATHER_QUEUE_WOOD_SPEED_UP_RATIO,
            GATHER_QUEUE_CLOTH_SPEED_UP_RATIO,
            GATHER_QUEUE_METAL_SPEED_UP_RATIO,
            GATHER_QUEUE_GOLD_SPEED_UP_RATIO,
            WOOD_GATHER_UNLOCK,
            CLOTH_GATHER_UNLOCK,
            METAL_GATHER_UNLOCK,
            GOLD_GATHER_UNLOCK,
            BOAT_LOAD_UP_RATIO,
            BOAT_QUEUE_LOAD_UP_RATIO,
            WAR_HORN_LIMIT_UP,
            ASSEMBLE_MEMBER_LIMIT_UP,
            JOIN_ASSEMBLE_BOAT_LIMIT_UP,
            MOTHERSHIP_ASSIST_ACCEPT_LIMIT_UP,
            BAN_TELEPORT,
            INVINCIBLE,
            ANTI_SCOUT,
            MOTHERSHIPWAR_BEDESTROYED_DOWN,
            PORTWAR_DESTROY_UP_RATIO,
            PORTWAR_DESTROY_UP,
            BOAT_ATTACK_MOTHERSHIP_DESTRUCTION_UP_RATIO,
            BOAT_ASSEMBLE_DESTRUCTION_UP_RATIO,
            BOAT_DESTRUCTION_UP,
            PORTWAR_QUEUE_DESTROY_UP_RATIO,
            PORTWAR_QUEUE_DESTROY_UP,
            BOAT_QUEUE_ATTACK_MOTHERSHIP_DESTRUCTION_UP_RATIO,
            BOAT_QUEUE_ASSEMBLE_DESTRUCTION_UP_RATIO,
            BOAT_QUEUE_DESTRUCTION_UP,
            BOAT_QUEUE_CALL_BACK_UNLOCK,
            BOAT_QUEUE_HERO_LIMIT,
            TOWER_EXTRA_BONUS_UP_RATIO,
            TOWER_MORE_INTEREST_POINT,
            EXTRA_REWARD_DEFEAT_NORMAL_MONSTER_RATIO,
            NAVY_BADLYHURT_DOWN_RATIO,
            STRIKEPIRATE_BADLYHURT_DOWN_RATIO,
            WHEN_GATHER_ROBBED_KEEP_RATIO,
            ENEMY_ATTACK_PORT_HURT_TO_DEATH_RATIO,
            ENEMY_ATTACK_MOTHERSHIP_HURT_TO_DEATH_RATIO,
            DEFENCE_PORT_DEATH_TO_HURT_RATIO,
            ATTACK_MOTHERSHIP_DEATH_TO_HURT_RATIO,
            ASSEMBLE_BADLYHURT_DOWN_RATIO,
            MOTHERSHIPWAR_DAMAGE_UP_RATIO,
            MOTHERSHIPWAR_HURT_DOWN_RATIO,
            ATK_UP_RATIO_GLOBAL,
            ATK_UP_RATIO_ENEMY_TERRITORY,
            ATK_UP_RATIO_ATTACK_MOTHERSHIP,
            ATK_UP_RATIO_ASSEMBLE,
            ATK_UP_RATIO_ATTACK_MONSTER,
            MATK_UP_RATIO_GLOBAL,
            MATK_UP_RATIO_ENEMY_TERRITORY,
            MATK_UP_RATIO_ATTACK_MOTHERSHIP,
            MATK_UP_RATIO_ASSEMBLE,
            MATK_UP_RATIO_ATTACK_MONSTER,
            DEF_UP_RATIO_GLOBAL,
            DEF_UP_RATIO_OUR_TERRITORY,
            DEF_UP_RATIO_DEFENCE_MOTHERSHIP,
            DEF_UP_RATIO_ASSIST_FRIEND,
            DEF_UP_RATIO_ATTACK_MONSTER,
            MDEF_UP_RATIO_GLOBAL,
            MDEF_UP_RATIO_OUR_TERRITORY,
            MDEF_UP_RATIO_DEFENCE_MOTHERSHIP,
            MDEF_UP_RATIO_ASSIST_FRIEND,
            MDEF_UP_RATIO_ATTACK_MONSTER,
            HP_UP_RATIO_GLOBAL,
            HP_UP_RATIO_OUR_TERRITORY,
            HP_UP_RATIO_DEFENCE_MOTHERSHIP,
            HP_UP_RATIO_ASSIST_FRIEND,
            HP_UP_RATIO_ATTACK_MONSTER,
            ATK_UP_RATIO_ATTACK_PORTWAR,
            MATK_UP_RATIO_ATTACK_PORTWAR,
            DEF_UP_RATIO_DEFENCE_PORTWAR,
            MDEF_UP_RATIO_DEFENCE_PORTWAR,
            HP_UP_RATIO_DEFENCE_PORTWAR,
            QUEUE_ATK_UP_RATIO_GLOBAL,
            QUEUE_ATK_UP_RATIO_ENEMY_TERRITORY,
            QUEUE_ATK_UP_RATIO_ATTACK_MOTHERSHIP,
            QUEUE_ATK_UP_RATIO_ASSEMBLE,
            QUEUE_ATK_UP_RATIO_ATTACK_MONSTER,
            QUEUE_MATK_UP_RATIO_GLOBAL,
            QUEUE_MATK_UP_RATIO_ENEMY_TERRITORY,
            QUEUE_MATK_UP_RATIO_ATTACK_MOTHERSHIP,
            QUEUE_MATK_UP_RATIO_ASSEMBLE,
            QUEUE_MATK_UP_RATIO_ATTACK_MONSTER,
            QUEUE_DEF_UP_RATIO_GLOBAL,
            QUEUE_DEF_UP_RATIO_OUR_TERRITORY,
            QUEUE_DEF_UP_RATIO_DEFENCE_MOTHERSHIP,
            QUEUE_DEF_UP_RATIO_ASSIST_FRIEND,
            QUEUE_DEF_UP_RATIO_ATTACK_MONSTER,
            QUEUE_MDEF_UP_RATIO_GLOBAL,
            QUEUE_MDEF_UP_RATIO_OUR_TERRITORY,
            QUEUE_MDEF_UP_RATIO_DEFENCE_MOTHERSHIP,
            QUEUE_MDEF_UP_RATIO_ASSIST_FRIEND,
            QUEUE_MDEF_UP_RATIO_ATTACK_MONSTER,
            QUEUE_HP_UP_RATIO_GLOBAL,
            QUEUE_HP_UP_RATIO_OUR_TERRITORY,
            QUEUE_HP_UP_RATIO_DEFENCE_MOTHERSHIP,
            QUEUE_HP_UP_RATIO_ASSIST_FRIEND,
            QUEUE_HP_UP_RATIO_ATTACK_MONSTER,
            QUEUE_ATK_UP_RATIO_ATTACK_PORTWAR,
            QUEUE_MATK_UP_RATIO_ATTACK_PORTWAR,
            QUEUE_DEF_UP_RATIO_DEFENCE_PORTWAR,
            QUEUE_MDEF_UP_RATIO_DEFENCE_PORTWAR,
            QUEUE_HP_UP_RATIO_DEFENCE_PORTWAR,
            RADAR_RARE_QUEST_UP_RATIO,
            RADAR_EXTRA_BLUE_QUEST,
            RADAR_EXTRA_PURPLE_QUEST,
            ALLIANCE_CONTRIBUTION_BY_DONATE_UP_RATIO,
            ALLIANCE_CONTRIBUTION_BY_HELP_UP_RATIO,
            ADVENTURE_EXP_ACCEL
    };

    EffectType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EffectType getType(int value) {
        return switch (value) {
            case 1000 -> BUIDLING_NO_USE;
            case 1001 -> BUILDING_SPEED_UP_RATIO;
            case 1002 -> CABIN_BUILDING_SPEED_UP_RATIO;
            case 1003 -> BUILDING_TIME_DOWN;
            case 1004 -> NAVY_SPEED_UP_RATIO;
            case 1005 -> NAVY_COST_DOWN_RATIO;
            case 1006 -> NAVY_UPGRADE_SPEED_UP_RATIO;
            case 1007 -> NAVY_HEAL_SPEED_UP_RATIO;
            case 1008 -> EGG_SPEED_UP_RATIO;
            case 1009 -> WATER_SPEED_UP_RATIO;
            case 1010 -> FOOD_COST_DOWN_RATIO;
            case 1011 -> FOOD_SPEED_UP_RATIO;
            case 1012 -> NAVY_TRAIN_COUNT_UP;
            case 1013 -> MEDICINE_LEVEL_UNLOCK;
            case 1014 -> FOOD_LEVEL_UNLOCK;
            case 1015 -> NAVY_LIMIT_MAX;
            case 1016 -> TRADE_GOODS_LIMIT_UP;
            case 1017 -> WOUNDED_SOLDIER_LIMIT_UP;
            case 1018 -> MEDICINE_LIMIT_UP;
            case 1019 -> WATER_LIMIT_UP;
            case 1020 -> FOOD_LIMIT_UP;
            case 1021 -> EGG_STORED_TIME_UP;
            case 1022 -> WATER_STORED_TIME_UP;
            case 1023 -> WAREHOUSE_GOLD_LIMIT;
            case 1024 -> WAREHOUSE_RESOURCE_LIMIT;
            case 1025 -> WAREHOUSE_GOLD_PROTECT_LIMIT;
            case 1026 -> WAREHOUSE_RESOURCE_PROTECT_LIMIT;
            case 1031 -> COLLECT_WOOD_SPEED_UP_RATIO;
            case 1032 -> COLLECT_CLOTH_SPEED_UP_RATIO;
            case 1033 -> COLLECT_METAL_SPEED_UP_RATIO;
            case 1034 -> COLLECT_WOOD_CLOTH_METAL_SPEED_UP_RATIO;
            case 1035 -> COLLECT_WOOD_BANK_UP_RATIO;
            case 1036 -> COLLECT_CLOTH_BANK_UP_RATIO;
            case 1037 -> COLLECT_METAL_BANK_UP_RATIO;
            case 1038 -> COLLECT_WOOD_CLOTH_METAL_BANK_UP_RATIO;
            case 1039 -> AUTO_COOK_UNLOCK;
            case 1043 -> MEDICINE_MATERIAL_SPEED_UP_RATIO;
            case 1044 -> MEDICINE_SPEED_UP_RATIO;
            case 1046 -> CURE_NAVY_COST_DOWN_RATIO;
            case 1047 -> MEDICINE_MATERIAL_TIME_LIMIT;
            case 1048 -> MEDICINE_MATERIAL_LIMIT;
            case 1049 -> FOOD_MATERIAL_LIMIT;
            case 1050 -> BOAT_QUEUE_NAVY_LIMIT_UP;
            case 1051 -> ALL_SEARCH_SHIP_PRODUCTION_LIMIT_INCR;
            case 1052 -> WOOD_SEARCH_SHIP_PRODUCTION_LIMIT_INCR;
            case 1053 -> CLOTH_SEARCH_SHIP_PRODUCTION_LIMIT_INCR;
            case 1054 -> METAL_SEARCH_SHIP_PRODUCTION_LIMIT_INCR;
            case 1055 -> ALLIANCE_HELP_TIME_LIMIT_UP;
            case 1056 -> INGREDIENT_UNLOCK;
            case 1101 -> RESEARCH_SPEED_UP_RATIO;
            case 1102 -> RESEARCH_COST_DOWN_RATIO;
            case 1103 -> RESEARCH_TIME_DOWN;
            case 1104 -> ARTIFACT_SPEED_TIME_UP;
            case 1105 -> ARTIFACT_SPEED_COUNT_UP;
            case 1501 -> BUILDING_QUEUE_SPEED_UP_RATIO;
            case 1502 -> CABIN_BUILDING_QUEUE_SPEED_UP_RATIO;
            case 1503 -> BUILDING_QUEUE_TIME_DOWN;
            case 1504 -> NAVY_QUEUE_SPEED_UP_RATIO;
            case 1505 -> NAVY_QUEUE_COST_DOWN_RATIO;
            case 1506 -> NAVY_UPGRADE_QUEUE_SPEED_UP_RATIO;
            case 1507 -> NAVY_QUEUE_LEVEL_UNLOCK;
            case 1508 -> NAVY_QUEUE_TRAIN_COUNT_UP;
            case 2001 -> BUILDING_HERO_SPEED_UP_RATIO;
            case 2002 -> CABIN_BUILDING_HERO_SPEED_UP_RATIO;
            case 2003 -> BUILDING_HERO_TIME_DOWN;
            case 2004 -> NAVY_HERO_SPEED_UP_RATIO;
            case 2005 -> NAVY_HERO_COST_DOWN_RATIO;
            case 2006 -> NAVY_HERO_UPGRADE_SPEED_UP_RATIO;
            case 2007 -> NAVY_HERO_TRAIN_COUNT_UP;
            case 3001 -> IDLE_GAIN_TIME_MAX_INCR;
            case 3002 -> IDLE_GAIN_OUTPUT_INCR;
            case 3003 -> IDLE_GAIN_QUICK_SUPPLY_TIMES;
            case 4001 -> SELL_PRICE_UP;
            case 4002 -> ALLIANCE_PORT_SELL_PRICE_UP;
            case 4003 -> SELL_PRESTIGE_UP;
            case 4004 -> ROB_LOSS_DOWN;
            case 4005 -> SELL_TAX;
            case 4006 -> BUY_TAX;
            case 4007 -> TRADE_LINE_MAX;
            case 4008 -> TRADE_PROTECT_AMOUNT;
            case 4009 -> MARKET_EFF;
            case 4012 -> ROB_RESULT_UP;
            case 6001 -> MOTHERSHIP_SPEED_UP_RATIO;
            case 6004 -> MOTHERSHIP_TRADE_SPEED_DOWN_RATIO;
            case 6006 -> BOAT_SPEED_UP_RATIO;
            case 6007 -> BOAT_QUEUE_SPEED_UP_RATIO;
            case 6008 -> SCOUT_SPEED_UP_RATIO;
            case 6009 -> MONTHERSHIP_ENEMY_TERRITORY_SPEED_UP_RATIO;
            case 6010 -> BOAT_BACK_SPEED_UP_RATIO;
            case 6011 -> BOAT_JOIN_ASSEMBLE_SPEED_UP_RATIO;
            case 6012 -> BOAT_ASSIST_ALLIANCE_PORT_SPEED_UP_RATIO;
            case 6013 -> BOAT_ASSIST_ALLY_SPEED_UP_RATIO;
            case 6014 -> BOAT_QUEUE_BACK_SPEED_UP_RATIO;
            case 6015 -> BOAT_QUEUE_JOIN_ASSEMBLE_SPEED_UP_RATIO;
            case 6016 -> BOAT_QUEUE_ASSIST_ALLIANCE_PORT_SPEED_UP_RATIO;
            case 6017 -> BOAT_QUEUE_ASSIST_ALLY_SPEED_UP_RATIO;
            case 6018 -> MOTHERSHIP_HP_UP;
            case 6021 -> BOAT_LOAD_UP;
            case 6022 -> BOAT_QUEUE_LOAD_UP;
            case 6023 -> GATHER_WOOD_LOAD_UP_RATIO;
            case 6024 -> GATHER_CLOTH_LOAD_UP_RATIO;
            case 6025 -> GATHER_METAL_LOAD_UP_RATIO;
            case 6026 -> GATHER_GOLD_LOAD_UP_RATIO;
            case 6027 -> GATHER_SPEED_UP_RATIO;
            case 6028 -> GATHER_WOOD_SPEED_UP_RATIO;
            case 6029 -> GATHER_CLOTH_SPEED_UP_RATIO;
            case 6030 -> GATHER_METAL_SPEED_UP_RATIO;
            case 6031 -> GATHER_GOLD_SPEED_UP_RATIO;
            case 6032 -> GATHER_QUEUE_SPEED_UP_RATIO;
            case 6033 -> GATHER_QUEUE_WOOD_SPEED_UP_RATIO;
            case 6034 -> GATHER_QUEUE_CLOTH_SPEED_UP_RATIO;
            case 6035 -> GATHER_QUEUE_METAL_SPEED_UP_RATIO;
            case 6036 -> GATHER_QUEUE_GOLD_SPEED_UP_RATIO;
            case 6037 -> WOOD_GATHER_UNLOCK;
            case 6038 -> CLOTH_GATHER_UNLOCK;
            case 6039 -> METAL_GATHER_UNLOCK;
            case 6040 -> GOLD_GATHER_UNLOCK;
            case 6041 -> BOAT_LOAD_UP_RATIO;
            case 6042 -> BOAT_QUEUE_LOAD_UP_RATIO;
            case 6051 -> WAR_HORN_LIMIT_UP;
            case 6052 -> ASSEMBLE_MEMBER_LIMIT_UP;
            case 6053 -> JOIN_ASSEMBLE_BOAT_LIMIT_UP;
            case 6054 -> MOTHERSHIP_ASSIST_ACCEPT_LIMIT_UP;
            case 6055 -> BAN_TELEPORT;
            case 6056 -> INVINCIBLE;
            case 6057 -> ANTI_SCOUT;
            case 6061 -> MOTHERSHIPWAR_BEDESTROYED_DOWN;
            case 6062 -> PORTWAR_DESTROY_UP_RATIO;
            case 6063 -> PORTWAR_DESTROY_UP;
            case 6064 -> BOAT_ATTACK_MOTHERSHIP_DESTRUCTION_UP_RATIO;
            case 6065 -> BOAT_ASSEMBLE_DESTRUCTION_UP_RATIO;
            case 6066 -> BOAT_DESTRUCTION_UP;
            case 6067 -> PORTWAR_QUEUE_DESTROY_UP_RATIO;
            case 6068 -> PORTWAR_QUEUE_DESTROY_UP;
            case 6069 -> BOAT_QUEUE_ATTACK_MOTHERSHIP_DESTRUCTION_UP_RATIO;
            case 6070 -> BOAT_QUEUE_ASSEMBLE_DESTRUCTION_UP_RATIO;
            case 6071 -> BOAT_QUEUE_DESTRUCTION_UP;
            case 6072 -> BOAT_QUEUE_CALL_BACK_UNLOCK;
            case 6073 -> BOAT_QUEUE_HERO_LIMIT;
            case 6082 -> TOWER_EXTRA_BONUS_UP_RATIO;
            case 6083 -> TOWER_MORE_INTEREST_POINT;
            case 6090 -> EXTRA_REWARD_DEFEAT_NORMAL_MONSTER_RATIO;
            case 6101 -> NAVY_BADLYHURT_DOWN_RATIO;
            case 6102 -> STRIKEPIRATE_BADLYHURT_DOWN_RATIO;
            case 6103 -> WHEN_GATHER_ROBBED_KEEP_RATIO;
            case 6104 -> ENEMY_ATTACK_PORT_HURT_TO_DEATH_RATIO;
            case 6105 -> ENEMY_ATTACK_MOTHERSHIP_HURT_TO_DEATH_RATIO;
            case 6106 -> DEFENCE_PORT_DEATH_TO_HURT_RATIO;
            case 6107 -> ATTACK_MOTHERSHIP_DEATH_TO_HURT_RATIO;
            case 6109 -> ASSEMBLE_BADLYHURT_DOWN_RATIO;
            case 7001 -> MOTHERSHIPWAR_DAMAGE_UP_RATIO;
            case 7002 -> MOTHERSHIPWAR_HURT_DOWN_RATIO;
            case 7008 -> ATK_UP_RATIO_GLOBAL;
            case 7009 -> ATK_UP_RATIO_ENEMY_TERRITORY;
            case 7010 -> ATK_UP_RATIO_ATTACK_MOTHERSHIP;
            case 7011 -> ATK_UP_RATIO_ASSEMBLE;
            case 7012 -> ATK_UP_RATIO_ATTACK_MONSTER;
            case 7013 -> MATK_UP_RATIO_GLOBAL;
            case 7014 -> MATK_UP_RATIO_ENEMY_TERRITORY;
            case 7015 -> MATK_UP_RATIO_ATTACK_MOTHERSHIP;
            case 7016 -> MATK_UP_RATIO_ASSEMBLE;
            case 7017 -> MATK_UP_RATIO_ATTACK_MONSTER;
            case 7018 -> DEF_UP_RATIO_GLOBAL;
            case 7019 -> DEF_UP_RATIO_OUR_TERRITORY;
            case 7020 -> DEF_UP_RATIO_DEFENCE_MOTHERSHIP;
            case 7021 -> DEF_UP_RATIO_ASSIST_FRIEND;
            case 7022 -> DEF_UP_RATIO_ATTACK_MONSTER;
            case 7023 -> MDEF_UP_RATIO_GLOBAL;
            case 7024 -> MDEF_UP_RATIO_OUR_TERRITORY;
            case 7025 -> MDEF_UP_RATIO_DEFENCE_MOTHERSHIP;
            case 7026 -> MDEF_UP_RATIO_ASSIST_FRIEND;
            case 7027 -> MDEF_UP_RATIO_ATTACK_MONSTER;
            case 7028 -> HP_UP_RATIO_GLOBAL;
            case 7029 -> HP_UP_RATIO_OUR_TERRITORY;
            case 7030 -> HP_UP_RATIO_DEFENCE_MOTHERSHIP;
            case 7031 -> HP_UP_RATIO_ASSIST_FRIEND;
            case 7032 -> HP_UP_RATIO_ATTACK_MONSTER;
            case 7033 -> ATK_UP_RATIO_ATTACK_PORTWAR;
            case 7034 -> MATK_UP_RATIO_ATTACK_PORTWAR;
            case 7035 -> DEF_UP_RATIO_DEFENCE_PORTWAR;
            case 7036 -> MDEF_UP_RATIO_DEFENCE_PORTWAR;
            case 7037 -> HP_UP_RATIO_DEFENCE_PORTWAR;
            case 7601 -> QUEUE_ATK_UP_RATIO_GLOBAL;
            case 7602 -> QUEUE_ATK_UP_RATIO_ENEMY_TERRITORY;
            case 7603 -> QUEUE_ATK_UP_RATIO_ATTACK_MOTHERSHIP;
            case 7604 -> QUEUE_ATK_UP_RATIO_ASSEMBLE;
            case 7605 -> QUEUE_ATK_UP_RATIO_ATTACK_MONSTER;
            case 7606 -> QUEUE_MATK_UP_RATIO_GLOBAL;
            case 7607 -> QUEUE_MATK_UP_RATIO_ENEMY_TERRITORY;
            case 7608 -> QUEUE_MATK_UP_RATIO_ATTACK_MOTHERSHIP;
            case 7609 -> QUEUE_MATK_UP_RATIO_ASSEMBLE;
            case 7610 -> QUEUE_MATK_UP_RATIO_ATTACK_MONSTER;
            case 7611 -> QUEUE_DEF_UP_RATIO_GLOBAL;
            case 7612 -> QUEUE_DEF_UP_RATIO_OUR_TERRITORY;
            case 7613 -> QUEUE_DEF_UP_RATIO_DEFENCE_MOTHERSHIP;
            case 7614 -> QUEUE_DEF_UP_RATIO_ASSIST_FRIEND;
            case 7615 -> QUEUE_DEF_UP_RATIO_ATTACK_MONSTER;
            case 7616 -> QUEUE_MDEF_UP_RATIO_GLOBAL;
            case 7617 -> QUEUE_MDEF_UP_RATIO_OUR_TERRITORY;
            case 7618 -> QUEUE_MDEF_UP_RATIO_DEFENCE_MOTHERSHIP;
            case 7619 -> QUEUE_MDEF_UP_RATIO_ASSIST_FRIEND;
            case 7620 -> QUEUE_MDEF_UP_RATIO_ATTACK_MONSTER;
            case 7621 -> QUEUE_HP_UP_RATIO_GLOBAL;
            case 7622 -> QUEUE_HP_UP_RATIO_OUR_TERRITORY;
            case 7623 -> QUEUE_HP_UP_RATIO_DEFENCE_MOTHERSHIP;
            case 7624 -> QUEUE_HP_UP_RATIO_ASSIST_FRIEND;
            case 7625 -> QUEUE_HP_UP_RATIO_ATTACK_MONSTER;
            case 7626 -> QUEUE_ATK_UP_RATIO_ATTACK_PORTWAR;
            case 7627 -> QUEUE_MATK_UP_RATIO_ATTACK_PORTWAR;
            case 7628 -> QUEUE_DEF_UP_RATIO_DEFENCE_PORTWAR;
            case 7629 -> QUEUE_MDEF_UP_RATIO_DEFENCE_PORTWAR;
            case 7630 -> QUEUE_HP_UP_RATIO_DEFENCE_PORTWAR;
            case 8002 -> RADAR_RARE_QUEST_UP_RATIO;
            case 8003 -> RADAR_EXTRA_BLUE_QUEST;
            case 8004 -> RADAR_EXTRA_PURPLE_QUEST;
            case 8007 -> ALLIANCE_CONTRIBUTION_BY_DONATE_UP_RATIO;
            case 8011 -> ALLIANCE_CONTRIBUTION_BY_HELP_UP_RATIO;
            case 9001 -> ADVENTURE_EXP_ACCEL;
            default -> {
                LogUtils.logger.error("EffectType is not find value:{}",value);
                yield null;
            }
        };
    }
}
