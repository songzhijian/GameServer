package com.tool.config.type.struct;

import com.tool.config.type.primitive.IntParse;
import com.tool.config.type.primitive.StringParse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MapStringIntParse {
    public static Map<String,Integer> parse(String value) {
        Map<String,Integer> values = new HashMap<>();
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return values;


        String[] split = value.split(",");
        for (String kV : split) {
            String[] keyAndValue = kV.split(":");
            values.put(StringParse.parse(keyAndValue[0]),IntParse.parse(keyAndValue[1]));
        }
        return values;
    }
}
