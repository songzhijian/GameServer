package com.tool.config.type.primitive;

import com.tool.config.type.IType;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Haibara
 * @date 2021-12-17 01:02
 */
public class IntParse implements IType<Integer> {
    /**
     * 基本类型
     */
    public static int parse(String value) {
        if (StringUtils.isBlank(value)) return 0;
        return Integer.parseInt(value);
    }
}
