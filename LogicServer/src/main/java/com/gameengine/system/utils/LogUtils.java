package com.gameengine.system.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {

    public static final String Enter = "\n";
    public static final String Space = " ";
    public static final String Separator = "\t";

    private static int stackStrLength = 200000;

    public static final Logger logger = GameLoggerFactory.getLogger(LogUtils.class);

    public static String formatDialogString(String dialogStr, Object[] arr) {
        if (arr == null || arr.length == 0) {
            return dialogStr;
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean add = true;
        int n = 0;
        for (int i = 0; i < dialogStr.length(); i++) {
            char c = dialogStr.charAt(i);
            if (c == '{') {
                add = false;
                continue;
            } else if (c == '}') {
                add = true;
                stringBuilder.append(arr[n]);
                n++;
                continue;
            }
            if (add) {
                stringBuilder.append(c);
            }

        }
        return stringBuilder.toString();

    }

    public static void getStackTrace(StringBuilder sb, StackTraceElement[] sts) {
        writeStackTrace(sb, sts, 20);
        logger.warn(sb.toString());
    }

    private static void writeStackTrace(StringBuilder sb, StackTraceElement[] sts, int stackLen) {
        int i = 0;
        int len = Math.min(sts.length, stackLen);

        for (i = 0; i < len; ++i) {
            sb.append("#").append(i).append(" ").append(sts[i]).append(Enter);
        }

        if (sb.length() > stackStrLength) {
            sb.setLength(stackStrLength);
            sb.append("...");
        }
    }

    public static boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

}
