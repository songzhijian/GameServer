package com.tool.config.type.struct;

import com.tool.config.type.IType;
import org.apache.commons.lang3.StringUtils;

public class IntArrayVerticalParse implements IType<int[]> {
    public static int[] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) {
            return IntArrayParse.EMPTY;
        }
        String[] split = value.split(";");
        int[] values = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            values[i] = Integer.parseInt(split[i]);
        }
        return values;
    }

}
