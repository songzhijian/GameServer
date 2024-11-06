package com.tool.config.type.struct;

import com.tool.config.type.IType;
import org.apache.commons.lang3.StringUtils;

public class LongArrayVerticalParse implements IType<int[]> {
    public static long[] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) {
            return LongArrayParse.EMPTY;
        }
        String[] split = value.split(";");
        long[] values = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            values[i] = Long.parseLong(split[i]);
        }
        return values;
    }

}
