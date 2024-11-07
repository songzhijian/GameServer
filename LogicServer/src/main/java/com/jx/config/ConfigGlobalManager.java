package com.jx.config;

import com.gameengine.system.utils.ClazzUtils;
import com.gameengine.system.utils.LogUtils;
import com.jx.config.util.gen.support.ConfigLoader;
import com.jx.config.util.gen.support.IConfigCustomLoader;
import javassist.CtClass;

import java.lang.reflect.Method;
import java.util.List;

public class ConfigGlobalManager {
    public static final ConfigGlobalManager instance = new ConfigGlobalManager();

    public static String error;

    public static ConfigGlobalManager getInstance() {
        return instance;
    }

    public void loadAll(String[] filterNames) {
        List<CtClass> classes = ClazzUtils.findClassOneByAnotation("com.im30.esg.config.loader", ConfigLoader.class);
        List<CtClass> customClasses = ClazzUtils.findClassOneByInterface("com.im30.esg.config.custom", IConfigCustomLoader.class);
        long startTime = System.currentTimeMillis();

        for (CtClass ctClazz : classes) {
            try {
                if (!check(ctClazz.getSimpleName(), "ConfigLoader".length(), filterNames)) {
                    continue;
                }
                Class<?> clazz = Class.forName(ctClazz.getName());
                Method method = clazz.getDeclaredMethod("load");
                method.setAccessible(true);
                method.invoke(null);
            } catch (Exception e) {
                LogUtils.logger.error("数据加载异常 {}", ctClazz.getName(), e);
                throw new RuntimeException(e);
            }
        }
        ConfigGlobalManager.error = "";

        if (customClasses != null) {
            //TODO:加载刷新自定义的config类
            for (CtClass ctClazz : customClasses) {
                try {
                    if (!check(ctClazz.getSimpleName(), "ConfigCustomLoader".length(), filterNames)) {
                        continue;
                    }
                    Class clazz = Class.forName(ctClazz.getName());
                    Method method = clazz.getMethod("load");
                    method.invoke(null);
                } catch (Exception e) {
                    LogUtils.logger.error(e.getMessage(), e);
                    throw new RuntimeException(e);
                }
            }
        }
        LogUtils.logger.info("serial load config cost " + (System.currentTimeMillis() - startTime));
    }

    public boolean check(String name, int endLen, String[] filterNames) {

        if (filterNames == null) {
            return true;
        }

        String startName = name.substring(0, name.length() - endLen);

        for (String s : filterNames) {
            if (startName.equalsIgnoreCase(s)) {
                return true;
            }
        }

        return false;
    }

    public void init() {
        try {
            loadAll(null);
        } catch (Exception e) {
            System.exit(1);
            throw new RuntimeException(e);
        }
    }

    /**
     * load指定某块，或者所有
     *
     * @param content
     */
    public void load(String content) {
        String[] names = null;
        if (!"all".equalsIgnoreCase(content)) {
            names = content.split(",");
            for (int i = 0; i < names.length; i++) {
                names[i] = names[i].replace("_", "");
            }
        }

        try {
            loadAll(names);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
