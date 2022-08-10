package com.xblzer.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author 行百里者
 * @date 2022-08-08 22:01
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
