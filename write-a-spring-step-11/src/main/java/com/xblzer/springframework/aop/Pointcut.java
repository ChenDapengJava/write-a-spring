package com.xblzer.springframework.aop;

/**
 * 切入点接口，定义用于获取 ClassFilter、MethodMatcher 的两个类，这两个接口获取都是切点表达式提供的内容
 * @author 行百里者
 * @date 2022-08-08 21:59
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
