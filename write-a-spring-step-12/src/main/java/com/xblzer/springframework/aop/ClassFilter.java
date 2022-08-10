package com.xblzer.springframework.aop;

/**
 * 定义类匹配类，用于切点找到给定的接口和目标类
 * @author 行百里者
 * @date 2022-08-08 22:00
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
