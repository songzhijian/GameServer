package com.tool.config.type.struct;

import com.tool.config.type.IType;
import com.tool.config.type.primitive.BooleanParse;
import com.tool.utils.DataCheckUtil;
import org.apache.commons.lang3.StringUtils;

public class BooleanArrayParse implements IType<int[]> {

    public static final boolean[] EMPTY = new boolean[0];
    public static boolean[] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return EMPTY;
        DataCheckUtil.checkArray(value);

        value = value.substring(1, value.length() - 1);
        String[] split = value.split(",");
        boolean[] values = new boolean[split.length];
        for (int i = 0; i < split.length; i++) {
            values[i] = BooleanParse.parse(split[i]);
        }
        return values;
    }

}
