package com.tool.config.type.primitive;


import com.tool.config.type.IType;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Haibara
 * @date 2021-12-17 01:06
 */
public class FloatParse implements IType<Float> {
    /**
     * 基本类型
     */
    public static float parse(String value) {
        if (StringUtils.isBlank(value)) return 0f;
        return Float.parseFloat(value);
    }
}
