package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.BeansException;

/**
 * @author 行百里者
 * @date 2022-08-10 17:42
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     * @param beanClass Bean Class
     * @param beanName Bean 名称
     * @return Object
     * @throws BeansException BeansException
     */
    Object postProcessorBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}
