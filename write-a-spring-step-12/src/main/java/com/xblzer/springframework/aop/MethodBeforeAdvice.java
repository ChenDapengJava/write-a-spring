package com.xblzer.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author 行百里者
 * @date 2022-08-10 17:15
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    /**
     * Callback before a given method is invoked.
     * @param method 被调用的方法
     * @param args 方法的参数
     * @param target target of the method invocation
     * @throws Throwable Throwable if this object wishes to abort the call.
     */
    void before(Method method, Object[] args, Object target) throws Throwable;
}
