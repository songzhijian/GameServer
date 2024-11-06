package com.tool.config.type.struct;

import com.tool.utils.DataCheckUtil;
import org.apache.commons.lang3.StringUtils;

public class IntArray3Parse {

    public static final int[][][] EMPTY = new int[0][][];
    public static int[][][] parse(String value){
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return EMPTY;
        DataCheckUtil.checkArray(value);
        value = value.substring(1,value.length()-1);
        String[] split = value.split("]],");
        int[][][] values = new int[split.length][][];
        for (int i = 0; i < split.length; i++) {
            if(i==split.length-1) {
                values[i] = IntArray2Parse.parse(split[i]);
            }else {
                values[i] = IntArray2Parse.parse(split[i]+"]]");
            }
        }
        return values;
    }

    public static void toString(int[][] values,StringBuilder b){
        int iMax = values.length - 1;
        if (iMax == -1)
            return;

        b.append('[');
        for (int i = 0; ; i++) {
            int[] v = values[i];
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
