package com.xblzer.springframework.test.bean;

import com.xblzer.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author 行百里者
 * @date 2022-08-10 17:58
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    /**
     * Callback before a given method is invoked.
     *
     * @param method 被调用的方法
     * @param args   方法的参数
     * @param target target of the method invocation
     * @throws Throwable Throwable if this object wishes to abort the call.
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before 拦截方法：" + method.getName());
    }
}
