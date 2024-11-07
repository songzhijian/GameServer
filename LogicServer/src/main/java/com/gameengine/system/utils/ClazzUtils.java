package com.gameengine.system.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Modifier;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ClazzUtils {
    /**
     * 从jar中，根据报名找带有注解class
     *
     * @return
     */
    private static Map<String,List<CtClass>> findClassFromJar(String packageName, Map<String,List<CtClass>> maps,Function<CtClass,Boolean> function, Class<?> ... annotationClazzs) {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        final String BASE_PACKAGE = packageName;
        final String RESOURCE_PATTERN = "/**/*.class";
        try {
            String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                    ClassUtils.convertClassNameToResourcePath(BASE_PACKAGE) + RESOURCE_PATTERN;
            Resource[] resources = resourcePatternResolver.getResources(pattern);
            //MetadataReader 的工厂类
            MetadataReaderFactory readerfactory = new CachingMetadataReaderFactory(resourcePatternResolver);
            for (Resource resource : resources) {
                //用于读取类信息
                MetadataReader reader = readerfactory.getMetadataReader(resource);
                //扫描到的class
                String classname = reader.getClassMetadata().getClassName();
                CtClass clazz = ClassPool.getDefault().get(classname);
                //判断是否有指定主解
                for (Class<?> annotationClazz : annotationClazzs) {
                    if(clazz.getName().startsWith("com.im30.esg.starter.")) {
                        continue;
                    }
                    if (function.apply(clazz)) {
                        List<CtClass> classes = maps.get(annotationClazz.getName());
                        if(classes == null) {
                           classes = Lists.newArrayList();
                           maps.put(annotationClazz.getName(),classes);
                        }
                        classes.add(clazz);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maps;
    }

    public static List<CtClass> findClassOneByInterface(String packageName, Class<?> interfaceClazz) {
        Map<String,List<CtClass>> maps = Maps.newHashMap();
        CtClass interfaceC = null;
        try {
            interfaceC = ClassPool.getDefault().get(interfaceClazz.getName());
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
        CtClass tempClazz = interfaceC;
        Map<String, List<CtClass>> classFromJar = findClassFromJar(packageName, maps,(clazz)->{
            try {
                if(Modifier.isAbstract(clazz.getModifiers())) {
					return false;
				}

                return  clazz.subtypeOf(tempClazz);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } ,interfaceClazz);
        return classFromJar.get(interfaceClazz.getName());
    }

    public static  List<CtClass> findClassOneByAnotation(String packageName, Class<?> annotationClazz) {
        Map<String,List<CtClass>> maps = Maps.newHashMap();
        Map<String, List<CtClass>> classFromJar = findClassFromJar(packageName, maps,(clazz)->{
			if(Modifier.isAbstract(clazz.getModifiers())) {
				return false;
			}
            return clazz.hasAnnotation(annotationClazz);
        } ,annotationClazz);
        return classFromJar.get(annotationClazz.getName());
    }

    private static  Map<String,List<CtClass>> findClass(String packageName, Function<CtClass,Boolean> function, Class<?>... annotationClazz) {
        Map<String,List<CtClass>> maps = Maps.newHashMap();
        return findClassFromJar(packageName, maps,function,annotationClazz);
    }

}
