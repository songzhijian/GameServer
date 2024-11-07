package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成ErrorCode
 */
public enum ErrorCode {

    /**
     * 未定义的服务器内部错误
     */
    SERVER_ERROR(100000),

    /**
     * 正在绑定执行中,请稍后重试
     */
    PLATFORM_ID_OCCUPY(100001),

    /**
     * 已绑定此平台其他ID
     */
    THIS_MAPPING_TYPE_IS_MAPPING(100002),

    /**
     * 此ID已经绑定其他账号
     */
    THIS_PLATFORM_ID_IS_MAPPING(100003),

    /**
     * 绑定失败
     */
    MAPPING_CREATE_FAIL(100004),

    /**
     * 服务器主动踢玩家下线,客户端需要断开连接,退回登录界面
     */
    SERVER_MANUAL_KICK(100005),

    /**
     * 玩家在其他端登录,客户端需要断开连接,退回登录界面
     */
    PLAYER_OTHER_DEVICE_LOGIN(100006),

    /**
     * 玩家账号临时封禁,需要多久解封
     */
    LOGIN_FAIL_TEMP_BAN(100007),

    /**
     * 玩家账号永久封禁,无法登录
     */
    LOGIN_FAIL_FOREVER_BAN(100008),

    /**
     * 玩家账号已注销,无法登录
     */
    LOGIN_FAIL_ACCOUNT_DESTROY(100009),

    /**
     * 玩家账号状态异常,无法登录
     */
    LOGIN_FAIL_ACCOUNT_STATE_ERROR(100010),

    /**
     * TOKEN失效
     */
    TOKEN_INVALID(100011),

    /**
     * 该地区未开放，无法登录
     */
    LOGIN_FAIL_REGION_NOT_OPEN(100012),

    /**
     * 单服单账号角色数量达到上限
     */
    SINGLE_SERVER_ROLES_LIMIT(100013),

    /**
     * 你已使用过此兑换码
     */
    YOU_HAVE_ALREADY_USED_THIS_CDKEY(100090),

    /**
     * 兑换码状态检测中，请稍后重试
     */
    CDKEY_LOCK(100091),

    /**
     * 兑换码失效
     */
    CDKEY_INVALID(100092),

    /**
     * 兑换码过期
     */
    CDKEY_EXPIRED(100093),

    /**
     * 兑换码不存在
     */
    CDKEY_DOES_NOT_EXIST(100094),

    /**
     * 兑换码领取失败，请稍后重试
     */
    CDKEY_REWARD_FAIL(100095),

    /**
     * 刷新时间没到
     */
    DRIFTING_TIME_NOT_YET_ARRIVED(100101),

    /**
     * 建筑数量超过上限
     */
    BUILDING_COUNT_EXCEEDS_UPPER_LIMIT(100201),

    /**
     * 建筑放置位置重叠
     */
    BUILDING_POS_PLACE_REPEAT(100202),

    /**
     * 建筑不存在
     */
    BUILDING_DOES_NOT_EXIST(100203),

    /**
     * 前置条件未达成
     */
    PRECONDITIONS_NOT_FULFILLED(100204),

    /**
     * 无需点击
     */
    NO_NEED_TO_CLICK(100205),

    /**
     * 建筑所需的资源不足
     */
    BUILDING_COST_NOT_ENOUGH(100206),

    /**
     * 英雄不在工具间中,无法建造
     */
    HERO_BUILDING_ERROR(100207),

    /**
     * 运输后超过仓库存储上限,无法运输
     */
    STORAGE_FULL_TRANSPORT_ERROR(100208),

    /**
     * 仓库中物品已满
     */
    STORAGE_FULL_ERROR(100209),

    /**
     * 船长室等级限制
     */
    MAIN_BUILDING_LEVEL_LIMIT(100210),

    /**
     * 搜寻船的等级达到上限
     */
    SEARCH_SHIP_LV_IS_MAX(100211),

    /**
     * 搜寻船的升级前置条件不满足
     */
    SEARCH_SHIP_LV_UP_CONDITION_ERROR(100213),

    /**
     * 搜寻船的升级资源不足
     */
    SEARCH_SHIP_LV_UP_COST_NOT_ENOUGH(100214),

    /**
     * 对应建筑的仓库容量达到上限，无法制作物品
     */
    STORAGE_SIZE_MAX_MAKE_ERROR(100215),

    /**
     * 对应物品的等级未解锁，无法制作物品
     */
    MAKE_ITEM_LEVEL_UNLOCK(100216),

    /**
     * 有建筑不可以移动
     */
    BUILDING_MOVE_ERROR(100217),

    /**
     * 有建筑不可以收纳
     */
    BUILDING_HIDDEN_ERROR(100218),

    /**
     * 英雄不存在
     */
    HERO_DO_NOT_EXIST(100301),

    /**
     * 英雄忙碌中
     */
    HERO_BUSY(100302),

    /**
     * 品质未到达英雄升级时需求
     */
    HERO_LV_UP_QUALITY_NOT_ENOUGH(100303),

    /**
     * 需要将前{}名英雄提升到{}级才能继续升级
     */
    HERO_LV_UP_RANK_IS_HIGH(100304),

    /**
     * 英雄升级所需道具不足
     */
    HERO_LV_UP_ITEM_NOT_ENOUGH(100305),

    /**
     * 英雄不存在专属装备
     */
    HERO_EXCLUSIVE_NO_EXIST(100306),

    /**
     * 英雄专属装备未解锁
     */
    HERO_EXCLUSIVE_UNLOCK_CONDITION(100307),

    /**
     * 英雄专属装备升级所需道具不足
     */
    HERO_EXCLUSIVE_UP_ITEM_NOT_ENOUGH(100308),

    /**
     * 装备不存在
     */
    EQUIP_DO_NOT_EXIST(100309),

    /**
     * 装备无法穿戴,类型不匹配
     */
    EQUIP_TYPE_NOT_MATCH(100310),

    /**
     * 装备不可以消耗
     */
    EQUIP_CANNOT_COST(100311),

    /**
     * 装备已经到达强化上限
     */
    EQUIP_LEVEL_UP_MAX(100312),

    /**
     * 装备强化道具不足
     */
    EQUIP_UP_ITEM_NOT_ENOUGH(100313),

    /**
     * 装备洗练道具不足
     */
    EQUIP_RECOIN_ITEM_NOT_ENOUGH(100314),

    /**
     * 装备进阶道具不足
     */
    EQUIP_ENHANCE_ITEM_NOT_ENOUGH(100315),

    /**
     * 装备没有标签无法进阶
     */
    EQUIP_ENHANCE_NEED_RACE_BUFF(100316),

    /**
     * 装备无法进阶
     */
    EQUIP_CANNOT_ENHANCE(100317),

    /**
     * 英雄处于行军中
     */
    HERO_IN_MARCH(100318),

    /**
     * 英雄正在工作队列中
     */
    HERO_IN_QUEUE(100319),

    /**
     * 重置英雄所需道具不足
     */
    HERO_RESET_COST_NOT_ENOUGH(100320),

