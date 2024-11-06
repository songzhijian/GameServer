package com.tool.config.type.struct;

import com.tool.utils.DataCheckUtil;
import org.apache.commons.lang3.StringUtils;

public class StringArrayParse {
    public static final String[] EMPTY = new String[0];
    public static String[] parse(String value){
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return EMPTY;
        DataCheckUtil.checkArray(value);
        value = value.substring(1,value.length()-1);
        String[] split = value.split(",");
        return split;
    }
}
