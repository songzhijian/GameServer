package com.tool.config.type.primitive;


import com.tool.config.type.IType;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Haibara
 * @date 2021-12-17 01:04
 */
public class LongParse implements IType<Long> {
    /**
     * 基本类型
     */
    public static long parse(String value) {
        if (StringUtils.isBlank(value)) return 0L;
        return Long.parseLong(value);
    }
}