    /**
     * 英雄升级受到天下大势限制
     */
    HERO_LV_UP_LIMITED_BY_TREND(100321),

    /**
     * 贤者之石升级的英雄已经到达上限
     */
    ORACLE_STONE_LV_MAX(100322),

    /**
     * 已经升到该英雄的最大限制等级
     */
    HERO_LV_MAX(100323),

    /**
     * 队列已结束
     */
    QUEUE_HAS_ENDED(100401),

    /**
     * 队列进行中
     */
    QUEUE_IN_PROGRESS(100402),

    /**
     * 没有空闲队列
     */
    NO_FREE_QUEUE(100403),

    /**
     * 水兵队列里的数量达到上限
     */
    TRAIN_QUEUE_IS_MAX(100404),

    /**
     * 水兵数量达到上限，无法训练
     */
    NAVY_IS_MAX_CANNOT_TRAIN(100405),

    /**
     * 道具数量不足
     */
    ITEM_NUM_NOT_ENOUGH(100501),

    /**
     * 该道具不可使用
     */
    ITEM_CANNOT_USE(100502),

    /**
     * 该道具数量未达到使用的条件
     */
    ITEM_NUM_CANNOT_USE(100503),

    /**
     * 该道具还在冷却期
     */
    ITEM_USE_IN_CD(100504),

    /**
     * 该道具过期无法使用
     */
    ITEM_EXPIRED(100505),

    /**
     * 该道具只能一个一个使用
     */
    ITEM_USE_ONLY_ONE(100506),

    /**
     * 快捷补齐消耗不足
     */
    QUICK_SUPPLY_COST_NOT_ENOUGH(100507),

    /**
     * 资源已到达或超过上限,操作失败
     */
    USE_RESOURCE_ITME_FAIL_MAX(100508),

    /**
     * 使用资源道具失败,资源数量发生了变化
     */
    USE_RESOURCE_ITME_FAIL_CHANGE(100509),

    /**
     * 名称中含有屏蔽字
     */
    NAME_IS_BAD_WORD(100601),

    /**
     * 联盟名称长度不对
     */
    ALLIANCE_NAME_LEN_ERROR(100602),

    /**
     * 联盟简称长度不对
     */
    ABBR_NAME_LEN_ERROR(100603),

    /**
     * 联盟名称已经存在了
     */
    ALLIANCE_NAME_HAS_EXIST(100604),

    /**
     * 联盟简称已经存在了
     */
    ABBR_HAS_EXIST(100605),

    /**
     * 输入不可为空
     */
    NAME_IS_NULL(100606),

    /**
     * 联盟宣言超过长度
     */
    INTRO_LEN_TOO_LONG(100607),

    /**
     * 联盟公告超过长度
     */
    ANNOUNCE_LEN_TOO_LONG(100608),

    /**
     * 联盟简称只能为数字和大小写字母
     */
    ABBR_NAME_FORMAT_ERROR(100609),

    /**
     * 联盟加入处于冷却中
     */
    JOIN_ALLIANCE_IN_CD(100610),

    /**
     * 您已经申请过该联盟
     */
    REPEAT_ALLIANCE_APPLY(100611),

    /**
     * 您无法加入其他战区的联盟！
     */
    ALLIANCE_SERVER_NOT_MATCH(100612),

    /**
     * 联盟人数达上限
     */
    ALLIANCE_IS_FULL(100613),

    /**
     * 您最多只能向{0}个联盟提出入盟申请
     */
    PLAYER_ALLIANCE_APPLY_FULL(100614),

    /**
     * 目标联盟申请人数过多，请稍后再试
     */
    ALLIANCE_APPLY_LIST_FULL(100615),

    /**
     * 联盟申请失败，战力未达到要求
     */
    ALLIANCE_APPLY_POWER_LOW(100616),

    /**
     * 联盟申请失败，船长室等级未达到要求
     */
    ALLIANCE_APPLY_LEVEL_LOW(100617),

    /**
     * 联盟操作的权限不足
     */
    ALLIANCE_AUTHORITY_NOT_ENOUGH(100618),

    /**
     * 创建联盟的所需要的道具不足
     */
    ALLIANCE_CREATE_ITEM_NOT_ENOUGH(100619),

    /**
     * 联盟宣言长度错误
     */
    ANNOUNCE_LEN_ERROR(100620),

    /**
     * 联盟名称修改的所需要的道具不足
     */
    ALLIANCE_NAME_ITEM_NOT_ENOUGH(100621),

    /**
     * 联盟简称修改的所需要的道具不足
     */
    ALLIANCE_ABBR_ITEM_NOT_ENOUGH(100622),

    /**
     * 联盟旗帜修改的所需要的道具不足
     */
    ALLIANCE_ICON_ITEM_NOT_ENOUGH(100623),

    /**
     * 联盟中还有其他成员，无法解散
     */
    ALLIANCE_DISBAND_HAS_OTEHRS(100624),

    /**
     * 当拥有领地时，无法解散联盟
     */
    ALLIANCE_DISBAND_HAS_CITY(100625),

    /**
     * 联盟的目标阶级人数已达上限
     */
    ALLIANCE_RANK_COUNT_MAX(100626),

    /**
     * 玩家已经加入了其他联盟了
     */
    HAS_JOIN_OTHER_ALLIANCE(100627),

    /**
     * 暂无可加入的联盟，可选择自行创建
     */
    NO_QUICK_JOIN_ALLIANCE(100628),

    /**
     * 只有R4才能任命官职
     */
    OFFICIAL_MUST_BE_R4(100629),

    /**
     * 联盟成员已达上限
     */
    ALLIANCE_MEMBER_IS_MAX(100630),

    /**
     * 目标已加入一个联盟
     */
    PLAYER_HAS_JOIN_OTHER_ALLIANCE(100631),

    /**
     * 玩家目前未加入联盟
     */
    PLAYER_HAS_NO_ALLIANCE(100632),

    /**
     * 没有联盟，无法进行相关操作
     */
    PLAYER_NOT_HAVE_ALLIANCE(100633),

    /**
     * 队列不存在或者已完成，无法请求联盟帮助
     */
    ALLIANCE_HELP_QUEUE_IS_FINISH(100634),

    /**
     * 该条联盟帮助已经被他人帮助完了
     */
    ALLIANCE_HELP_IS_FINISH(100635),

    /**
     * 该队列类型不可以被帮助
     */
    ALLIANCE_HELP_QUEUE_TYPE_ERROR(100636),

    /**
     * 该队列已经提过帮助了，不可重复提交
     */
    SEEK_ALLIANCE_HELP_REPEAT(100637),

    /**
     * 该条帮助不存在，已经过期
     */
    ALLIANCE_HELP_IS_NULL(100638),

    /**
     * 已经帮助过该队列了，不可重复帮助
     */
    QUEUE_REPEAT_HELP(100639),

    /**
     * 不能帮助自己
     */
    ALLIANCE_HELP_IS_SELF(100640),

    /**
     * 联盟礼物不存在
     */
    ALLIANCE_GIFT_IS_NULL(100641),

    /**
     * 联盟礼物已经过期了
     */
    ALLIANCE_GIFT_IS_EXPIRED(100642),

