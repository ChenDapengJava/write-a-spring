package com.xblzer.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author chenpeng
 * @date 2022-08-08 22:01
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
