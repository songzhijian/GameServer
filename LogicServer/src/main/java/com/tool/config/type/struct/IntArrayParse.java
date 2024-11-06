package com.tool.config.type.struct;

import com.tool.config.type.IType;
import com.tool.config.type.primitive.IntParse;
import com.tool.utils.DataCheckUtil;
import org.apache.commons.lang3.StringUtils;

public class IntArrayParse implements IType<int[]> {

    public static final int[] EMPTY = new int[0];
    public static int[] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value) || "[]".equals(value)) {
            return EMPTY;
        }
        DataCheckUtil.checkArray(value);
        value = value.substring(1, value.length() - 1);
        String[] split = value.split(",");
        int[] values = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            values[i] = IntParse.parse(split[i]);
        }
        return values;
    }

    public static void toString(int[] values,StringBuilder b) {
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
