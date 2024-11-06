package com.tool.utils;


import org.apache.commons.lang3.StringUtils;

import java.io.File;

public class ConfigUtils {

    public static final char UNDER_LINE = '_';
    public static final String SPLIT_VERTICAL_LINE = "\\|";
    public static final String SPLIT_SEMICOLON = ";";
    public static final String SPLIT_HORIZONTAL_LINE = "-";
    public static final String SPLIT_COLON = ":";
    public static final String SPLIT_COMMA = ",";
    public static final String SPLIT_UNDERSCORE = "_";
    public static final String SPLIT_DOT = "\\.";

    /**
     * 转换基本类型，基本类型直接返回自己，非基本类型的包装类型同样会返回自己
     * 包装类型会转换成基本类型返回
     */
    public static Class<?> primitiveType(Class<?> type) {
        if (type.isPrimitive()) {
            return type;
        }

        if (type == Integer.class) {
            return Integer.TYPE;
        }
        if (type == Long.class) {
            return Long.TYPE;
        }
        if (type == Boolean.class) {
            return Boolean.TYPE;
        }
        if (type == Double.class) {
            return Double.TYPE;
        }
        if (type == Float.class) {
            return Float.TYPE;
        }
        if (type == Byte.class) {
            return Byte.TYPE;
        }
        if (type == Short.class) {
            return Short.TYPE;
        }
        if (type == Character.class) {
            return Character.TYPE;
        }
        return type;
    }

    /**
     * 获取属性名
     */
    public static String getTypeName(Class<?> clazz) {
        return primitiveType(clazz).getSimpleName();
    }

    public static String charToUpper(String param) {
        if (StringUtils.isBlank(param)) {
            return "";
        }

        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; ++i) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c)) continue;
            if (c == UNDER_LINE)
                if (Character.isUpperCase(c) && i > 0) {
                    sb.append(UNDER_LINE);
                }

            sb.append(Character.toUpperCase(c));
        }

        return sb.toString();
    }

    /**
     * 驼峰转下划线
     */
    public static String camelToUnderline(String param) {
        if (StringUtils.isBlank(param)) {
            return "";
        }

        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; ++i) {
            char c = param.charAt(i);
            if (Character.isUpperCase(c) && i > 0) {
                sb.append(UNDER_LINE);
            }

            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    /**
     * 下划线转驼峰
     * eg : under_line_to_camel -> underLineToCamel
     */
    public static String underlineToCamel(String param) {
        if (StringUtils.isBlank(param)) {
            return "";
        }
        String temp = param.toLowerCase();
        int len = temp.length();
        StringBuilder sb = new StringBuilder(len);

        for (int i = 0; i < len; ++i) {
            char c = temp.charAt(i);
            if (c == UNDER_LINE) {
                ++i;
                if (i < len) {
                    sb.append(Character.toUpperCase(temp.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String firstToLowerCase(String param) {
        return StringUtils.isBlank(param) ? "" : param.substring(0, 1).toLowerCase() + param.substring(1);
    }

    public static String firstToUpperCase(String param) {
        return StringUtils.isBlank(param) ? "" : param.substring(0, 1).toUpperCase() + param.substring(1);
    }

    public static String getPackageNameByPath(String outputPath) {
        String path = outputPath.replace(File.separator, ".");
        // 注意，这里默认报名是从 com 是开始的，如果换了名字会有问题，到时候改一下就好了，或者改成 path.lastIndexOf("src.main.java") + 13. 虽然两个都不是很靠谱
        path = path.substring(path.lastIndexOf("com"));
        return path;
    }
}
