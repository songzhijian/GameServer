package com.tool.config;


import com.google.common.collect.Lists;

import java.util.List;

public class SheetData {

    private List<ColData> colInfo = Lists.newArrayList();

    private List<List<ColData>> data;
    private List<List<ColData>> enumDatas;
    private int enumMax;

    //true 为纵表
    private boolean vertical = false;

    private int type;

    private boolean saveOld = false;


    public List<ColData> getColInfo() {
        return colInfo;
    }

    public void setColInfo(List<ColData> colInfo) {
        this.colInfo = colInfo;
    }

    public List<List<ColData>> getData() {
        return data;
    }

    public void setData(List<List<ColData>> data) {
        this.data = data;
    }

    public boolean isVertical() {
        return vertical;
    }

    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<List<ColData>> getEnumDatas() {
        return enumDatas;
    }

    public void setEnumDatas(List<List<ColData>> enumDatas) {
        this.enumDatas = enumDatas;
    }

    public int getEnumMax() {
        return enumMax;
    }

    public void setEnumMax(int enumMax) {
        this.enumMax = enumMax;
    }

    public boolean isSaveOld() {
        return saveOld;
    }

    public void setSaveOld(boolean saveOld) {
        this.saveOld = saveOld;
    }
}
