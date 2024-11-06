package com.tool.config.type.struct;

import com.tool.config.type.primitive.IntParse;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class MapIntIntParse {
    public static Map<Integer, Integer> parse(String value) {
        if(StringUtils.isEmpty(value) || StringUtils.isBlank(value)) return new Int2IntOpenHashMap();

        Int2IntOpenHashMap values = new Int2IntOpenHashMap();
        String[] split = value.split(",");
        for (String kV : split) {
            String[] keyAndValue = kV.split(":");
            values.put(IntParse.parse(keyAndValue[0]),IntParse.parse(keyAndValue[1]));
        }

        return values;
    }

}
