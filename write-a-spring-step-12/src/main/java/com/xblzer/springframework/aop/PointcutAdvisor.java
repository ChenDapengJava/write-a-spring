package com.xblzer.springframework.aop;

/**
 * PointcutAdvisor 承担了 Pointcut 和 Advice 的组合，
 * Pointcut 用于获取 JoinPoint，而 Advice 决定于 JoinPoint 执行什么操作。
 * @author 行百里者
 * @date 2022-08-10 17:23
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
