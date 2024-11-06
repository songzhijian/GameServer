package com.tool.config.type.struct;

import com.tool.utils.DataCheckUtil;
import org.apache.commons.lang3.StringUtils;

public class StringArray2Parse {

    public static final String[][] EMPTY = new String[0][];
    public static String[][] parse(String value){
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return EMPTY;
        DataCheckUtil.checkArray(value);
        value = value.substring(1,value.length()-1);
        String[] split = value.split("],");
        String[][] values = new String[split.length][];
        for (int i = 0; i < split.length; i++) {
            if(i==split.length-1) {
                values[i] = StringArrayParse.parse(split[i]);
            }else {
                values[i] = StringArrayParse.parse(split[i]+"]");
            }

        }
        return values;
    }
}
