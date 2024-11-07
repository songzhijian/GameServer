package com.tool;

import com.tool.config.GameConfigGen;

public class Tool {

    public static String SYSTEM_NAME;
    public static void main(String[] args) {

//        if(args.length<1) {
//            System.out.println("参数不足");
//            return;
//        }
        SYSTEM_NAME = System.getProperty("os.name");
        args = new String[]{"config", "all"};
        String arg = args[0].toLowerCase();
        switch (arg) {
            case "config" :
                GameConfigGen.genCrossSheet(args);
                break;
        }
    }

    public static boolean isLinux() {
        return SYSTEM_NAME.equalsIgnoreCase("linux");
    }
}

