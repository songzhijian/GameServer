package com.tool.config.type.struct;

import com.tool.config.type.primitive.StringParse;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MapIStringStringParse {
    public static Map<String,String> parse(String value) {
        Map<String,String> values = new HashMap<>();
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return values;

        String[] split = value.split(",");
        for (String kV : split) {
            String[] keyAndValue = kV.split(":");
            values.put(StringParse.parse(keyAndValue[0]), StringParse.parse(keyAndValue[1]));
        }

        return values;
    }
}
