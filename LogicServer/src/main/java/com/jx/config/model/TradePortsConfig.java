package com.jx.config.model;

import com.jx.config.loader.TradePortsConfigLoader;
import com.jx.config.util.gen.support.AbstractConfig;
import com.jx.config.util.gen.support.IConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 工具生成 配置文件 Trade_Ports.xml
*/
public class TradePortsConfig extends AbstractConfig implements IConfig {

    /**id*/
    private final int id;
    /**name*/
    private final int portName;
    /**等级*/
    private final int portLevel;
    /**属于商圈*/
    private final int portCulturaCircle;
    /**购买税率，万分比*/
    private final int buyTax;
    /**出售税率，万分比*/
    private final int SellTax;
    /**售卖产品[交易品ID,售价,发展度1,供货量1,发展度2,供货量2,发展度3,供货量3...]*/
    private final int[][] portCoordinate;
    /**星级特产标的*/
    private final int target;
    /**星级特产[发展度,交易品id,星级,出现几率,下限百分比,上限百分比],*/
    private final int[][] portModle;
    /**港口收货价格*/
    private final Map<Integer,Integer> Price;

    /**
     * 获取所有配置
     */
    public static List<TradePortsConfig> findAll(){
        return TradePortsConfigLoader.findAll();
    }

    /**
     * 按照Id获取指定配置
     */
    public static TradePortsConfig getByKey(int key){
        return TradePortsConfigLoader.getByKey(key);
    }

    //#region getter
    /**
     * id
     */
    public int getId() {
        return id;
    }

    /**
     * name
     */
    public int getPortName() {
        return portName;
    }

    /**
     * 等级
     */
    public int getPortLevel() {
        return portLevel;
    }

    /**
     * 属于商圈
     */
    public int getPortCulturaCircle() {
        return portCulturaCircle;
    }

    /**
     * 购买税率，万分比
     */
    public int getBuyTax() {
        return buyTax;
    }

    /**
     * 出售税率，万分比
     */
    public int getSellTax() {
        return SellTax;
    }

    /**
     * 售卖产品[交易品ID,售价,发展度1,供货量1,发展度2,供货量2,发展度3,供货量3...]
     */
    public int[][] getPortCoordinate() {
        return portCoordinate;
    }

    /**
     * 星级特产标的
     */
    public int getTarget() {
        return target;
    }

    /**
     * 星级特产[发展度,交易品id,星级,出现几率,下限百分比,上限百分比],
     */
    public int[][] getPortModle() {
        return portModle;
    }

    /**
     * 港口收货价格
     */
    public Map<Integer,Integer> getPrice() {
        return Price;
    }

    //#endregion

    //#region 构造函数

    public TradePortsConfig(int id, int portName, int portLevel, int portCulturaCircle, int buyTax, int SellTax, int[][] portCoordinate, int target, int[][] portModle, Map<Integer,Integer> Price){
        this.id = id;
        this.portName = portName;
        this.portLevel = portLevel;
        this.portCulturaCircle = portCulturaCircle;
        this.buyTax = buyTax;
        this.SellTax = SellTax;
        this.portCoordinate = portCoordinate;
        this.target = target;
        this.portModle = portModle;
        this.Price = Price;
    }

    //#endregion
}
