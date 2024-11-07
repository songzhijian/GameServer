package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成AttributeType
 */
public enum AttributeType {

    /**
     * 生命
     */
    HP(1),

    /**
     * 攻击
     */
    ATK(2),

    /**
     * 防御
     */
    DEF(3),

    /**
     * 法防
     */
    MODEF_DEF(4),

    /**
     * 生命扣除万分比
     */
    HP_REDUCE(5),

    /**
     * 初始增加的怒气值
     */
    POWER_INIT(6),

    /**
     * 暴击率
     */
    CRIT(11),

    /**
     * 命中等级
     */
    HIT(12),

    /**
     * 闪避等级
     */
    DODGE(13),

    /**
     * 物理减伤率
     */
    PHYREDUCE(14),

    /**
     * 法术减伤率
     */
    MAGREDUCE(15),

    /**
     * 急速
     */
    SPD(16),

    /**
     * 吸血等级
     */
    VAMPIRE(17),

    /**
     * 暴击效果
     */
    CRITDMG(21),

    /**
     * 抗暴
     */
    RESIST(22),

    /**
     * 物理增伤
     */
    PHYADD(23),

    /**
     * 法术增伤
     */
    MAGADD(24),

    /**
     * 攻击速度
     */
    ATKSPD(25),

    /**
     * 冷却加速
     */
    CDDOWN(26),

    /**
     * 移动速度
     */
    MOV(27),

    /**
     * 攻击怒气回复速度
     */
    ADDPOWERUP(28),

    /**
     * 受击怒气回复速度
     */
    HITPOWERUP(29),

    /**
     * 生命恢复效果加成
     */
    RECOVERUP(30),

    /**
     * 治疗效果提升
     */
    HEALUP(31),

    /**
     * 相克额外系数A【打被自己克制的敌人】
     */
    RACE_A(32),

    /**
     * 相克额外系数B【打不被自己克制的敌人】
     */
    RACE_B(33),

    /**
     * 相克额外系数C【被克制自己的敌人打】
     */
    RACE_C(34),

    /**
     * 生命--基础值
     */
    HP_A(41),

    /**
     * 生命--百分比加成
     */
    HP_B(42),

    /**
     * 生命--固定值加成
     */
    HP_C(43),

    /**
     * 攻击--基础值
     */
    ATK_A(44),

    /**
     * 攻击--百分比加成
     */
    ATK_B(45),

    /**
     * 攻击--固定值加成
     */
    ATK_C(46),

    /**
     * 防御--基础值
     */
    DEF_A(47),

    /**
     * 防御--百分比加成
     */
    DEF_B(48),

    /**
     * 防御--固定值加成
     */
    DEF_C(49),

    /**
     * 法防--基础值
     */
    MODEF_DEF_A(50),

    /**
     * 法防--百分比加成
     */
    MODEF_DEF_B(51),

    /**
     * 法防--固定值加成
     */
    MODEF_DEF_C(52),

    /**
     * 暴击率--基础值
     */
    CRIT_A(53),

    /**
     * 暴击率--百分比加成
     */
    CRIT_B(54),

    /**
     * 暴击率--固定值加成
     */
    CRIT_C(55),

    /**
     * 命中等级--基础值
     */
    HIT_A(56),

    /**
     * 命中等级--百分比加成
     */
    HIT_B(57),

    /**
     * 命中等级--固定值加成
     */
    HIT_C(58),

    /**
     * 闪避等级--基础值
     */
    DODGE_A(59),

    /**
     * 闪避等级--百分比加成
     */
    DODGE_B(60),

    /**
     * 闪避等级--固定值加成
     */
    DODGE_C(61),

    /**
     * 物理减伤率--基础值
     */
    PHYREDUCE_A(62),

    /**
     * 物理减伤率--百分比加成
     */
    PHYREDUCE_B(63),

    /**
     * 物理减伤率--固定值加成
     */
    PHYREDUCE_C(64),

    /**
     * 法术减伤率--基础值
     */
    MAGREDUCE_A(65),

    /**
     * 法术减伤率--百分比加成
     */
    MAGREDUCE_B(66),

    /**
     * 法术减伤率--固定值加成
     */
    MAGREDUCE_C(67),

    /**
     * 急速--基础值
     */
    SPD_A(68),

    /**
     * 急速--百分比加成
     */
    SPD_B(69),

