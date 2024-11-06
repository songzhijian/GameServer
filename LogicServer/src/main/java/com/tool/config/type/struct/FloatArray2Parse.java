package com.tool.config.type.struct;

import com.tool.utils.DataCheckUtil;
import org.apache.commons.lang3.StringUtils;

public class FloatArray2Parse {

    public static final float[][] EMPTY = new float[0][];
    public static float[][] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return EMPTY;
        DataCheckUtil.checkArray(value);
        value = value.substring(1, value.length() - 1);
        String[] split = value.split("],");
        float[][] values = new float[split.length][];
        for (int i = 0; i < split.length; i++) {
            if (i == split.length - 1) {
                values[i] = FloatArrayParse.parse(split[i]);
            } else {
                values[i] = FloatArrayParse.parse(split[i] + "]");
            }
        }
        return values;
    }
}
