package com.tool.config.type.struct;

import com.tool.config.type.primitive.BooleanParse;
import com.tool.config.type.primitive.StringParse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MapStringBooleanParse {
    public static Map<String,Boolean> parse(String value) {
        Map<String,Boolean> values = new HashMap<>();
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return values;

        String[] split = value.split(",");
        for (String kV : split) {
            String[] keyAndValue = kV.split(":");
            values.put(StringParse.parse(keyAndValue[0]), BooleanParse.parse(keyAndValue[1]));
        }
        return values;
    }
}
