package com.tool.config.type.struct;

import com.tool.config.type.primitive.IntParse;
import com.tool.config.type.primitive.StringParse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MapIntStringParse {
    public static Map<Integer,String> parse(String value) {
        Map<Integer,String> values = new HashMap<>();
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return values;

        String[] split = value.split(",");
        for (String kV : split) {
            String[] keyAndValue = kV.split(":");
            values.put(IntParse.parse(keyAndValue[0]), StringParse.parse(keyAndValue[1]));
        }
        return values;
    }
}
