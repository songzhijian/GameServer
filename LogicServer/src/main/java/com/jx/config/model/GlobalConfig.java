package com.jx.config.model;

import com.jx.config.loader.GlobalConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Global.xml
*/
public class GlobalConfig extends AbstractConfig implements IConfig {

    /**无意义的Tursh专用版本号标记*/
    public static int VersionMark;
    /**玩家初始财产*/
    public static int[][] Init_Player_Property;
    /**战场中，虚拟网格，我方站的位置（废弃）*/
    public static int[][] BattleGridSelfCoor;
    /**战场中，虚拟网格，敌方站的位置（废弃）*/
    public static int[][] BattleGridEnemyCoor;
    /**刷新间隔*/
    public static int[] DriftRefreshRange;
    /**水域范围中心点(cm)*/
    public static int[] DriftWaterCenter;
    /**水域范围(cm)*/
    public static int[] DriftWaterRange;
    /**新垃圾刷新中心点(cm)*/
    public static int[] DriftRefreshCenter;
    /**新垃圾刷新范围(cm)*/
    public static int[] DriftRefreshArea;
    /**垃圾漂流方向*/
    public static int[] DrifterRotation;
    /**钩子投掷最短距离(cm)*/
    public static int HookDisMin;
    /**钩子投掷最长距离(cm)*/
    public static int HookDisMax;
    /**钩子移动速度(cm)*/
    public static int HookMoveSpeed;
    /**镜头平移速度*/
    public static int DriftCameraSpeed;
    /**镜头平移范围*/
    public static int[] DriftCameraRangeX;
    /**镜头俯仰范围*/
    public static int[] DriftCameraRangeY;
    /**出手高度（cm）*/
    public static int HookHeight;
    /**出手初速度(cm/s)*/
    public static int[] ThrowSpeed;
    /**蓄力最大时长(毫秒)*/
    public static int ThrowTimeMax;
    /**捡垃圾主角移动速度(cm/s)*/
    public static int DriftMoveSpeed;
    /**钩子最长等待时间（毫秒）*/
    public static int HookHoldTime;
    /**天气影响正向(天气速度*参数1)，正向+1（天气速度*参数2）…….正向+5，顺时针012345*/
    public static float[] weatherEffect;
    /**木筏玩法饥饿度上限*/
    public static int RaftHungerMax;
    /**木筏玩法饥饿度衰减速度（单位毫秒），每隔这个时间，减1*/
    public static int RaftHungerDecey;
    /**木筏初始饥饿度*/
    public static int RaftInitialDecey;
    /**垃圾吸附至钩子的速度，单位cm/s*/
    public static int DriftAdsorbSpeed;
    /**木筏建设面积上限*/
    public static int[] RaftAreaMax;
    /**木筏建设时的工人奔跑移动速度，单位cm/s*/
    public static int RaftRunSpeed;
    /**木筏玩法中，制作道具所需的时长，单位ms*/
    public static int RaftHandworkTime;
    /**钓鱼等待时长随机范围，单位毫秒*/
    public static int[] FishingWaitTime;
    /**钓鱼响应时长，单位毫秒*/
    public static int FishingRespondTime;
    /**道具使用默认CD，单位毫秒*/
    public static int ItemUseCD;
    /**章节任务列表*/
    public static int[] ChapterList;
    /**每字符时长（中文），单位毫秒*/
    public static int MovieCharInterval;
    /**钓鱼成功提供鱼类ID*/
    public static int FishItemID;
    /**木筏建设中，资源不足的Toast提示文字*/
    public static int RaftNeedResNote;
    /**木筏物品制作中，资源不足的Toast提示文字*/
    public static int FormulaNeedResNote;
    /**鱼钩距离，单位厘米*/
    public static int HookDistance;
    /**投掷钩索位置在甲板上的错误提示*/
    public static int HookThrowNote;
    /**抛钓竿，位置在甲板上的错误提示*/
    public static int FishThrowNote;
    /**无法建造更多的提示*/
    public static int NoMoreBuildNote;
    /**无法同时建造的提示*/
    public static int SameTimeBuildNote;
    /**镜头平移范围（cm）*/
    public static int[] RaftCameraMoveRange;
    /**完成标志文字*/
    public static int FinishFlagWord;
    /**每日任务标题文字*/
    public static int DailyTaskWord;
    /**移动建筑所需的长按时间，单位毫秒*/
    public static int ConstMovePressDur;
    /**临时用的港口售卖船只列表，格式：船只ID,折扣万分比*/
    public static int[][] PortShipListTemp;
    /**命名船只的字数限制*/
    public static int[] ShipNameLimit;
    /**起身时的饥饿度回复量*/
    public static int RaftHungerRefill;
    /**饥饿度降为0时的资源剩余比例，千分比（注意是剩余比例，不是扣去比例）*/
    public static int RaftHungerPenalty;
    /**出现屏幕提示的饥饿度值*/
    public static int RaftHungerWarningValue;
    /**饥饿昏迷持续时间*/
    public static int RaftHungerStunTime;
    /**钻石直充的PurchaseID列表*/
    public static int[] GemPurchaseID;
    /**招募点直充的PurchaseID列表*/
    public static int[] RecruitPointPurchaseID;
    /**每日领取的VIP经验*/
    public static int[] VipDailyExpClaim;
    /**每日领取VIP经验累计天数回退值*/
    public static int VipDaysBackspace;
    /**月卡持续天数*/
    public static int MonthlyCardDura;
    /**月卡不可购买剩余天数*/
    public static int MonthlyCardMaxDura;
    /**小月卡PurchaseID*/
    public static int MonthlyCardID_1;
    /**大月卡PurchaseID*/
    public static int MonthlyCardID_2;
    /**小月卡每日奖励PurchaseID*/
    public static int MonthlyCardRewardID_1;
    /**大月卡每日奖励PurchaseID*/
    public static int MonthlyCardRewardID_2;
    /**每日礼包的每日免费奖励内容*/
    public static int[][] DailyBounsFreeReward;
    /**每日礼包的大小礼包关联*/
    public static int[][] DailyGiftPack_Association;
    /**每日礼包的每日免费奖励内容*/
    public static int[][] DailyGiftPack_Free;
    /**战斗中可以禁止释放技能[包括，普攻/必杀/技能]的buff效果组【103 = 晕眩】【115 = 冰冻】【107 = 放逐】*/
    public static int[] BattleActionForbiddenBuff;
    /**战斗中可以禁止释放必杀的buff效果组【108 = 沉默】*/
    public static int[] BattleUltraForbiddenBuff;
    /**战斗中霸体可以免疫控制的buff效果组：【103 = 晕眩】【107 = 放逐】【108=沉默】【115 = 冰冻】【21=击退】【22=撞飞】*/
    public static int[] BattleImmuneControlBuff;
    /**战斗中基础暴击常量=5=默认就有5%的暴击率*/
    public static int Battle_Init_Crit;
    /**战斗中增伤减伤公式的分母=100=每1点效果是百分之1*/
    public static int Battle_Init_Dmg_Rate;
    /**攻速的基准值=200=每1点加速0.5%*/
    public static int Battle_Init_AtkSpd;
    /**CD减少的基准值=200=每1点加速0.5%*/
    public static int Battle_Init_CDReduce;
    /**移速的基准值=200=每1点加速0.5%*/
    public static int Battle_Init_Mov;
    /**暴击的基准值=200=默认暴击伤害=200%*/
    public static int Battle_Init_CritDmg;
    /**攻击怒气回复速度的基准值=100=每增加1点增加1%效果*/
    public static int Battle_Init_Atk_Power_Param;
    /**受击怒气回复速度的基准值=100=每增加1点增加1%效果*/
    public static int Battle_Init_Behit_Power_Param;
    /**生命恢复效果加成的基准值=100=每增加1点增加1%效果*/
    public static int Battle_Init_RecoverUp_Param;
    /**治疗效果提升的基准值=100=每增加1点增加1%效果*/
    public static int Battle_Init_HealUp_Param;
    /**相克额外系数A【打被自己克制的敌人】的基准值=25=增加25%伤害*/
    public static int Battle_Init_Race_Param_A;
    /**战斗中基础闪避概率=0.05=5%的闪避*/
    public static float Battle_Init_Dodge_Rate;
    /**战斗中闪避公式的常量=全红满星装备的敏职业 被 全红满星装备的力职业 打】 差值=135 的时候达成50%闪避的效果*/
    public static int Battle_Dodge_Formula_Param;
    /**战斗中闪避率计算结果的阈值范围=0.95=闪避率的阈值区间=[0,0.95]=闪避率不会超过95%*/
    public static float Battle_Dodge_Rate_Threshold;
    /**战斗中，伤害公式的常量系数1=1=杀伤力分子A的作用数*/
    public static float Battle_Dmg_Formula_Param_1;
    /**战斗中，伤害公式的常量系数2=1=杀伤力分子B的作用数*/
    public static float Battle_Dmg_Formula_Param_2;
    /**战斗中，伤害公式的常量系数3=1=杀伤力分母A的作用数*/
    public static float Battle_Dmg_Formula_Param_3;
    /**战斗中，伤害公式的常量系数4=防御力分母B的作用数=5=防御力在计算的时候是5倍攻击力的效果*/
    public static float Battle_Dmg_Formula_Param_4;
    /**种族相克系数阈值=[0,3.00]=种族相克最多能打出300%伤害，最少能打出0%伤害*/
    public static float[] Battle_Race_Dmg_Threshold;
    /**等级压制-玩家高增伤/级=0.02=每级增加2%伤害*/
    public static float Battle_Level_Suppress_Param_1;
    /**等级压制-玩家高减伤/级*/
    public static float Battle_Level_Suppress_Param_2;
    /**等级压制-玩家低造伤减/级*/
    public static float Battle_Level_Suppress_Param_3;
    /**等级压制-玩家低受伤增/级*/
    public static float Battle_Level_Suppress_Param_4;
    /**吸血参数=100=每1点吸血，吸血1%*/
    public static int Battle_Vampire_Param;
    /**击杀-怒气回复=200，击杀一个非召唤单位增加200怒气*/
    public static int Battle_Kill_Power_Bonus;
    /**战斗中 生命越多伤害越高 的设定参数*/
    public static float BattleMoreTargetHpMoreDmgParam;
    /**战斗中 受伤越多伤害越高 的设定参数*/
    public static float BattleMoreTargetHurtMoreDmgParam;
    /**战斗中 自身生命越多伤害越高 的设定参数*/
    public static float BattleMoreSelfHpMoreDmgParam;
    /**战斗中 自身受伤越多伤害越高 的设定参数*/
    public static float BattleMoreSelfHurtMoreDmgParam;
    /**战斗中 血量越少治疗越强 的设定参数*/
    public static float BattleLessSelfHpMoreHealParam;
    /**战斗中 每秒移动几个格子*/
    public static float Battle_Init_Mov_Spd;
    /**战斗中 伤害公式的攻击值兵力k系数*/
    public static float Battle_DMG_Formula_NavyNum_Param;
    /**玩法护盾系数【世界】=0.36*/
    public static float Battle_Shield_Formula_World_Param;
    /**玩法治疗系数【世界】=0.33*/
    public static float Battle_Heal_Formula_World_Param;
    /**总战力：后备英雄战力系数K1*/
    public static float Power_StandbyHero_Param;
    /**总战力：后备士兵战力系数K2*/
    public static float Power_StandbyNavy_Param;
    /**多抽次数*/
    public static int Gacha_Many;
    /**非紫卡次数*/
    public static int Gacha_No_Purple_Times;
    /**阵营不重复次数*/
    public static int Gacha_Camp_No_Repeat_Times;
    /**英雄不重复次数*/
    public static int Gacha_Hero_No_Repeat_Times;
    /**心愿兑换次数*/
    public static int Gacha_Wish_Num;
    /**普通抽奖池id*/
    public static int[] Gacha_Common_Pool_id;
    /**心愿兑换的英雄品质（紫=5）*/
    public static int Gacha_Wish_ExchangeQuality;
    /**抽卡中，阵营抽，改变阵营的消耗*/
    public static int[][] GachaChangeCampCost;
    /**前n次抽卡，不可跳过动画*/
    public static int Gacha_NoSkip_Times;
    /**基础值-挂机奖励时间上限（秒）*/
    public static int Strike_Pirate_HangUp_Time;
    /**推图快速挂机默认次数*/
    public static int HangUpQuickSupply;
    /**推图玩法分支关卡重置标记（玩家登陆时标记不同则触发分支重置）*/
    public static int StrikePirateBranchResetFlag;
    /**秘境难度匹配修正1，每次跨战力区间数【排名区间上限，跨id数】*/
    public static int[][] MazeDifficultyConvergenceFactor;
    /**秘境难度匹配修正2，根据排名修正属性，参数a1(基准属性）【a1*max((1-排名/a2),0)】*/
    public static int[][] MazeAttributeCorrectA1;
    /**秘境难度匹配修正2，根据排名修正属性，参数a2(排名限制）【a1*max((1-排名/a2),0)】*/
    public static int MazeAttributeCorrectA2;
    /**秘境，每次挑战消耗的挑战次数*/
    public static int MazeChallengeConsumption;
    /**秘境，挑战次数重置间隔时间*/
    public static int MazeResetTime;
    /**秘境，重置时间的起始日期*/
    public static String MazeResetStartDate;
    /**秘境，挑战次数上限*/
    public static int MazeChallengeLimit;
    /**单体英雄恢复万分比*/
    public static int SingleHeroRecovery;
    /**全体英雄恢复万分比*/
    public static int AllHeroRecovery;
    /**复活英雄恢复万分比*/
    public static int ResurrectHeroRecovery;
    /**秘境，复活币使用消耗（主动恢复）*/
    public static int[][] ResurrectionCoinConsume1;
    /**秘境，复活币使用消耗（重新开始）*/
    public static int[][] ResurrectionCoinConsume2;
    /**秘境，招募节点英雄最低初始品质*/
    public static int MazeHeroLowestQuality;
    /**初始队伍个数*/
    public static int Team_Init_Num;
    /**初始部队人数*/
    public static int[][] Team_Init_Troops_Num;
    /**英雄重印页签的解锁方条件【资质=？】*/
    public static int Hero_Reprint_Unlock_Condition;
    /**装备随机种族标签的权重*/
    public static int[] Equip_Random_Race_Buff_P;
    /**装备强化的低级道具id和他的经验值*/
    public static int[] Equip_Strengthen_Cost_And_Exp_Low;
    /**装备强化的高级道具id和他的经验值*/
    public static int[] Equip_Strengthen_Cost_And_Exp_High;
    /**装备强化星级每一星带来的基础属性【0.1=10%的属性】*/
    public static float EquipStrengthenAttParam;
    /**装备种族标签带来的基础属性【0.3=30%的属性】*/
    public static float EquipRaceBuffAttParam;
    /**装备洗炼的适配英雄的等级条件*/
    public static int EquipRaceBuffHeroListLimit;
    /**装备洗炼的适配英雄的个数条件*/
    public static int EquipRaceBuffHeroCountLimit;
    /**英雄专属页签的解锁方条件【资质=？】*/
    public static int Hero_Exclusive_Unlock_Condition;
    /**临时英雄持有上限*/
    public static int Temp_Hero_Count_Limit;
    /**英雄养成-等级提升-Rank检测-相差*/
    public static int Hero_Rank_Distance;
    /**英雄养成-等级提升-Rank检测-前几名英雄*/
    public static int Hero_Rank_Check_Count;
    /**装备洗炼的消耗*/
    public static int[][] Equip_Recoin_Cost;
    /**英雄天赋【下四族-1个天赋的刷新单价】*/
    public static int[] Hero_Talent_Refresh_Cost_Low_Race;
    /**英雄天赋【上三族-1个天赋的刷新单价】*/
    public static int[] Hero_Talent_Refresh_Cost_High_Race;
    /**邮件过期时间*/
    public static int MailOverTime;
    /**有奖励没有领取的邮件过期时间*/
    public static int MailOverTimeMax;
    /**每日刷新时间*/
    public static int DailyRefresh;
    /**首次绑定IM30邮箱奖励*/
    public static int[][] FirstBindingEmailReward;
    /**最多储存账号数量*/
    public static int MaximumStoredAccounts;
    /**单服单账号下角色数量限制*/
    public static int RoleNumOneServer;
    /**勘察次数上限*/
    public static int ExploreMaxCount;
    /**勘察次数回复间隔，单位秒*/
    public static int ExploreCountRecoverRate;
    /**搜寻船产出资源时间间隔-《Search_Room_Output》output配置值对应的时间（秒）*/
    public static int Searchship_Production_Interval;
    /**搜寻船资源发奖时间间隔-实际可领取资源的时间（秒）*/
    public static int Searchship_Reward_Interval;
    /**账号删除申请有效期(单位：天)*/
    public static int[] Account_Deletion_Validity_Period;
    /**创建联盟的消耗,*/
    public static int[][] AllianceCreateCost;
    /**首次加入联盟时的奖励*/
    public static int[][] AllianceFirstJoinReward;
    /**联盟全称的上下限长度 [lowerLimit, upperLimit]*/
    public static int[] AllianceFullNameLimit;
    /**联盟简称的上下限长度 [lowerLimit, upperLimit]*/
    public static int[] AllianceShortNameLimit;
    /**联盟宣言的字数限制upperLimit*/
    public static int AllianceDeclarationLimit;
    /**联盟公告的字数限制upperLimit*/
    public static int AllianceAnnouncementLimit;
    /**世界招募的字数限制upperLimit*/
    public static int AllianceWorldRecruitmentLimit;
    /**联盟推荐列表数量*/
    public static int AllianceRecommendAllianceListCount;
    /**活跃定义的近X天上线的天数 【3】*/
    public static int AllianceActivePlayerDay;
    /**活跃联盟人数定义，近3天登录人数的数值  【20】*/
    public static int AllianceActivePlayerNum;
    /**剩余可加入成员数量，以20人为分界线，随机加入，大于20人的联盟 > 小于等于20人的联盟 【20】*/
    public static int AllianceFastJoinMember;
    /**入盟要求，战力范围 [lowerLimit, upperLimit]*/
    public static int[] AllianceRequirementPowerRange;
    /**入盟要求，船长等级范围 [lowerLimit, upperLimit]*/
    public static int[] AllianceRequirementCaptainLvRange;
    /**联盟搜索最大展示数量*/
    public static int AllianceSearchAllianceResultLimit;
    /**联盟申请的有效期，超过则申请无效，单位秒*/
    public static int AllianceApplyEffectiveTime;
    /**最多可同时申请的联盟的数量*/
    public static int AlliancePlayerApplyLimit;
    /**联盟的申请列表的上限*/
    public static int AllianceApplyListLimit;
    /**修改联盟全称的消耗*/
    public static int[][] AllianceChangeFullNameCost;
    /**修改联盟简称的消耗*/
    public static int[][] AllianceChangeShortNameCost;
    /**修改联盟旗帜的消耗*/
    public static int[][] AllianceChangeFlagCost;
    /**联盟初始人数*/
    public static int AllianceDefaultMembers;
    /**联盟人数上限*/
    public static int AllianceMaxMembers;
    /**联盟R4人数基础值，R4人数进阶值*/
    public static int AllianceR4CountBase;
    /**R4Count = R4CountBase + (当前联盟人数 - Alliance_DefaultMembers)/Alliance_R4CountStep*/
    public static int AllianceR4CountStep;
    /**联盟R3人数基础比例，R3Count  = int(当前联盟人数 * Alliance_R3CountRatio/10000)*/
    public static int AllianceR3CountRatio;
    /**联盟R2人数基础比例，R2Count  = int(当前联盟人数 * Alliance_R2CountRatio/10000)*/
    public static int AllianceR2CountRatio;
    /**联盟推荐/搜索展示玩家列表数量*/
    public static int AllianceRecommendPlayerListCount;
    /**搜索玩家列表数量*/
    public static int AllianceSearchPlayerResultListCount;
    /**联盟官员人数上限[外交官Diplomat ，战神Battlemaster ，招募官Recruiter ，督军Warlord]*/
    public static int[] AllianceOfficialCount;
    /**刷新联盟推荐玩家的冷却时间（秒）*/
    public static int AllianceRecommendPlayerRefreshCD;
    /**联盟邀请搜索玩家姓名长度限制*/
    public static int[] AllianceSearchPlayerLength;
    /**联盟排行榜*/
    public static int[] AllianceRank;
    /**联盟采集排行榜积分比*/
    public static int[][] AllianceGatherRankRatio;
    /**联盟BOSS积分id*/
    public static int AllianceBossPoint;
    /**联盟BOSS生成单次随机格子数，单次生成搜索多少个地格*/
    public static int AllianceBossGenerateSearchNum;
    /**联盟BOSS生成随机间隔(单位秒)，用于生成失败后过多久再次搜寻符合条件的地格*/
    public static int AllianceBossGenerateSearchPeriod;
    /**联盟讨伐小怪检测间隔，单位秒*/
    public static int AllianceMonsterGeneratePeriod;
    /**联盟讨伐小怪补齐阈值，当检测时发现小怪数量少于本数值时才进行补充，补充至本海域上限*/
    public static int AllianceMonsterSupplyThreshold;
    /**单赛季联盟BOSS等级上限[[赛季id，上限][赛季id，上限]]，包含本等级*/
    public static int[][] AllianceBossSeasonLevelLimit;
    /**讨伐联盟BOSS消耗体力*/
    public static int AllianceBossCostPower;
    /**讨伐联盟小怪消耗体力*/
    public static int AllianceMonsterCostPower;
    /**小船的基础速度，X格/秒*/
    public static float WorldBoatBaseSpeed;
    /**小船立即返回的消耗*/
    public static int[][] WorldBoatImmediatelyReturnCost;
    /**世界怪物刷新CD，单位秒，怪物是每次刷新一定比例*/
    public static int WorldMonsterRefreshTime;
    /**世界怪物刷新CD，单位秒，资源是每次刷新一定比例*/
    public static int WorldResourceRefreshTime;
    /**每次刷新资源点时，刷新的比例上限，万分比，= WorldResourceRefreshRate * World_Port.resourceNum*/
    public static int WorldResourceRefreshRate;
    /**每次刷怪物时，刷新的比例上限，万分比，= WorldMonsterRefreshRate * World_Port.monsterNum*/
    public static int WorldMonsterRefreshRate;
    /**指令范围基础值，格数*/
    public static int BaseCommandRange;
    /**追击范围基础值，格数，由于追击导致小船超过这个范围，会执行返回行为*/
    public static int BaseChasingRange;
    /**攻城燃油恢复间隔时间，单位秒*/
    public static int FuelRecoveryInterval;
    /**攻城燃油的上限，个*/
    public static int FuelLimit;
    /**占领港口后，杀敌前三名的联盟战功[第一，第二，第三]*/
    public static int[][] WorldPortMilitaryKill;
    /**占领港口后，破坏前三名的联盟战功[第一，第二，第三]*/
    public static int[][] WorldPortMilitaryDestroy;
    /**世界表演机器人的数量*/
    public static int WorldRobotCount;
    /**战利品的持续时间，秒*/
    public static int PirateTrophyDuration;
    /**战利品的交互距离，格*/
    public static int PirateTrophyInteractionDistance;
    /**母船城防恢复时间基础值（恢复1点所需时间，单位秒）*/
    public static int MainShipDurabilityRecoveryInterval;
    /**冒烟持续时间*/
    public static int PvpSmokeTime;
    /**着火持续时间*/
    public static int PvpIgniteTime;
    /**冒烟城防减少系数，万分比*/
    public static int PvpSmokeDestructionRatio;
    /**战斗基础持续时间，无论多少回合的战斗，都要至少表演这么多时间，单位秒*/
    public static int WorldBattleBasePerformanceTime;
    /**搜索功能一次返回的最大数量（前端连续搜索时，在这几个目标中切换，避免频繁发送消息）*/
    public static int WorldMaxSearchResult;
    /**抢劫采集点的时候，抢夺的比例基础值，万分比*/
    public static int ResourceRobRateBase;
    /**搜索功能范围，格数*/
    public static int SearchRange;
    /**PVE集结可选的集结时间，单位秒*/
    public static int[] PveAssembleTime;
    /**PVP集结可选的集结时间，单位秒*/
    public static int[] PvpAssembleTime;
    /**集结所需最小人数*/
    public static int MinAssembleMember;
    /**每日集结野怪boss的奖励次数*/
    public static int AssembleBossRewardTime;
    /**每日集结高级野怪boss的奖励次数*/
    public static int AssembleAdvancedBossRewardTime;
    /**援助玩家的最小人数，剩下受到房间等级加成*/
    public static int MinGarrisonMember;
    /**打小怪消耗【耐久】，world_monster.Type = 1*/
    public static int MarchCost_Monster;
    /**打BOSS消耗【耐久】，world_monster.Type = 2*/
    public static int MarchCost_Boss;
    /**打港口消耗【燃油】*/
    public static int MarchCost_Port;
    /**采集消耗【耐久】*/
    public static int MarchCost_Gather;
    /**驻守/援助消耗【耐久】*/
    public static int MarchCost_Garrison;
    /**攻击他人大船，消耗【耐久】*/
    public static int MarchCost_Pvp;
    /**小船耐久恢复速度，多少秒恢复1点，正式配置为300*/
    public static int BoatPowerRecoveryTime;
    /**小船耐久度上限*/
    public static int MaxBoatPower;
    /**轻伤=Injured，重伤=Hurt，死亡=Death
Pvp时，轻伤兵占所有伤兵的比例，万分比，Injured/(Injured+Hurt+Death)，剩下的为重伤和死亡*/
    public static int PvpInjuredRate;
    /**Pvp时，攻击方，重伤兵中直接死亡的比例，万分比。Death/(Hurt+Death)*/
    public static int PvpAttackerHurtToDeathRate;
    /**Pvp时，防守方，重伤兵中直接死亡的比例，万分比。Death/(Hurt+Death)，剩下的进医院，医院装不下再死*/
    public static int PvpDefenderHurtToDeathRate;
    /**打城时，不同级别城市战斗的轻伤比例，万分比，Injured/(Injured+Hurt+Death)，剩下的为重伤和死亡*/
    public static int[][] CityAttackerInjuredRate;
    /**打城时，不同级别城市战斗的重伤转死亡比例，万分比，Death/(Hurt+Death)的比例，剩下的为轻伤*/
    public static int[][] CityAttackerHurtToDeathRate;
    /**贤者之石的能量上限*/
    public static int OracleStonePowerLimit;
    /**有货时，航速降低，万分比*/
    public static int TradeMotherShipSpeedDown;
    /**满仓时，航速降低，万分比*/
    public static int TradeMaxGoodsMotherShipSpeedDown;
    /**交易中，基准税率-进货，万分比*/
    public static int TradeBaseTaxBuy;
    /**交易中，基准税率-出货，万分比*/
    public static int TradeBaseTaxSell;
    /**贸易港口长时间无人访问后，首次访问最大波动计算补偿时间，单位：分钟。在该时间内，有多少次周期变化，则计算多少次。超过该时间，只在可能发生趋势变动的区间内随机取一个区间和趋势方向同时只会计算一次波动*/
    public static int TradeMaxTrendRetrieveTime;
    /**交易趋势刷新时间，分钟 30*/
    public static int TradeTrendRefreshTime;
    /**交易货物刷新时间，分钟 60*/
    public static int TradeGoodsRefreshTime;
    /**每日贸易额度基础值，1点贸易额度可以购买一份贸易品*/
    public static int TradeDailyLimtBase;
    /**贸易品保护数量基础值*/
    public static int TradeGoodsProtectBase;
    /**贸易品抢劫比例基础值，超过TradeGoodsProtect的部分的比例，万分比*/
    public static int TradeGoodsRobRateBase;
    /**星级物品的买卖价格加成系数[star0,star1,….star10]，万分比*/
    public static int[] TradeGoodsStarMultipier;
    /**商圈信用度获得值，在任意商圈购买、出售，都可获得经验。[购买份商品获得exp，出售一份商品获得exp]*/
    public static int[] TradeCredibilityExp;
    /**贸易所需货币资源的id*/
    public static int TradeResource;
    /**船舱空间的上限，临时*/
    public static int TradeCabinSpaceLimit;
    /**交易导致的航速降低，贸易品数量每达到船舱空间的5%，降低1%，作用号为【6004】*/
    public static int[] TradeSpeedReduction;
    /**贸易最终购买税率范围*/
    public static int[] TradeBuyTaxLimit;
    /**贸易最终出售税率范围*/
    public static int[] TradeSellTaxLimit;
    /**不收波动影响的货物ID列表*/
    public static int[] TradeGoodsNotvolatileList;
    /**钻石的加速价值判断值【秒=60=1钻加速60秒】*/
    public static int DiamondSpeedUpTimeLogic;
    /**金币的价值判断值【1钻={X}金币】*/
    public static int GoldValueLogic;
    /**木材的价值判断值【1钻={X}木材】*/
    public static int LumberValueLogic;
    /**织物的价值判断值【1钻={X}织物】*/
    public static int FabricValueLogic;
    /**金属的价值判断值【1钻={X}金属】*/
    public static int SteelValueLogic;
    /**方晶的价值判断值【1钻={X}方晶】*/
    public static int CrystalCubeValueLogic;
    /**房间升级-立即完成可直接减少的基础时间（单位：秒）*/
    public static int DiamondCompleteReduceTime;
    /**根据交易品id，在基础供货量的 80%-120%范围内进行随机刷新, 【随机下限，随机上限】，万分比*/
    public static int[] TradePortStockRefresLimit;
    /**进入港口的驻港提示最远距离，格子*/
    public static int WorldPortEntryNotifyRange;
    /**母舰中资源的保护数量的基础值[[资源1,数量],[资源2,数量],[资源3,数量]...]*/
    public static int[][] ShipResourceProtectBase;
    /**新手副本开启*/
    public static boolean NewPlayerDungeonOpen;
    /**治疗伤兵，单队列上限【同时也是 厨房和制药的队列上限】*/
    public static int HealNavyQueueLimit;
    /**英雄绿将的遣散奖励*/
    public static int[][] HeroLayOffReward;
    /**自动遣散的条件（<=该品质）*/
    public static int HeroAutoLayOffQuality;
    /**无字之书，英雄等级上限提升图标*/
    public static String WordlessBookHeroLvIcon;
    /**遣散商店ID*/
    public static int CoinDisbandShop;
    /**竞技场挑战消耗*/
    public static int[][] ArenaChallengeCost;
    /**竞技场玩家初始积分*/
    public static int ArenaInitialScore;
    /**竞技场每天免费刷新对手次数*/
    public static int ArenaFreeRefresh;
    /**竞技场刷新对手需要钻石数*/
    public static int[][] ArenaRefreshCost;
    /**竞技场每日免费挑战次数*/
    public static int ArenaFreeChallenge;
    /**竞技场玩家匹配区间与获得积分*/
    public static int[][] ArenaRankInterval;
    /**竞技场ELO算法常数k*/
    public static int ArenaConstant_K;
    /**竞技场ELO算法常数N*/
    public static float ArenaConstant_N;
    /**竞技场ELO算法常数L*/
    public static int ArenaConstant_L;
    /**竞技场ELO算法常数M*/
    public static float ArenaConstant_M;
    /**竞技场结算时间（周X0点）*/
    public static int ArenaSettlementTime;
    /**竞技场结算禁止战斗时间（前后各X秒）*/
    public static int ArenaSettlementprohibit;
    /**竞技场购买挑战券价格*/
    public static int[][] ArenaTicketPrice;
    /**竞技场排名奖励*/
    public static int[][] ArenaRankReward;
    /**竞技场新手积分*/
    public static int ArenaTiroInitial;
    /**同一地点驻扎部队数量基础值*/
    public static int StationedTroopsLimit;
    /**英雄重置消耗*/
    public static int[][] HeroResetCost;
    /**英雄免费重置条件*/
    public static int HeroResetFreeLv;
    /**高阶竞技场挑战消耗*/
    public static int[][] HighArenaChallengeCost;
    /**高阶竞技场挂机效率系数*/
    public static float HighArenaEffConstant;
    /**高阶竞技场宝箱最大存放量*/
    public static int HighArenaChestMax;
    /**高阶竞技场每日免费挑战次数*/
    public static int HighArenaFreeChallenge;
    /**高阶竞技场购买门票需要钻石数*/
    public static int[][] HighArenaTicketsCost;
    /**高阶竞技场每天免费刷新对手次数*/
    public static int HighArenaFreeRefresh;
    /**高阶竞技场刷新对手需要钻石数*/
    public static int[][] HighArenaRefreshCost;
    /**高阶竞技场排名奖励*/
    public static int[][] HighArenaRankReward;
    /**高阶竞技场玩家初始积分*/
    public static int HighArenaInitialScore;
    /**高阶竞技场ELO算法常数k*/
    public static int HighArenaConstant_K;
    /**高阶竞技场ELO算法常数N*/
    public static float HighArenaConstant_N;
    /**高阶竞技场ELO算法常数L*/
    public static int HighArenaConstant_L;
    /**高阶竞技场ELO算法常数M*/
    public static float HighArenaConstant_M;
    /**高阶竞技场积分系数*/
    public static int HighArenaInitialConstant;
    /**默认旗帜*/
    public static int FlagDefault;
    /**玩家宣言的字数限制 [lowerLimit, upperLimit]*/
    public static int[] PlayerDeclarationLimit;
    /**侦察队列上限*/
    public static int ScoutQueueLimit;
    /**创建角色头像(男,女)*/
    public static int[] CreateCharacterAvatar;
    /**每日放弃港口次数最大值*/
    public static int AllianceMaxAbandonPort;
    /**更换母港冷却时间，单位秒*/
    public static int AllianceChangePortCd;
    /**港口提供的势力值[1级，2级，3级。。。]*/
    public static int[] WorldPortForce;
    /**每次刷新1样免费物品*/
    public static int AllianceDailyDealFreeNum;
    /**每次刷新若干样普通物品*/
    public static int AllianceDailyDealNum;
    /**联盟单次帮助贡献值*/
    public static int[][] AllianceHelpContributionPoint;
    /**联盟帮助获得贡献每日最大值*/
    public static int AllianceHelpContributionLimit;
    /**联盟帮助缩短时间比例*/
    public static int AllianceHelpTimeReduceRate;
    /**联盟帮助缩短时间最小值，单位秒*/
    public static int AllianceHelpMinReduceTime;
    /**联盟帮助缩短时间最大值的基础值，单位秒*/
    public static int AllianceHelpMaxReduceTimeBase;
    /**联盟帮助基础次数*/
    public static int AllianceHelpNumBase;
    /**家禽室产蛋基础速度（每分钟多少个）*/
    public static int ShipBuildingEggRoomBaseSpeed;
    /**净水室产淡水基础速度（每分钟多少个）*/
    public static int ShipBuildingWaterRoomBaseSpeed;
    /**草药室草药基础速度（每分钟多少个）*/
    public static int ShipBuildingHerbalMedicineRoomBaseSpeed;
    /**家禽室产出的道具id（item表）*/
    public static int ShipBuildingEggRoomItemId;
    /**净水室产产出的道具id（item表）*/
    public static int ShipBuildingWaterRoomItemId;
    /**草药室产出的道具id（item表）*/
    public static int ShipBuildingHerbalMedicineRoomItemId;
    /**港口改变归属后，保护罩持续时间，单位秒*/
    public static int PortWinProtectTime;
    /**时间战斗表演状态持续时间系数，表演时间 = Max(实际时间*WorldBattleActTimeRatio, WorldBattleActTimeMin)*/
    public static double WorldBattleActTimeRatio;
    /**世界战斗表演状态最小时间，单位秒*/
    public static int WorldBattleActTimeMin;
    /**建筑加速道具列表*/
    public static int[] BuildSpeedUpItemList;
    /**科技加速道具列表*/
    public static int[] TechSpeedUpItemList;
    /**训练士兵加速时道具的罗列列表的id*/
    public static int[] ShipBuildingTrainingNavySpeedUpItemList;
    /**医疗士兵加速时道具的罗列列表的id*/
    public static int[] ShipBuildingHealNavySpeedUpItemList;
    /**加速溢出时间二次确认提示的下限，单位：分钟*/
    public static int SpeedUpOverFlowLimit;
    /**木筏蓄力镜头高度*/
    public static int DriftChargedLensHigh;
    /**木筏宝箱距离*/
    public static int DriftChestDistance;
    /**木筏宝箱QTE时间*/
    public static int[] DriftChestQteTime;
    /**木筏QTE镜头高度*/
    public static int DriftChargedLensQteHigh;
    /**木筏宝箱QTE进度初始值*/
    public static int DriftInitialQte;
    /**木筏宝箱点击增加进度*/
    public static int DriftChestClickClose_Deep;
    /**木筏宝箱每秒自动扣除进度*/
    public static int DriftChestAway_Deep;
    /**木筏宝箱QTE进度上限*/
    public static int DriftChestSchedule;
    /**木筏生成位置配置*/
    public static int[][] DriftBuildLocation;
    /**木筏章鱼宝箱饥饿度消耗*/
    public static int DriftHungerConsumption;
    /**木筏鱼竿耐久度上限*/
    public static int DriftFishingRodDurabilityLimit;
    /**木筏钓鱼单次鱼竿耐久度消耗*/
    public static int DriftFishingRodConsume;
    /**木筏初始速度【真实，显示】*/
    public static int[] DriftInitialSpeed;
    /**木筏风帆速度【真实，显示】*/
    public static int[] DriftSaillSpeed;
    /**木筏木板损坏后扣除速度【真实，显示】*/
    public static int[] DriftDamageSpeed;
    /**木筏进度节点*/
    public static int[] DriftNode;
    /**木筏损坏数量*/
    public static int[] DriftDamagNum;
    /**木筏剧情损坏数量*/
    public static int[] DriftPlotDamagNum;
    /**木筏饥饿度系数[饥饿度1，饥饿度2，饥饿系数]*/
    public static int[][] DriftHungerCoefficient;
    /**木筏吃鱼进度条增加值*/
    public static int DriftFishProgress;
    /**木筏进度条满值*/
    public static int DriftProgressMax;
    /**木筏钩垃圾资源上限*/
    public static int[][] DriftHookItemLimit;
    /**新手宝藏宝箱位置与参数*/
    public static int[][] NewbiesBox;
    /**新手宝藏位置*/
    public static int[] NewbiesBoxPos;
    /**新手金币进度条*/
    public static int[] NewbiesGoldProgress;
    /**新手B包跳任务*/
    public static int NewbiesSkipTaskB;
    /**新手B包奖初始励*/
    public static int[][] NewbiesBInitialRewards;
    /**新手A包概率*/
    public static int NewbiesAProbability;
    /**装备升级时，消耗经验和金币的比例*/
    public static int[] EquipLvUp;
    /**瞭望台刷新时间*/
    public static int[] TowerRefreshTime;
    /**瞭望台笔记经验需求*/
    public static int TowerNoteExpNeed;
    /**瞭望台兴趣点刷新范围（环形）*/
    public static int[] TowerPointDistanceRange;
    /**瞭望台兴趣点极限距离（超过这个距离兴趣点隐藏，界面前往时重新刷新）*/
    public static int TowerPointLimitDistance;
    /**瞭望台兴趣点重刷所需移动距离*/
    public static int TowerRenewParam;
    /**瞭望塔一键完成关注的情报类型*/
    public static int[] TowerOnceFinishType;
    /**玩家信息-名称长度*/
    public static int[] NameLength;
    /**玩家信息-改名消耗*/
    public static int[][] NameChangeCost;
    /**玩家信息-钻石改名消耗*/
    public static int Diamond_Renaming;
    /**个人标记数量*/
    public static int signNumPersonal;
    /**联盟标记数量*/
    public static int signNumAlliance;
    /**标记文本字数限制*/
    public static int signWordNum;
    /**群组聊天数量*/
    public static int numOfGroupChat;
    /**群组聊天人数*/
    public static int numOfGroupChatPerson;
    /**服务器预估人数*/
    public static int serverRecommendedNumberOfPeople;
    /**服务器拥挤人数*/
    public static int serverCrowdNumberOfPeople;
    /**选择推荐服务器奖励*/
    public static int[] recommendedConditionChoose;
    /**聊天单条消息数量限制*/
    public static int numOfMessageLimit;
    /**世界聊天频率限制*/
    public static int[][] timeOfWorldMessageLimit;
    /**联盟群组聊天频率限制*/
    public static int[][] timeOfAllianceMessageLimit;
    /**跑马灯文本速度*/
    public static int marqueeRunSpeed;
    /**功能解锁重新判定的标识，玩家数据与这个标识不一致，则重新判定，线上修改Function_On之后需要给这个值+1*/
    public static int functionUnlockFlag;
    /**木材、织物、金属，基础上限值*/
    public static int resourceLimitBase;
    /**金币基础上限值*/
    public static int goldLimitBase;
    /**养成等级最前的X名英雄才会进行红点检测*/
    public static int HeroRedDotCondition;
    /**心情系统相关计算的单位时间（单位：秒）*/
    public static int MoodUnitTime;
    /**食物消耗速率（每隔1个单位时间消耗一定数量的食物）*/
    public static double FoodConsumeRate;
    /**淡水消耗速率（每隔1个单位时间消耗一定数量的淡水）*/
    public static double WaterConsumeRate;
    /**初始心情（客户端显示万分比）*/
    public static int InitMood;
    /**最大心情（客户端万分比）*/
    public static int MaxMood;
    /**心情提升速率（每隔1个单位时间心情提升一定数值）【阶段（Mood表Id），心情提升的数值】*/
    public static int[][] MoodUpRate;
    /**食物不足时心情降低速率（每隔1个单位时间心情降低一定数值）【阶段（Mood表Id），心情降低的数值】*/
    public static int[][] MoodDownFoodRate;
    /**淡水不足时心情降低速率（每隔1个单位时间心情降低一定数值）【阶段（Mood表Id），心情降低的数值】*/
    public static int[][] MoodDownWaterRate;
    /**船长室<=X级时，英雄和水兵的食物/淡水心情值有一个最低值   [[船长室等级,心情值]]*/
    public static int[][] MinMoodLimit;
    /**船长室<=X级时，玩家离线后心情值不会降低*/
    public static int OfflineMoodLimit;
    /**迁城*/
    public static int ShipTeleportType;
    /**非大世界玩法默认带兵信息【等级，数量】*/
    public static int[] InitDeployNavyInfo;
    /**世界布阵队列解锁条件【房间id（Ship_Building_Group）】（按照队列顺序一一对应）*/
    public static int[] TeamUnlockCondition;
    /**世界布阵队列槽位解锁条件【每个位置对应的科技id（Tech_Info）】（按照队列顺序一一对应）*/
    public static int[][] TeamPosUnlockCondition;
    /**王座开启时间*/
    public static int ThroneOpenTime;
    /**王座持续时间*/
    public static int ThroneAttactTime;
    /**王座战斗结算速度加成 百分比*/
    public static int ThroneAttactTimeSpeedUp;
    /**王座占领积分 每分钟*/
    public static int ThroneAttactTimeIntegration;
    /**王座未开启时 不可进入的区域大小  半径*/
    public static int ThroneStopArea;
    /**旋涡路径*/
    public static String ThroneVortex;
    /**新手保护罩等级*/
    public static int NewPlayerProtectionLevel;
    /**出生点距港口的距离*/
    public static int[] BirthPointDistanceToPortLimit;
    /**限制驻港时间 秒*/
    public static int StayPortTimeLimit;
    /**战斗会关闭的BUFF*/
    public static int[] PvpCloseBuff;
    /**当玩家获得章鱼宝箱奖励次数>=X，则给其他奖励*/
    public static int RaftOctopusBoxRewardCount;
    /**当玩家获得章鱼宝箱奖励次数>=X，给的奖励*/
    public static int[][] RaftOctopusBoxLowReward;
    /**当玩家赶走鲨鱼时，可获得的奖励*/
    public static int[][] RaftSharkReward;
    /**当玩家获得赶走鲨鱼的奖励次数>=X，则给其他奖励*/
    public static int RaftSharkRewardCount;
    /**当玩家获得赶走鲨鱼的奖励次数>=X，给的奖励*/
    public static int[][] RaftSharkLowReward;
    /**委托任务道具可持有数量上限*/
    public static int MaxEntrustLicense;
    /**代表每恢复一点委托道具需要的时间（单位：S）*/
    public static int EntrustLicenseTime;
    /**委托任务最大可接取上限*/
    public static int EntrustTaskMaxAccept;
    /**委托任务最大可展示上限*/
    public static int EntrustTaskMaxShow;
    /**委托任务刷新时间（小时）*/
    public static int EntrustTaskRefreshTime;
    /**第一个主线任务id*/
    public static int MainTaskId;
    /**押镖次数限制*/
    public static int TransportGoods_Time_Limit;
    /**成为海盗次数限制*/
    public static int PlunderGoods_Time_Lime;
    /**每次成为海盗可劫镖次数*/
    public static int PlunderGoods_Time_Lime_Per;
    /**劫镖消耗*/
    public static int[][] PlunderGoods_Cost;
    /**开启押镖点数量*/
    public static int TransportGoods_Open_Port_Num;
    /**开启时间 服务器时间 0点开始 6小时开启一次*/
    public static int[] TransportGoods_Open_Time;
    /**持续时间 秒*/
    public static int TransportGoods_Continuous_Time;
    /**初始货物数量*/
    public static int Goods_Initial;
    /**最少货物数量*/
    public static int Goods_least;
    /**押镖开启等级*/
    public static int TransportGoods_Open_Level;
    /**押镖开启范围（几圈）*/
    public static int TransportGoods_Open_Range;

}