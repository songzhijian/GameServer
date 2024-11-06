package com.tool.config.type.struct;

import com.tool.config.type.primitive.FloatParse;
import com.tool.config.type.primitive.IntParse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MapIntFloatParse {
    public static Map<Integer,Float> parse(String value) {
        Map<Integer,Float> values = new HashMap<>();
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return values;

        String[] split = value.split(",");
        for (String kV : split) {
            String[] keyAndValue = kV.split(":");
            values.put(IntParse.parse(keyAndValue[0]), FloatParse.parse(keyAndValue[1]));
        }

        return values;
    }
}
