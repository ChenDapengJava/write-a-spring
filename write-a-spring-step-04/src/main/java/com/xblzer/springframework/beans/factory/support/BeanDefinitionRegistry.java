package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.factory.config.BeanDefinition;

/**
 * @author chenpeng
 * @date 2022-07-19 15:41
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