    /**
     * 急速--固定值加成
     */
    SPD_C(70),

    /**
     * 吸血等级--基础值
     */
    VAMPIRE_A(71),

    /**
     * 吸血等级--百分比加成
     */
    VAMPIRE_B(72),

    /**
     * 吸血等级--固定值加成
     */
    VAMPIRE_C(73),

    ;
    private int value;

    public static AttributeType[] ARRAY = {
            HP,
            ATK,
            DEF,
            MODEF_DEF,
            HP_REDUCE,
            POWER_INIT,
            CRIT,
            HIT,
            DODGE,
            PHYREDUCE,
            MAGREDUCE,
            SPD,
            VAMPIRE,
            CRITDMG,
            RESIST,
            PHYADD,
            MAGADD,
            ATKSPD,
            CDDOWN,
            MOV,
            ADDPOWERUP,
            HITPOWERUP,
            RECOVERUP,
            HEALUP,
            RACE_A,
            RACE_B,
            RACE_C,
            HP_A,
            HP_B,
            HP_C,
            ATK_A,
            ATK_B,
            ATK_C,
            DEF_A,
            DEF_B,
            DEF_C,
            MODEF_DEF_A,
            MODEF_DEF_B,
            MODEF_DEF_C,
            CRIT_A,
            CRIT_B,
            CRIT_C,
            HIT_A,
            HIT_B,
            HIT_C,
            DODGE_A,
            DODGE_B,
            DODGE_C,
            PHYREDUCE_A,
            PHYREDUCE_B,
            PHYREDUCE_C,
            MAGREDUCE_A,
            MAGREDUCE_B,
            MAGREDUCE_C,
            SPD_A,
            SPD_B,
            SPD_C,
            VAMPIRE_A,
            VAMPIRE_B,
            VAMPIRE_C
    };

    AttributeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AttributeType getType(int value) {
        return switch (value) {
            case 1 -> HP;
            case 2 -> ATK;
            case 3 -> DEF;
            case 4 -> MODEF_DEF;
            case 5 -> HP_REDUCE;
            case 6 -> POWER_INIT;
            case 11 -> CRIT;
            case 12 -> HIT;
            case 13 -> DODGE;
            case 14 -> PHYREDUCE;
            case 15 -> MAGREDUCE;
            case 16 -> SPD;
            case 17 -> VAMPIRE;
            case 21 -> CRITDMG;
            case 22 -> RESIST;
            case 23 -> PHYADD;
            case 24 -> MAGADD;
            case 25 -> ATKSPD;
            case 26 -> CDDOWN;
            case 27 -> MOV;
            case 28 -> ADDPOWERUP;
            case 29 -> HITPOWERUP;
            case 30 -> RECOVERUP;
            case 31 -> HEALUP;
            case 32 -> RACE_A;
            case 33 -> RACE_B;
            case 34 -> RACE_C;
            case 41 -> HP_A;
            case 42 -> HP_B;
            case 43 -> HP_C;
            case 44 -> ATK_A;
            case 45 -> ATK_B;
            case 46 -> ATK_C;
            case 47 -> DEF_A;
            case 48 -> DEF_B;
            case 49 -> DEF_C;
            case 50 -> MODEF_DEF_A;
            case 51 -> MODEF_DEF_B;
            case 52 -> MODEF_DEF_C;
            case 53 -> CRIT_A;
            case 54 -> CRIT_B;
            case 55 -> CRIT_C;
            case 56 -> HIT_A;
            case 57 -> HIT_B;
            case 58 -> HIT_C;
            case 59 -> DODGE_A;
            case 60 -> DODGE_B;
            case 61 -> DODGE_C;
            case 62 -> PHYREDUCE_A;
            case 63 -> PHYREDUCE_B;
            case 64 -> PHYREDUCE_C;
            case 65 -> MAGREDUCE_A;
            case 66 -> MAGREDUCE_B;
            case 67 -> MAGREDUCE_C;
            case 68 -> SPD_A;
            case 69 -> SPD_B;
            case 70 -> SPD_C;
            case 71 -> VAMPIRE_A;
            case 72 -> VAMPIRE_B;
            case 73 -> VAMPIRE_C;
            default -> {
                LogUtils.logger.error("AttributeType is not find value:{}",value);
                yield null;
            }
        };
    }
}
