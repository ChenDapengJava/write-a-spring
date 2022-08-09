package com.xblzer.springframework.beans.factory;

/**
 * 实现此接口，就能感知到所属的 ClassLoader
 * @author 行百里者
 * @date 2022-08-04 15:29
 */
public interface BeanClassLoaderAware extends Aware {

    void setClassLoader(ClassLoader classLoader);
}
