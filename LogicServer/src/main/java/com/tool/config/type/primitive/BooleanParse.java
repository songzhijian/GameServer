package com.tool.config.type.primitive;


import com.tool.config.type.IType;
import org.apache.commons.lang3.StringUtils;

public class BooleanParse implements IType<Boolean> {
    /**
     * 基本类型
     * 这里特殊处理，认为 1也是 boolean
     */
    public static boolean parse(String value) {
        if(StringUtils.isBlank(value) || StringUtils.isEmpty(value)) return false;
        return Boolean.parseBoolean(value) || "1".equals(value);

    }
}
