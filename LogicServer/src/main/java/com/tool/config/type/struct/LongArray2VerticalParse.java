package com.tool.config.type.struct;

import org.apache.commons.lang3.StringUtils;

public class LongArray2VerticalParse {

    public static long[][] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return LongArray2Parse.EMPTY;
        String[] split = value.split("\\|");
        long[][] values = new long[split.length][];
        for (int i = 0; i < split.length; i++) {
            values[i] = LongArrayVerticalParse.parse(split[i]);
        }
        return values;
    }

}
