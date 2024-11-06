package com.tool.config.type.struct;

import com.tool.config.type.IType;
import com.tool.utils.DataCheckUtil;
import org.apache.commons.lang3.StringUtils;

public class DoubleArrayParse implements IType<int[]> {

    public static final double[] EMPTY = new double[0];
    public static double[] parse(String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return EMPTY;
        DataCheckUtil.checkArray(value);
        value = value.substring(1, value.length() - 1);
        String[] split = value.split(",");
        double[] values = new double[split.length];
        for (int i = 0; i < split.length; i++) {
            values[i] = Double.parseDouble(split[i]);
        }
        return values;
    }

}
