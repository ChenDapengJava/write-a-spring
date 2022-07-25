package com.xblzer.springframework.utils;

/**
 * @author 行百里者
 * @date 2022-07-24 15:46
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable e) {
            //获取当前线程 ClassLoader 失败，转而获取 system ClassLoader
        }
        if (classLoader == null) {
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
}
