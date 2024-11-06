package com.tool.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.util.Map;

public class TemplateUtil {

    private static final Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
    static {
        configuration.setNumberFormat("#");
        // 第三步：设置模板文件使用的字符集。一般就是utf-8.
        configuration.setDefaultEncoding("utf-8");
    }
    public static void make(String tmpPath,String tmpName, String outFile, Map<String,Object> param) {
        try {
            if(tmpPath == null) {
                return;
            }
            configuration.setDirectoryForTemplateLoading(new File(tmpPath));
            Template template = configuration.getTemplate(tmpName);
            File file = new File(outFile);
            File parentFile = file.getParentFile();
            if(!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                if(file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                Writer out = new FileWriter(file);
                System.out.println(outFile);
//        // 第六步：调用模板对象的process方法输出文件。
                template.process(param, out);
//
//        // 第七步：关闭流。
                out.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Template get(String tmpName) {
        try {
            // 第一步：创建一个Configuration对象，直接new一个对象。构造方法的参数就是FreeMarker对于的版本号。
            Configuration configuration = new Configuration(Configuration.getVersion());
            URL template1 = TemplateUtil.class.getClassLoader().getResource("template");
            // 第二步：设置模板文件所在的路径。
            configuration.setDirectoryForTemplateLoading(new File(template1.getFile()));
            configuration.setNumberFormat("#");
            // 第三步：设置模板文件使用的字符集。一般就是utf-8.
            configuration.setDefaultEncoding("utf-8");
            // 第四步：加载一个模板，创建一个模板对象。
            return configuration.getTemplate(tmpName);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
