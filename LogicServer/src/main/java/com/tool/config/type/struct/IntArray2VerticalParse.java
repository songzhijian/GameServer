package com.tool.config.type.struct;

import org.apache.commons.lang3.StringUtils;

public class IntArray2VerticalParse {

    public static int[][] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return IntArray2Parse.EMPTY;
        String[] split = value.split("\\|");
        int[][] values = new int[split.length][];
        for (int i = 0; i < split.length; i++) {
            values[i] = IntArrayVerticalParse.parse(split[i]);
        }
        return values;
    }

}
