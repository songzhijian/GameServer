package com.tool.utils;

public class DataCheckUtil {

    public static void  checkArray(String value) {
        if(!(value.startsWith("[") && value.endsWith("]"))) {
           throw new RuntimeException("数组格式非法 value=" + value);
        }
    }
}
