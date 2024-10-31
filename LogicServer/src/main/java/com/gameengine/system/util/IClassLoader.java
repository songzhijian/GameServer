package com.gameengine.system.util;



/**
 * Created by lifangkai on 16/5/10.
 */
public interface IClassLoader {
    ClassLoader loadClasses(String[] paths, ClassLoader parentClassLoader) throws BootException;
}
