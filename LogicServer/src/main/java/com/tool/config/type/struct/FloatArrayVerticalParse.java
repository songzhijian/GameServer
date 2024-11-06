package com.tool.config.type.struct;

import org.apache.commons.lang3.StringUtils;

public class FloatArrayVerticalParse {

    public static float[] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return FloatArrayParse.EMPTY;
        String[] split = value.split(";");
        float[] values = new float[split.length];
        for (int i = 0; i < split.length; i++) {
            values[i] = Float.parseFloat(split[i]);
        }
        return values;
    }
}