    /**
     * 有盟友正在援助自己家的战斗，不能离开联盟
     */
    ALLIANCE_EXIT_ERROR_STATIONING(100643),

    /**
     * 参与/发起已出发的集结，不能离开联盟
     */
    ALLIANCE_EXIT_ERROR_ASSEMBLING(100644),

    /**
     * 正在与援军身份援助盟友的战斗，不能离开联盟
     */
    ALLIANCE_EXIT_ERROR_HELP_OTHERS(100645),

    /**
     * 玩家申请已取消，无法进行审批操作
     */
    ALLIANCE_APPLY_CANCEL(100646),

    /**
     * 玩家处理邀请失败，邮件不存在
     */
    ALLIANCE_INVITE_HANDLE_FAIL_MAIL_NULL(100647),

    /**
     * 该玩家阶级已发生变化，请重新查看
     */
    ALLIANCE_RANK_HAS_CHANGE(100648),

    /**
     * 联盟BOSS活动期间不可以解散联盟
     */
    ALLIANCE_BOSS_TIME_CANT_DISBAND(100649),

    /**
     * 联盟BOSS攻击次数用尽
     */
    ALLIANCE_BOSS_ATTACK_TIME_NOT_ENOUGH(100650),

    /**
     * 船名超过长度上线
     */
    SHIP_NAME_LEN_ERROR(100701),

    /**
     * 购买船只所需要的道具不足
     */
    BUY_SHIP_ITEM_NOT_ENOUGH(100702),

    /**
     * 换船自动装配失败，有不满足的条件
     */
    CHANGE_SHIP_ERROR(100703),

    /**
     * 更换船装饰所需道具不足
     */
    SHIP_DECORATE_COST_NOT_ENOUGH(100704),

    /**
     * 该船不可以装该位置的装备
     */
    SHIP_EQUIP_WEAR_ERROR(100705),

    /**
     * 贸易品数量不足
     */
    TRADE_SELL_NUM_NO_ENOUGH(100800),

    /**
     * 价格发生变化
     */
    TRADE_PRICE_CHANGE(100801),

    /**
     * 港口附近船已满，无法停泊
     */
    PORT_STATION_POSTION_IS_FULL(100802),

    /**
     * 请先前往港口附近
     */
    PORT_STATION_POSTION_IS_FAR(100803),

    /**
     * 无法交易
     */
    TRADE_IS_ERROR(100804),

    /**
     * 仓库已满
     */
    TRADE_WAREHOUSE_IS_FULL(100805),

    /**
     * 旧版贸易无法使用的提示
     */
    TRADE_IS_USELESS(100806),

    /**
     * 请提升冒险等级，解锁贸易品
     */
    TRADE_ADVENTURE_LEVEL_NOT_ENOUGH(100807),

    /**
     * 请提升信用等级，解锁贸易品
     */
    TRADE_CREDIBILITY_LEVEL_NOT_ENOUGH(100808),

    /**
     * 解锁分支的英雄数量不符合
     */
    STRIKE_PIRATE_UNLOCK_HERO_NUM_ERROR(100901),

    /**
     * 解锁分支的英雄类型不符合
     */
    STRIKE_PIRATE_UNLOCK_HERO_TYPE_ERROR(100902),

    /**
     * 解锁分支的英雄品质不符合
     */
    STRIKE_PIRATE_UNLOCK_HERO_QUALITY_ERROR(100903),

    /**
     * 解锁分支的英雄性别不符合
     */
    STRIKE_PIRATE_UNLOCK_HERO_MALE_ERROR(100904),

    /**
     * 解锁分支所需资源不足
     */
    STRIKE_PIRATE_UNLOCK_COST_NOT_ENOUGH(100905),

    /**
     * 该分支未解锁，不可以战斗
     */
    STRIKE_PIRATE_BRANCH_LOCK(100906),

    /**
     * 推图错误，该敌人不可以战斗
     */
    STRIKE_PIRATE_ENEMY_ERROR(100907),

    /**
     * 推图快速挂机奖励，资源消耗不足
     */
    STRIKE_PIRATE_QUICK_HANG_UP_COST_NOT_ENOUGH(100908),

    /**
     * 您有部队在外，无法急速航行
     */
    TELEPORT_TEAM_OUT(101000),

    /**
     * 母舰出院战斗状态，无法急速航行
     */
    TELEPORT_MAIN_SHIP_FIGHTING(101001),

    /**
     * 您处于战争狂热状态，无法急速航行
     */
    TELEPORT_IN_FIRGHTING(101002),

    /**
     * 当前位置不可前往！
     */
    TELEPORT_POS_ERROR(101003),

    /**
     * 研究所需的资源不足
     */
    TECH_COST_NOT_ENOUGH(101101),

    /**
     * 研究立即完成所需钻石不足
     */
    TECH_INSTANT_COST_NOT_ENOUGH(101102),

    /**
     * 邮件已领取
     */
    MAIL_ALREADY_COLLECT(101201),

    /**
     * 邮件已删除
     */
    MAIL_ALREADY_DELETE(101202),

    /**
     * 活动已关闭
     */
    ACTIVITY_CLOSE(101301),

    /**
     * 任务尚未完成
     */
    TASK_NOT_FINISH(101401),

    /**
     * 任务奖励已经领取
     */
    TASK_REWARDED(101402),

    /**
     * 标记不存在
     */
    WORLD_FLAG_NOT_EXIST(200101),

    /**
     * 标记配置不存在
     */
    WORLD_FLAG_CONFIG_NOT_EXIST(200102),

    /**
     * 标记类型错误
     */
    WORLD_FLAG_TYPE_ERROR(200103),

    /**
     * 该类型标记数量达到上限
     */
    WORLD_FLAG_NUM_LIMIT(200104),

    /**
     * 标记名称不符合规范
     */
    WORLD_FLAG_NAME_INCORRECT(200105),

    /**
     * 标记名称超过字符数量上限
     */
    WORLD_FLAG_NAME_TOO_LONG(200106),

    /**
     * 无字之书等级已达上限
     */
    WORD_LESS_BOOK_LV_LIMIT(200201),

    /**
     * 无字之书升级消耗能量不足
     */
    WORD_LESS_BOOK_LV_UP_ENERGY_NOT_ENOUGH(200202),

    /**
     * 无字之书收取能量英雄不存在
     */
    WORD_LESS_BOOK_COLLECT_HERO_ID_NOT_EXIST(200203),

    /**
     * 无字之书下一等级配置缺失
     */
    WORD_LESS_BOOK_LV_CONFIG_MISS(200204),

    /**
     * 图鉴奖励已经领取
     */
    HAND_BOOK_AWARD_ALREADY_RECEIVED(200301),

    /**
     * 神器尚未激活
     */
    ARTIFACT_NOT_ACTIVE(200401),

    /**
     * 神器已达最高阶段
     */
    ARTIFACT_PHASE_MAX(200402),

    /**
     * 神器阶段提升消耗不足
     */
    ARTIFACT_PHASE_UP_COST_NOT_ENOUGH(200403),

