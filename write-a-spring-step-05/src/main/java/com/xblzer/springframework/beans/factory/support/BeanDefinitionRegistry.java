package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.factory.config.BeanDefinition;

/**
 * @author 行百里者
 * @date 2022-07-23 21:59
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 判断是否包含指定名称的 BeanDfinition
     * @param beanName Bean 的名称
     * @return 包含返回true，否则返回false
     */
    boolean containsBeanDefinition(String beanName);
}
