package com.tool.config.type.primitive;

import org.apache.commons.lang3.StringUtils;

public class StringParse {

    public static String parse(String value){
        if(StringUtils.isEmpty(value))
            return "";
        return value;
    }
}
