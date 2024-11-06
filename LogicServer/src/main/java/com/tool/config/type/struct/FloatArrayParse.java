package com.tool.config.type.struct;

import com.tool.utils.DataCheckUtil;
import org.apache.commons.lang3.StringUtils;

public class FloatArrayParse {

    public static final float[] EMPTY = new float[0];
    public static float[] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) {
            return EMPTY;
        }
        DataCheckUtil.checkArray(value);
        value = value.substring(1, value.length() - 1);
        String[] split = value.split(",");
        float[] values = new float[split.length];
        for (int i = 0; i < split.length; i++) {
            if (StringUtils.isBlank(split[i])) {
                values[i] = 0f;
                continue;
            }
            values[i] = Float.parseFloat(split[i]);
        }
        return values;
    }
}
