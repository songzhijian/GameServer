package com.tool.utils;

import com.google.common.collect.Maps;

import java.util.Map;

public class WarnUtil {
    private static final String CONTENT_TEXT_KEY = "application/json";
    private static final String MSG_TYPE_KEY = "Content-Type";
    private static final String MSG_TYPE_TEXT_VALUE = "text";
    private static final String CONTENT_KEY = "content";

    public static boolean open = false;

    public static int index;

    private static String[][] url = new String[][]{{"https://mind.im30.net/api/hooks/yz4b67efpif47x7y91z1yq34fr",
            "https://mind.im30.net/api/hooks/j91wt6t8wjdjbycragx3my53ia"},
            {"https://mind.im30.net/api/hooks/udozsei4o3rr7my6cpmkt4o7py"}};

    public static Map<String,Object> buildTextData(String msg) {
        Map<String,Object> param = Maps.newHashMap();
        param.put(MSG_TYPE_KEY, CONTENT_TEXT_KEY);
        Map<String,Object> content = Maps.newHashMap();
        content.put(MSG_TYPE_TEXT_VALUE, msg);
        param.put(CONTENT_KEY, JsonUtil.toJson(content));
        return content;
    }

    public static void warn(String format,Object ... args) {
        if(open) {
            String[] urls = url[index];
            for (String url : urls) {
                HttpUtil.postJson(url,JsonUtil.toJson(buildTextData(String.format(format,args))));
            }
        }
    }

}
