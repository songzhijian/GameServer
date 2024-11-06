package com.tool.config.type.struct;


import java.util.function.Function;

public class PairParse {
    public static EPair parse(String value, Function<String, Object>... valueParse) {
        String[] split = value.split(",");
        return EPair.of(valueParse[0].apply(split[0]), valueParse[1].apply(split[1]));
    }

}
