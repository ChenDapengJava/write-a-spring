package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.factory.config.BeanDefinition;

/**
 * @author chenpeng
 * @date 2022-07-18 17:42
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName Bean 名称
     * @param beanDefinition Bean 信息定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
