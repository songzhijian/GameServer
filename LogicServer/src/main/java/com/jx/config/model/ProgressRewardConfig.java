package com.jx.config.model;

import com.jx.config.loader.ProgressRewardConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Progress_Reward.xml
*/
public class ProgressRewardConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**档位*/
    private final int progress;
    /**奖励*/
    private final int[][] reward;
    /**补发邮件*/
    private final int mail;

    /**
     * 获取所有配置
     */
    public static List<ProgressRewardConfig> findAll(){
        return ProgressRewardConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static ProgressRewardConfig getByKey(int key){
        return ProgressRewardConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 档位
     */
    public int getProgress() {
        return progress;
    }

    /**
     * 奖励
     */
    public int[][] getReward() {
        return reward;
    }

    /**
     * 补发邮件
     */
    public int getMail() {
        return mail;
    }

    //#endregion

    //#region 构造函数

    public ProgressRewardConfig(int id, int progress, int[][] reward, int mail){
        this.id = id;
        this.progress = progress;
        this.reward = reward;
        this.mail = mail;
    }

    //#endregion
}
