package com.tool.config.type.struct;

import com.tool.config.type.IType;
import com.tool.utils.DataCheckUtil;
import org.apache.commons.lang3.StringUtils;

public class LongArrayParse implements IType<int[]> {
    public static final long[] EMPTY = new long[0];
    public static long[] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return EMPTY;
        DataCheckUtil.checkArray(value);
        value = value.substring(1, value.length() - 1);
        String[] split = value.split(",");
        long[] values = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            values[i] = Long.parseLong(split[i]);
        }
        return values;
    }

    public static void toString(long[] values,StringBuilder b) {
        int iMax = values.length - 1;
        if (iMax == -1)
            return;

        b.append('[');
        for (int i = 0; ; i++) {
            b.append(values[i]);
            if (i == iMax)
            {
                break;
            }
            b.append(',');
        }
        b.append(']');
    }
}
