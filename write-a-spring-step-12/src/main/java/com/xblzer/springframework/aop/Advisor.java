package com.xblzer.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author 行百里者
 * @date 2022-08-10 17:19
 */
public interface Advisor {

    Advice getAdvice();
}
