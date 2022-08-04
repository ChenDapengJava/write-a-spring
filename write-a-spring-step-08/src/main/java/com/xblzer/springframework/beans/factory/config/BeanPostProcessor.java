package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.BeansException;

/**
 * 用于修改新实例化 Bean 对象的扩展点
 * @author 行百里者
 * @date 2022-08-03 18:15
 */
public interface BeanPostProcessor {

    /**
     * 在 Bean 对象初始化之前，执行此方法
     * @param bean Bean 对象
     * @param beanName Bean 名称
     * @return Bean
     * @throws BeansException 抛出 BeansException 异常
     */
    Object postProfessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象初始化之后，执行此方法
     * @param bean Bean 对象
     * @param beanName Bean 名称
     * @return Bean
     * @throws BeansException 抛出 BeansException 异常
     */
    Object postProfessAfterInitialization(Object bean, String beanName) throws BeansException;
}