    /**
     * vip每日经验已经领取
     */
    VIP_DAILY_EXP_ALREADY_RECEIVED(200601),

    /**
     * vip等级不足
     */
    VIP_LEVEL_NOT_ENOUGH(200602),

    /**
     * vip今日奖励已经领取
     */
    VIP_REWARD_TODAY_ALREADY_RECEIVED(200603),

    /**
     * 已达礼包限购次数
     */
    GIFT_BUY_TIME_LIMIT(200701),

    /**
     * 礼包购买条件不足
     */
    GIFT_BUY_CONDITION_NOT_ENOUGH(200702),

    /**
     * 天下大势领奖参数错误
     */
    GET_TREND_AWARD_PARAM_ERROR(200801),

    /**
     * 此功能暂时关闭
     */
    FUNCTION_CLOSE(200901),

    /**
     * 已拥有鱼竿，请勿重复建造
     */
    BEGINNER_RAFT_FISHROD(300001),

    /**
     * 已拥有船桨，请勿重复建造
     */
    BEGINNER_RAFT_PADDLE(300002),

    /**
     * 新手战斗已经通关
     */
    NEWBIE_BATTLE_ALREADY_PASS(300003),

    /**
     * 等待盟友加入集结中，主舰禁止移动
     */
    BOAT_MAIN_ASSEMBLING_SHIP_NOT_MOVE(500001),

    /**
     * 当前状态无法终止
     */
    COULD_NOT_STOP_OLD_STATE(500002),

    /**
     * 部队正在参与集结
     */
    BOAT_IS_ASSEMBLING(500003),

    /**
     * 未找到目标
     */
    NOT_FIND_TARGET(500004),

    /**
     * 目标是您的盟友
     */
    TARGET_IS_SAME_ALLIANCE(500005),

    /**
     * 超出指令范围
     */
    COMMAND_OUT_OF_RANGE(500006),

    /**
     * 未加入联盟
     */
    NOT_JOIN_ALLIANCE(500007),

    /**
     * 目标不是您的盟友
     */
    TARGET_IS_NOT_SAME_ALLIANCE(500008),

    /**
     * 体力不足
     */
    ARMY_COST_NOT_ENOUGH(500009),

    /**
     * 援助队伍成员数量已达上限
     */
    JOIN_ASSEMBLE_COUNT_REACH_CEILING(500010),

    /**
     * 无法加入集结
     */
    CANNOT_JOIN_ASSEMBLE(500011),

    /**
     * 无法攻击
     */
    CANNOT_ATTACK(500012),

    /**
     * 队伍不在主舰中
     */
    BOAT_NOT_IN_HOME_SHIP(500013),

    /**
     * 集结队伍已出发
     */
    ASSEMBLE_BOAT_IS_LEFT(500014),

    /**
     * 集结队伍数量未达最低要求，不可提前出发
     */
    ASSEMBLE_COUNT_NOT_ENOUGH(500015),

    /**
     * 当前集结目标不允许提前出发
     */
    ASSEMBLE_CONNOT_LEAVE_EARLY(500016),

    /**
     * 遣返时目标状态已发生改变
     */
    BOAT_STATE_CHANGED(500017),

    /**
     * 港口势力值奖励已经领取了
     */
    ALLIANCE_PORT_FORCE_REWARD_HAS_GOT(500018),

    /**
     * 港口势力值奖励未到最低的档位
     */
    ALLIANCE_PORT_FORCE_TOO_LOW(500019),

    /**
     * 执行任务的小队不能为空
     */
    BATTLE_LINE_UP_DATA_EMPTY(500020),

    /**
     * 未解锁该矿物解锁
     */
    EXPLOIT_THIS_MINE_LOCK(500021),

    /**
     * 是自己家的小船
     */
    SELF_BOAT(500022),

    /**
     * 参与同一只集结已达到数量上线
     */
    SAME_ASSEMBLE_COUNT_LIMIT(500023),

    /**
     * 不能放弃该港口，会造成不连通
     */
    COULD_NOT_GIVE_UP_THE_PORT_CAUSE_DISCONNECT(500024),

    /**
     * 还有其它港口，不能放弃主港
     */
    COULD_NOT_GIVE_UP_MAIN_PORT(500025),

    /**
     * 今日放弃港口数量达到上限
     */
    GIVE_UP_PORY_COUNT_LIMIT(500026),

    /**
     * 战争号角不足
     */
    FUEL_COST_NOT_ENOUGH(500027),

    /**
     * 大船正在战斗行军中
     */
    HOME_SHIP_IS_ON_THE_MARCH(500028),

    /**
     * mail rewardOverCapLogic：贸易品货舱已满
     */
    MAIL_REWARD_OVER_CAP_TRADEGOODS(500029),

    /**
     * mail rewardOverCapLogic：金币已达上限
     */
    MAIL_REWARD_OVER_CAP_GOLD(500030),

    /**
     * mail rewardOverCapLogic：木材已达上限
     */
    MAIL_REWARD_OVER_CAP_WOOD(500031),

    /**
     * mail rewardOverCapLogic：金属已达上限
     */
    MAIL_REWARD_OVER_CAP_FABRIC(500032),

    /**
     * mail rewardOverCapLogic：织物已达上限
     */
    MAIL_REWARD_OVER_CAP_METAL(500033),

    /**
     * 客户端参数错误，校验非法
     */
    ILLEGAL_PARAMETER(900001),

    /**
     * 冷却时间没到
     */
    COOLDOWN_TIME_IS_NOT_UP(900002),

    /**
     * 该国旗不能使用
     */
    FLAG_FORBID(900003),

    /**
     * {0} 加入了联盟
     */
    JOIN_ALLIANCE_TOAST(1000001),

    /**
     * 您被请离了联盟
     */
    KICK_MEMBER_TOAST(1000002),

    ;
    private int value;

