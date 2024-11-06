package com.tool.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtil {

    public static void getFileList(File path, List<File> files) {
        if(path.isDirectory()) {
            File[] files1 = path.listFiles();
            for (File file : files1) {
                if(file.isFile()) {
                    files.add(file);
                } else {
                    getFileList(file,files);
                }
            }
        } else if(path.isFile()) {
            files.add(path);
        }
    }

    /**
     * 创建新文件写入
     * @param path
     * @param content
     * @throws IOException
     */
    public static void writeFile(String path, String content) throws IOException {
        Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

}
