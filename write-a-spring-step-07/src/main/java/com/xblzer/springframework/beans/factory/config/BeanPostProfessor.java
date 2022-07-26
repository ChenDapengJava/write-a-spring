package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.BeansException;

/**
 * @author chenpeng
 * @date 2022-07-25 22:55
 */
public interface BeanPostProfessor {

    /**
     * 在 Bean 对象初始化之前，执行此方法
     * @param bean Bean 对象
     * @param beanName Bean 名称
     * @return 此方法执行后返回的 Bean 对象
     * @throws BeansException 抛出 BeansException 异常
     */
    Object postProfessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象初始化之后，执行此方法
     * @param bean Bean 对象
     * @param beanName Bean 名称
     * @return 此方法执行后返回的 Bean 对象
     * @throws BeansException 抛出 BeansException 异常
     */
    Object postProfessAfterInitialization(Object bean, String beanName) throws BeansException;
}
