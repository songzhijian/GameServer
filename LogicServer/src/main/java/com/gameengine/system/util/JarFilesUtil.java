package com.gameengine.system.util;

/**
 * Created by lifangkai on 16/5/10.
 */


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public final class JarFilesUtil {
    private static final String JAR_EXT = ".jar";

    public JarFilesUtil() {
    }

    public static List<String> scanFolderForJarFiles(String path) throws BootException {
        ArrayList jarFiles = new ArrayList();
        File theFolder = new File(path);
        if (!theFolder.isDirectory()) {
            throw new BootException("The provided path is not a directory: " + path);
        } else {
            for (File fileEntry : theFolder.listFiles()) {
                if (fileEntry.isFile()) {
                    String fileName = fileEntry.getName();
                    if (hasExtension(fileName, JAR_EXT)) {
                        jarFiles.add(path + "/" + fileName);
                    }
                }
            }
            return jarFiles;
        }
    }

    public static List<String> scanClassNamesInJarFile(String jarFilePath) throws BootException {
        ArrayList classNames = new ArrayList();

        try {
            JarFile e = new JarFile(jarFilePath);
            Enumeration entries = e.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = (JarEntry) entries.nextElement();
                if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                    String fqcName = entry.getName().replace('/', '.');
                    classNames.add(fqcName.substring(0, fqcName.length() - 6));
                }
            }

            return classNames;
        } catch (IOException e) {
            throw new BootException("Cannot access jar file: " + jarFilePath);
        }
    }

    private static boolean hasExtension(String fileName, String expectedExtension) {
        boolean isOk = false;
        if (fileName == null) {
            return isOk;
        } else {
            int extPos = fileName.lastIndexOf(46);
            if (extPos > 0) {
                String fileExt = fileName.substring(extPos);
                if (expectedExtension.equalsIgnoreCase(fileExt)) {
                    isOk = true;
                }
            }

            return isOk;
        }
    }
}
