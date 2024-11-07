package com.jx.config.model;

import com.jx.config.loader.MailTemplateConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Mail_Template.xml
*/
public class MailTemplateConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**奖励id*/
    private final int[][] rewards;
    /**奖励超过上限的领取逻辑，1=领取后超上限则禁止领取，0=不限制；奖励类型限制为 （金币、木材、织物、金属、贸易品）*/
    private final int rewardOverCapLogic;

    /**
     * 获取所有配置
     */
    public static List<MailTemplateConfig> findAll(){
        return MailTemplateConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static MailTemplateConfig getByKey(int key){
        return MailTemplateConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * 奖励id
     */
    public int[][] getRewards() {
        return rewards;
    }

    /**
     * 奖励超过上限的领取逻辑，1=领取后超上限则禁止领取，0=不限制；奖励类型限制为 （金币、木材、织物、金属、贸易品）
     */
    public int getRewardOverCapLogic() {
        return rewardOverCapLogic;
    }

    //#endregion

    //#region 构造函数

    public MailTemplateConfig(int id, int[][] rewards, int rewardOverCapLogic){
        this.id = id;
        this.rewards = rewards;
        this.rewardOverCapLogic = rewardOverCapLogic;
    }

    //#endregion
}
