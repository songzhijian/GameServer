package com.tool.config.type.struct;

import com.tool.config.type.primitive.FloatParse;
import com.tool.config.type.primitive.StringParse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MapStringFloatParse {
    public static Map<String,Float> parse(String value) {
        Map<String,Float> values = new HashMap<>();
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return values;


        String[] split = value.split(",");
        for (String kV : split) {
            String[] keyAndValue = kV.split(":");
            values.put(StringParse.parse(keyAndValue[0]), FloatParse.parse(keyAndValue[1]));
        }

        return values;
    }
}