    public static ErrorCode[] ARRAY = {
            SERVER_ERROR,
            PLATFORM_ID_OCCUPY,
            THIS_MAPPING_TYPE_IS_MAPPING,
            THIS_PLATFORM_ID_IS_MAPPING,
            MAPPING_CREATE_FAIL,
            SERVER_MANUAL_KICK,
            PLAYER_OTHER_DEVICE_LOGIN,
            LOGIN_FAIL_TEMP_BAN,
            LOGIN_FAIL_FOREVER_BAN,
            LOGIN_FAIL_ACCOUNT_DESTROY,
            LOGIN_FAIL_ACCOUNT_STATE_ERROR,
            TOKEN_INVALID,
            LOGIN_FAIL_REGION_NOT_OPEN,
            SINGLE_SERVER_ROLES_LIMIT,
            YOU_HAVE_ALREADY_USED_THIS_CDKEY,
            CDKEY_LOCK,
            CDKEY_INVALID,
            CDKEY_EXPIRED,
            CDKEY_DOES_NOT_EXIST,
            CDKEY_REWARD_FAIL,
            DRIFTING_TIME_NOT_YET_ARRIVED,
            BUILDING_COUNT_EXCEEDS_UPPER_LIMIT,
            BUILDING_POS_PLACE_REPEAT,
            BUILDING_DOES_NOT_EXIST,
            PRECONDITIONS_NOT_FULFILLED,
            NO_NEED_TO_CLICK,
            BUILDING_COST_NOT_ENOUGH,
            HERO_BUILDING_ERROR,
            STORAGE_FULL_TRANSPORT_ERROR,
            STORAGE_FULL_ERROR,
            MAIN_BUILDING_LEVEL_LIMIT,
            SEARCH_SHIP_LV_IS_MAX,
            SEARCH_SHIP_LV_UP_CONDITION_ERROR,
            SEARCH_SHIP_LV_UP_COST_NOT_ENOUGH,
            STORAGE_SIZE_MAX_MAKE_ERROR,
            MAKE_ITEM_LEVEL_UNLOCK,
            BUILDING_MOVE_ERROR,
            BUILDING_HIDDEN_ERROR,
            HERO_DO_NOT_EXIST,
            HERO_BUSY,
            HERO_LV_UP_QUALITY_NOT_ENOUGH,
            HERO_LV_UP_RANK_IS_HIGH,
            HERO_LV_UP_ITEM_NOT_ENOUGH,
            HERO_EXCLUSIVE_NO_EXIST,
            HERO_EXCLUSIVE_UNLOCK_CONDITION,
            HERO_EXCLUSIVE_UP_ITEM_NOT_ENOUGH,
            EQUIP_DO_NOT_EXIST,
            EQUIP_TYPE_NOT_MATCH,
            EQUIP_CANNOT_COST,
            EQUIP_LEVEL_UP_MAX,
            EQUIP_UP_ITEM_NOT_ENOUGH,
            EQUIP_RECOIN_ITEM_NOT_ENOUGH,
            EQUIP_ENHANCE_ITEM_NOT_ENOUGH,
            EQUIP_ENHANCE_NEED_RACE_BUFF,
            EQUIP_CANNOT_ENHANCE,
            HERO_IN_MARCH,
            HERO_IN_QUEUE,
            HERO_RESET_COST_NOT_ENOUGH,
            HERO_LV_UP_LIMITED_BY_TREND,
            ORACLE_STONE_LV_MAX,
            HERO_LV_MAX,
            QUEUE_HAS_ENDED,
            QUEUE_IN_PROGRESS,
            NO_FREE_QUEUE,
            TRAIN_QUEUE_IS_MAX,
            NAVY_IS_MAX_CANNOT_TRAIN,
            ITEM_NUM_NOT_ENOUGH,
            ITEM_CANNOT_USE,
            ITEM_NUM_CANNOT_USE,
            ITEM_USE_IN_CD,
            ITEM_EXPIRED,
            ITEM_USE_ONLY_ONE,
            QUICK_SUPPLY_COST_NOT_ENOUGH,
            USE_RESOURCE_ITME_FAIL_MAX,
            USE_RESOURCE_ITME_FAIL_CHANGE,
            NAME_IS_BAD_WORD,
            ALLIANCE_NAME_LEN_ERROR,
            ABBR_NAME_LEN_ERROR,
            ALLIANCE_NAME_HAS_EXIST,
            ABBR_HAS_EXIST,
            NAME_IS_NULL,
            INTRO_LEN_TOO_LONG,
            ANNOUNCE_LEN_TOO_LONG,
            ABBR_NAME_FORMAT_ERROR,
            JOIN_ALLIANCE_IN_CD,
            REPEAT_ALLIANCE_APPLY,
            ALLIANCE_SERVER_NOT_MATCH,
            ALLIANCE_IS_FULL,
            PLAYER_ALLIANCE_APPLY_FULL,
            ALLIANCE_APPLY_LIST_FULL,
            ALLIANCE_APPLY_POWER_LOW,
            ALLIANCE_APPLY_LEVEL_LOW,
            ALLIANCE_AUTHORITY_NOT_ENOUGH,
            ALLIANCE_CREATE_ITEM_NOT_ENOUGH,
            ANNOUNCE_LEN_ERROR,
            ALLIANCE_NAME_ITEM_NOT_ENOUGH,
            ALLIANCE_ABBR_ITEM_NOT_ENOUGH,
            ALLIANCE_ICON_ITEM_NOT_ENOUGH,
            ALLIANCE_DISBAND_HAS_OTEHRS,
            ALLIANCE_DISBAND_HAS_CITY,
            ALLIANCE_RANK_COUNT_MAX,
            HAS_JOIN_OTHER_ALLIANCE,
            NO_QUICK_JOIN_ALLIANCE,
            OFFICIAL_MUST_BE_R4,
            ALLIANCE_MEMBER_IS_MAX,
            PLAYER_HAS_JOIN_OTHER_ALLIANCE,
            PLAYER_HAS_NO_ALLIANCE,
            PLAYER_NOT_HAVE_ALLIANCE,
            ALLIANCE_HELP_QUEUE_IS_FINISH,
            ALLIANCE_HELP_IS_FINISH,
            ALLIANCE_HELP_QUEUE_TYPE_ERROR,
            SEEK_ALLIANCE_HELP_REPEAT,
            ALLIANCE_HELP_IS_NULL,
            QUEUE_REPEAT_HELP,
            ALLIANCE_HELP_IS_SELF,
            ALLIANCE_GIFT_IS_NULL,
            ALLIANCE_GIFT_IS_EXPIRED,
            ALLIANCE_EXIT_ERROR_STATIONING,
            ALLIANCE_EXIT_ERROR_ASSEMBLING,
            ALLIANCE_EXIT_ERROR_HELP_OTHERS,
            ALLIANCE_APPLY_CANCEL,
            ALLIANCE_INVITE_HANDLE_FAIL_MAIL_NULL,
            ALLIANCE_RANK_HAS_CHANGE,
            ALLIANCE_BOSS_TIME_CANT_DISBAND,
            ALLIANCE_BOSS_ATTACK_TIME_NOT_ENOUGH,
            SHIP_NAME_LEN_ERROR,
            BUY_SHIP_ITEM_NOT_ENOUGH,
            CHANGE_SHIP_ERROR,
            SHIP_DECORATE_COST_NOT_ENOUGH,
            SHIP_EQUIP_WEAR_ERROR,
            TRADE_SELL_NUM_NO_ENOUGH,
            TRADE_PRICE_CHANGE,
            PORT_STATION_POSTION_IS_FULL,
            PORT_STATION_POSTION_IS_FAR,
            TRADE_IS_ERROR,
            TRADE_WAREHOUSE_IS_FULL,
            TRADE_IS_USELESS,
            TRADE_ADVENTURE_LEVEL_NOT_ENOUGH,
            TRADE_CREDIBILITY_LEVEL_NOT_ENOUGH,
            STRIKE_PIRATE_UNLOCK_HERO_NUM_ERROR,
            STRIKE_PIRATE_UNLOCK_HERO_TYPE_ERROR,
            STRIKE_PIRATE_UNLOCK_HERO_QUALITY_ERROR,
            STRIKE_PIRATE_UNLOCK_HERO_MALE_ERROR,
            STRIKE_PIRATE_UNLOCK_COST_NOT_ENOUGH,
            STRIKE_PIRATE_BRANCH_LOCK,
            STRIKE_PIRATE_ENEMY_ERROR,
            STRIKE_PIRATE_QUICK_HANG_UP_COST_NOT_ENOUGH,
            TELEPORT_TEAM_OUT,
            TELEPORT_MAIN_SHIP_FIGHTING,
            TELEPORT_IN_FIRGHTING,
            TELEPORT_POS_ERROR,
            TECH_COST_NOT_ENOUGH,
            TECH_INSTANT_COST_NOT_ENOUGH,
            MAIL_ALREADY_COLLECT,
            MAIL_ALREADY_DELETE,
            ACTIVITY_CLOSE,
            TASK_NOT_FINISH,
            TASK_REWARDED,
            WORLD_FLAG_NOT_EXIST,
            WORLD_FLAG_CONFIG_NOT_EXIST,
            WORLD_FLAG_TYPE_ERROR,
            WORLD_FLAG_NUM_LIMIT,
            WORLD_FLAG_NAME_INCORRECT,
            WORLD_FLAG_NAME_TOO_LONG,
            WORD_LESS_BOOK_LV_LIMIT,
            WORD_LESS_BOOK_LV_UP_ENERGY_NOT_ENOUGH,
            WORD_LESS_BOOK_COLLECT_HERO_ID_NOT_EXIST,
            WORD_LESS_BOOK_LV_CONFIG_MISS,
            HAND_BOOK_AWARD_ALREADY_RECEIVED,
            ARTIFACT_NOT_ACTIVE,
            ARTIFACT_PHASE_MAX,
            ARTIFACT_PHASE_UP_COST_NOT_ENOUGH,
            VIP_DAILY_EXP_ALREADY_RECEIVED,
            VIP_LEVEL_NOT_ENOUGH,
            VIP_REWARD_TODAY_ALREADY_RECEIVED,
            GIFT_BUY_TIME_LIMIT,
            GIFT_BUY_CONDITION_NOT_ENOUGH,
            GET_TREND_AWARD_PARAM_ERROR,
            FUNCTION_CLOSE,
            BEGINNER_RAFT_FISHROD,
            BEGINNER_RAFT_PADDLE,
            NEWBIE_BATTLE_ALREADY_PASS,
            BOAT_MAIN_ASSEMBLING_SHIP_NOT_MOVE,
            COULD_NOT_STOP_OLD_STATE,
            BOAT_IS_ASSEMBLING,
            NOT_FIND_TARGET,
            TARGET_IS_SAME_ALLIANCE,
            COMMAND_OUT_OF_RANGE,
            NOT_JOIN_ALLIANCE,
            TARGET_IS_NOT_SAME_ALLIANCE,
            ARMY_COST_NOT_ENOUGH,
            JOIN_ASSEMBLE_COUNT_REACH_CEILING,
            CANNOT_JOIN_ASSEMBLE,
            CANNOT_ATTACK,
            BOAT_NOT_IN_HOME_SHIP,
            ASSEMBLE_BOAT_IS_LEFT,
            ASSEMBLE_COUNT_NOT_ENOUGH,
            ASSEMBLE_CONNOT_LEAVE_EARLY,
            BOAT_STATE_CHANGED,
            ALLIANCE_PORT_FORCE_REWARD_HAS_GOT,
            ALLIANCE_PORT_FORCE_TOO_LOW,
            BATTLE_LINE_UP_DATA_EMPTY,
            EXPLOIT_THIS_MINE_LOCK,
            SELF_BOAT,
            SAME_ASSEMBLE_COUNT_LIMIT,
            COULD_NOT_GIVE_UP_THE_PORT_CAUSE_DISCONNECT,
            COULD_NOT_GIVE_UP_MAIN_PORT,
            GIVE_UP_PORY_COUNT_LIMIT,
            FUEL_COST_NOT_ENOUGH,
            HOME_SHIP_IS_ON_THE_MARCH,
            MAIL_REWARD_OVER_CAP_TRADEGOODS,
            MAIL_REWARD_OVER_CAP_GOLD,
            MAIL_REWARD_OVER_CAP_WOOD,
            MAIL_REWARD_OVER_CAP_FABRIC,
            MAIL_REWARD_OVER_CAP_METAL,
            ILLEGAL_PARAMETER,
            COOLDOWN_TIME_IS_NOT_UP,
            FLAG_FORBID,
            JOIN_ALLIANCE_TOAST,
            KICK_MEMBER_TOAST
    };

    ErrorCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ErrorCode getType(int value) {
        return switch (value) {
            case 100000 -> SERVER_ERROR;
            case 100001 -> PLATFORM_ID_OCCUPY;
            case 100002 -> THIS_MAPPING_TYPE_IS_MAPPING;
            case 100003 -> THIS_PLATFORM_ID_IS_MAPPING;
            case 100004 -> MAPPING_CREATE_FAIL;
            case 100005 -> SERVER_MANUAL_KICK;
            case 100006 -> PLAYER_OTHER_DEVICE_LOGIN;
            case 100007 -> LOGIN_FAIL_TEMP_BAN;
            case 100008 -> LOGIN_FAIL_FOREVER_BAN;
            case 100009 -> LOGIN_FAIL_ACCOUNT_DESTROY;
            case 100010 -> LOGIN_FAIL_ACCOUNT_STATE_ERROR;
            case 100011 -> TOKEN_INVALID;
            case 100012 -> LOGIN_FAIL_REGION_NOT_OPEN;
            case 100013 -> SINGLE_SERVER_ROLES_LIMIT;
            case 100090 -> YOU_HAVE_ALREADY_USED_THIS_CDKEY;
            case 100091 -> CDKEY_LOCK;
            case 100092 -> CDKEY_INVALID;
            case 100093 -> CDKEY_EXPIRED;
            case 100094 -> CDKEY_DOES_NOT_EXIST;
            case 100095 -> CDKEY_REWARD_FAIL;
            case 100101 -> DRIFTING_TIME_NOT_YET_ARRIVED;
            case 100201 -> BUILDING_COUNT_EXCEEDS_UPPER_LIMIT;
            case 100202 -> BUILDING_POS_PLACE_REPEAT;
            case 100203 -> BUILDING_DOES_NOT_EXIST;
            case 100204 -> PRECONDITIONS_NOT_FULFILLED;
            case 100205 -> NO_NEED_TO_CLICK;
            case 100206 -> BUILDING_COST_NOT_ENOUGH;
            case 100207 -> HERO_BUILDING_ERROR;
            case 100208 -> STORAGE_FULL_TRANSPORT_ERROR;
            case 100209 -> STORAGE_FULL_ERROR;
            case 100210 -> MAIN_BUILDING_LEVEL_LIMIT;
            case 100211 -> SEARCH_SHIP_LV_IS_MAX;
            case 100213 -> SEARCH_SHIP_LV_UP_CONDITION_ERROR;
            case 100214 -> SEARCH_SHIP_LV_UP_COST_NOT_ENOUGH;
            case 100215 -> STORAGE_SIZE_MAX_MAKE_ERROR;
            case 100216 -> MAKE_ITEM_LEVEL_UNLOCK;
            case 100217 -> BUILDING_MOVE_ERROR;
            case 100218 -> BUILDING_HIDDEN_ERROR;
            case 100301 -> HERO_DO_NOT_EXIST;
            case 100302 -> HERO_BUSY;
            case 100303 -> HERO_LV_UP_QUALITY_NOT_ENOUGH;
            case 100304 -> HERO_LV_UP_RANK_IS_HIGH;
            case 100305 -> HERO_LV_UP_ITEM_NOT_ENOUGH;
            case 100306 -> HERO_EXCLUSIVE_NO_EXIST;
            case 100307 -> HERO_EXCLUSIVE_UNLOCK_CONDITION;
            case 100308 -> HERO_EXCLUSIVE_UP_ITEM_NOT_ENOUGH;
            case 100309 -> EQUIP_DO_NOT_EXIST;
            case 100310 -> EQUIP_TYPE_NOT_MATCH;
            case 100311 -> EQUIP_CANNOT_COST;
            case 100312 -> EQUIP_LEVEL_UP_MAX;
            case 100313 -> EQUIP_UP_ITEM_NOT_ENOUGH;
            case 100314 -> EQUIP_RECOIN_ITEM_NOT_ENOUGH;
            case 100315 -> EQUIP_ENHANCE_ITEM_NOT_ENOUGH;
            case 100316 -> EQUIP_ENHANCE_NEED_RACE_BUFF;
            case 100317 -> EQUIP_CANNOT_ENHANCE;
            case 100318 -> HERO_IN_MARCH;
            case 100319 -> HERO_IN_QUEUE;
            case 100320 -> HERO_RESET_COST_NOT_ENOUGH;
            case 100321 -> HERO_LV_UP_LIMITED_BY_TREND;
            case 100322 -> ORACLE_STONE_LV_MAX;
            case 100323 -> HERO_LV_MAX;
            case 100401 -> QUEUE_HAS_ENDED;
            case 100402 -> QUEUE_IN_PROGRESS;
            case 100403 -> NO_FREE_QUEUE;
            case 100404 -> TRAIN_QUEUE_IS_MAX;
            case 100405 -> NAVY_IS_MAX_CANNOT_TRAIN;
            case 100501 -> ITEM_NUM_NOT_ENOUGH;
            case 100502 -> ITEM_CANNOT_USE;
            case 100503 -> ITEM_NUM_CANNOT_USE;
            case 100504 -> ITEM_USE_IN_CD;
            case 100505 -> ITEM_EXPIRED;
            case 100506 -> ITEM_USE_ONLY_ONE;
            case 100507 -> QUICK_SUPPLY_COST_NOT_ENOUGH;
            case 100508 -> USE_RESOURCE_ITME_FAIL_MAX;
            case 100509 -> USE_RESOURCE_ITME_FAIL_CHANGE;
            case 100601 -> NAME_IS_BAD_WORD;
            case 100602 -> ALLIANCE_NAME_LEN_ERROR;
            case 100603 -> ABBR_NAME_LEN_ERROR;
            case 100604 -> ALLIANCE_NAME_HAS_EXIST;
            case 100605 -> ABBR_HAS_EXIST;
            case 100606 -> NAME_IS_NULL;
            case 100607 -> INTRO_LEN_TOO_LONG;
            case 100608 -> ANNOUNCE_LEN_TOO_LONG;
            case 100609 -> ABBR_NAME_FORMAT_ERROR;
            case 100610 -> JOIN_ALLIANCE_IN_CD;
            case 100611 -> REPEAT_ALLIANCE_APPLY;
            case 100612 -> ALLIANCE_SERVER_NOT_MATCH;
            case 100613 -> ALLIANCE_IS_FULL;
            case 100614 -> PLAYER_ALLIANCE_APPLY_FULL;
            case 100615 -> ALLIANCE_APPLY_LIST_FULL;
            case 100616 -> ALLIANCE_APPLY_POWER_LOW;
            case 100617 -> ALLIANCE_APPLY_LEVEL_LOW;
            case 100618 -> ALLIANCE_AUTHORITY_NOT_ENOUGH;
            case 100619 -> ALLIANCE_CREATE_ITEM_NOT_ENOUGH;
            case 100620 -> ANNOUNCE_LEN_ERROR;
            case 100621 -> ALLIANCE_NAME_ITEM_NOT_ENOUGH;
            case 100622 -> ALLIANCE_ABBR_ITEM_NOT_ENOUGH;
            case 100623 -> ALLIANCE_ICON_ITEM_NOT_ENOUGH;
            case 100624 -> ALLIANCE_DISBAND_HAS_OTEHRS;
            case 100625 -> ALLIANCE_DISBAND_HAS_CITY;
            case 100626 -> ALLIANCE_RANK_COUNT_MAX;
            case 100627 -> HAS_JOIN_OTHER_ALLIANCE;
            case 100628 -> NO_QUICK_JOIN_ALLIANCE;
            case 100629 -> OFFICIAL_MUST_BE_R4;
            case 100630 -> ALLIANCE_MEMBER_IS_MAX;
            case 100631 -> PLAYER_HAS_JOIN_OTHER_ALLIANCE;
            case 100632 -> PLAYER_HAS_NO_ALLIANCE;
            case 100633 -> PLAYER_NOT_HAVE_ALLIANCE;
            case 100634 -> ALLIANCE_HELP_QUEUE_IS_FINISH;
            case 100635 -> ALLIANCE_HELP_IS_FINISH;
            case 100636 -> ALLIANCE_HELP_QUEUE_TYPE_ERROR;
            case 100637 -> SEEK_ALLIANCE_HELP_REPEAT;
            case 100638 -> ALLIANCE_HELP_IS_NULL;
            case 100639 -> QUEUE_REPEAT_HELP;
            case 100640 -> ALLIANCE_HELP_IS_SELF;
            case 100641 -> ALLIANCE_GIFT_IS_NULL;
            case 100642 -> ALLIANCE_GIFT_IS_EXPIRED;
            case 100643 -> ALLIANCE_EXIT_ERROR_STATIONING;
            case 100644 -> ALLIANCE_EXIT_ERROR_ASSEMBLING;
            case 100645 -> ALLIANCE_EXIT_ERROR_HELP_OTHERS;
            case 100646 -> ALLIANCE_APPLY_CANCEL;
            case 100647 -> ALLIANCE_INVITE_HANDLE_FAIL_MAIL_NULL;
            case 100648 -> ALLIANCE_RANK_HAS_CHANGE;
            case 100649 -> ALLIANCE_BOSS_TIME_CANT_DISBAND;
            case 100650 -> ALLIANCE_BOSS_ATTACK_TIME_NOT_ENOUGH;
            case 100701 -> SHIP_NAME_LEN_ERROR;
            case 100702 -> BUY_SHIP_ITEM_NOT_ENOUGH;
            case 100703 -> CHANGE_SHIP_ERROR;
            case 100704 -> SHIP_DECORATE_COST_NOT_ENOUGH;
            case 100705 -> SHIP_EQUIP_WEAR_ERROR;
            case 100800 -> TRADE_SELL_NUM_NO_ENOUGH;
            case 100801 -> TRADE_PRICE_CHANGE;
            case 100802 -> PORT_STATION_POSTION_IS_FULL;
            case 100803 -> PORT_STATION_POSTION_IS_FAR;
            case 100804 -> TRADE_IS_ERROR;
            case 100805 -> TRADE_WAREHOUSE_IS_FULL;
            case 100806 -> TRADE_IS_USELESS;
            case 100807 -> TRADE_ADVENTURE_LEVEL_NOT_ENOUGH;
            case 100808 -> TRADE_CREDIBILITY_LEVEL_NOT_ENOUGH;
            case 100901 -> STRIKE_PIRATE_UNLOCK_HERO_NUM_ERROR;
            case 100902 -> STRIKE_PIRATE_UNLOCK_HERO_TYPE_ERROR;
            case 100903 -> STRIKE_PIRATE_UNLOCK_HERO_QUALITY_ERROR;
            case 100904 -> STRIKE_PIRATE_UNLOCK_HERO_MALE_ERROR;
            case 100905 -> STRIKE_PIRATE_UNLOCK_COST_NOT_ENOUGH;
            case 100906 -> STRIKE_PIRATE_BRANCH_LOCK;
            case 100907 -> STRIKE_PIRATE_ENEMY_ERROR;
            case 100908 -> STRIKE_PIRATE_QUICK_HANG_UP_COST_NOT_ENOUGH;
            case 101000 -> TELEPORT_TEAM_OUT;
            case 101001 -> TELEPORT_MAIN_SHIP_FIGHTING;
            case 101002 -> TELEPORT_IN_FIRGHTING;
            case 101003 -> TELEPORT_POS_ERROR;
            case 101101 -> TECH_COST_NOT_ENOUGH;
            case 101102 -> TECH_INSTANT_COST_NOT_ENOUGH;
            case 101201 -> MAIL_ALREADY_COLLECT;
            case 101202 -> MAIL_ALREADY_DELETE;
            case 101301 -> ACTIVITY_CLOSE;
            case 101401 -> TASK_NOT_FINISH;
            case 101402 -> TASK_REWARDED;
            case 200101 -> WORLD_FLAG_NOT_EXIST;
            case 200102 -> WORLD_FLAG_CONFIG_NOT_EXIST;
            case 200103 -> WORLD_FLAG_TYPE_ERROR;
            case 200104 -> WORLD_FLAG_NUM_LIMIT;
            case 200105 -> WORLD_FLAG_NAME_INCORRECT;
            case 200106 -> WORLD_FLAG_NAME_TOO_LONG;
            case 200201 -> WORD_LESS_BOOK_LV_LIMIT;
            case 200202 -> WORD_LESS_BOOK_LV_UP_ENERGY_NOT_ENOUGH;
            case 200203 -> WORD_LESS_BOOK_COLLECT_HERO_ID_NOT_EXIST;
            case 200204 -> WORD_LESS_BOOK_LV_CONFIG_MISS;
            case 200301 -> HAND_BOOK_AWARD_ALREADY_RECEIVED;
            case 200401 -> ARTIFACT_NOT_ACTIVE;
            case 200402 -> ARTIFACT_PHASE_MAX;
            case 200403 -> ARTIFACT_PHASE_UP_COST_NOT_ENOUGH;
            case 200601 -> VIP_DAILY_EXP_ALREADY_RECEIVED;
            case 200602 -> VIP_LEVEL_NOT_ENOUGH;
            case 200603 -> VIP_REWARD_TODAY_ALREADY_RECEIVED;
            case 200701 -> GIFT_BUY_TIME_LIMIT;
            case 200702 -> GIFT_BUY_CONDITION_NOT_ENOUGH;
            case 200801 -> GET_TREND_AWARD_PARAM_ERROR;
            case 200901 -> FUNCTION_CLOSE;
            case 300001 -> BEGINNER_RAFT_FISHROD;
            case 300002 -> BEGINNER_RAFT_PADDLE;
            case 300003 -> NEWBIE_BATTLE_ALREADY_PASS;
            case 500001 -> BOAT_MAIN_ASSEMBLING_SHIP_NOT_MOVE;
            case 500002 -> COULD_NOT_STOP_OLD_STATE;
            case 500003 -> BOAT_IS_ASSEMBLING;
            case 500004 -> NOT_FIND_TARGET;
            case 500005 -> TARGET_IS_SAME_ALLIANCE;
            case 500006 -> COMMAND_OUT_OF_RANGE;
            case 500007 -> NOT_JOIN_ALLIANCE;
            case 500008 -> TARGET_IS_NOT_SAME_ALLIANCE;
            case 500009 -> ARMY_COST_NOT_ENOUGH;
            case 500010 -> JOIN_ASSEMBLE_COUNT_REACH_CEILING;
            case 500011 -> CANNOT_JOIN_ASSEMBLE;
            case 500012 -> CANNOT_ATTACK;
            case 500013 -> BOAT_NOT_IN_HOME_SHIP;
            case 500014 -> ASSEMBLE_BOAT_IS_LEFT;
            case 500015 -> ASSEMBLE_COUNT_NOT_ENOUGH;
            case 500016 -> ASSEMBLE_CONNOT_LEAVE_EARLY;
            case 500017 -> BOAT_STATE_CHANGED;
            case 500018 -> ALLIANCE_PORT_FORCE_REWARD_HAS_GOT;
            case 500019 -> ALLIANCE_PORT_FORCE_TOO_LOW;
            case 500020 -> BATTLE_LINE_UP_DATA_EMPTY;
            case 500021 -> EXPLOIT_THIS_MINE_LOCK;
            case 500022 -> SELF_BOAT;
            case 500023 -> SAME_ASSEMBLE_COUNT_LIMIT;
            case 500024 -> COULD_NOT_GIVE_UP_THE_PORT_CAUSE_DISCONNECT;
            case 500025 -> COULD_NOT_GIVE_UP_MAIN_PORT;
            case 500026 -> GIVE_UP_PORY_COUNT_LIMIT;
            case 500027 -> FUEL_COST_NOT_ENOUGH;
            case 500028 -> HOME_SHIP_IS_ON_THE_MARCH;
            case 500029 -> MAIL_REWARD_OVER_CAP_TRADEGOODS;
            case 500030 -> MAIL_REWARD_OVER_CAP_GOLD;
            case 500031 -> MAIL_REWARD_OVER_CAP_WOOD;
            case 500032 -> MAIL_REWARD_OVER_CAP_FABRIC;
            case 500033 -> MAIL_REWARD_OVER_CAP_METAL;
            case 900001 -> ILLEGAL_PARAMETER;
            case 900002 -> COOLDOWN_TIME_IS_NOT_UP;
            case 900003 -> FLAG_FORBID;
            case 1000001 -> JOIN_ALLIANCE_TOAST;
            case 1000002 -> KICK_MEMBER_TOAST;
            default -> {
                LogUtils.logger.error("ErrorCode is not find value:{}",value);
                yield null;
            }
        };
    }
}
