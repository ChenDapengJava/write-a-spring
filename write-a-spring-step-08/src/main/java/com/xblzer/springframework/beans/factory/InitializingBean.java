package com.xblzer.springframework.beans.factory;

import com.xblzer.springframework.beans.BeansException;

/**
 * 实现此接口的 Bean 对象，会在 BeanFactory 设置属性后作出相应的处理，
 * 如：执行自定义初始化，或者仅仅检查是否设置了所有强制属性。
 * @author 行百里者
 * @date 2022-08-03 17:57
 */
public interface InitializingBean {

    /**
     * Bean 处理属性填充后调用
     * @throws BeansException 抛出 BeansException 异常
     */
    void afterPropertiesSet() throws BeansException;
}
