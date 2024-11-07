package com.jx.config.type;

import com.gameengine.system.utils.LogUtils;

/**
 * 工具生成TutorialType
 */
public enum TutorialType {

    /**
     * 强引导：只允许单击 界面的UIButton（arg1：界面名,arg2：button名）
     */
    FORCEDGUIDE_CLICK(1),

    /**
     * 强引导：只允许长摁 大世界里的3D物体（arg1：3D物体路径）
     */
    FORCEDGUIDE_LONGTAP(3),

    /**
     * 强引导：只允许拖动（arg1：3D物体路径）
     */
    FORCEDGUIDE_DRAG(5),

    /**
     * 弱引导：只允许点击监听（arg1：界面名,arg2：button名）
     */
    WEAKGUIDE_CLICK(7),

    /**
     * 提示引导：屏蔽任何输入
     */
    NOINPUT_GUIDE(99),

    /**
     * 提示引导：允许任何输入
     */
    ANYINPUT_GUIDE(100),

    ;
    private int value;

    public static TutorialType[] ARRAY = {
            FORCEDGUIDE_CLICK,
            FORCEDGUIDE_LONGTAP,
            FORCEDGUIDE_DRAG,
            WEAKGUIDE_CLICK,
            NOINPUT_GUIDE,
            ANYINPUT_GUIDE
    };

    TutorialType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TutorialType getType(int value) {
        return switch (value) {
            case 1 -> FORCEDGUIDE_CLICK;
            case 3 -> FORCEDGUIDE_LONGTAP;
            case 5 -> FORCEDGUIDE_DRAG;
            case 7 -> WEAKGUIDE_CLICK;
            case 99 -> NOINPUT_GUIDE;
            case 100 -> ANYINPUT_GUIDE;
            default -> {
                LogUtils.logger.error("TutorialType is not find value:{}",value);
                yield null;
            }
        };
    }
}
