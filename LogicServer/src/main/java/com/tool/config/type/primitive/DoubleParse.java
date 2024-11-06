package com.tool.config.type.primitive;

import com.tool.config.type.IType;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Haibara
 * @date 2021-12-17 01:05
 */
public class DoubleParse implements IType<Double> {
    /**
     * 基本类型
     */
    public static double parse(String value) {
        if (StringUtils.isBlank(value)) return 0D;
        return Double.parseDouble(value);
    }
}
