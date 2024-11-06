package com.tool.config.type.struct;

import org.apache.commons.lang3.StringUtils;

public class StringArray2VerticalParse {

    public static String[][] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return StringArray2Parse.EMPTY;
        String[] split = value.split("\\|");
        String[][] values = new String[split.length][];
        for (int i = 0; i < split.length; i++) {
            values[i] = StringArrayVerticalParse.parse(split[i]);
        }
        return values;
    }
}
