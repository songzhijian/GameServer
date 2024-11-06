package com.tool.config.type.struct;

import com.tool.utils.DataCheckUtil;
import org.apache.commons.lang3.StringUtils;

public class LongArray2Parse {
    public static final long[][] EMPTY = new long[0][];
    public static long[][] parse(String value){
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return EMPTY;
        DataCheckUtil.checkArray(value);
        value = value.substring(1,value.length()-1);
        String[] split = value.split("],");
        long[][] values = new long[split.length][];
        for (int i = 0; i < split.length; i++) {
            if(i==split.length-1) {
                values[i] = LongArrayParse.parse(split[i]);
            }else {
                values[i] = LongArrayParse.parse(split[i]+"]");
            }
        }
        return values;
    }

    public static void toString(long[][] values,StringBuilder b){
        int iMax = values.length - 1;
        if (iMax == -1)
            return;
        b.append('[');
        for (int i = 0; ; i++) {
            long[] v = values[i];
            if (v != null) {
                b.append('[');
                for (int j = 0; ; j++) {
                    b.append(v[j]);
                    if (j == v.length - 1)
                    {
                        b.append(']');
                        break;
                    }
                    b.append(',');
                }
            }
            if (i == iMax) {
                b.append(']');
                return;
            }
            b.append(",");
        }
    }
}
