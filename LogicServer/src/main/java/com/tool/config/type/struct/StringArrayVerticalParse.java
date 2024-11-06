package com.tool.config.type.struct;

import org.apache.commons.lang3.StringUtils;

public class StringArrayVerticalParse {

    public static String[] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return StringArrayParse.EMPTY;
        String[] split = value.split(";");
        return split;
    }
}
