package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;

/**
 * @author chenpeng
 * @date 2022-07-26 17:01
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用 Bean 名称查询 BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 是否包含指定名称的 BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    boolean containsBeanDefinition(String beanName) throws BeansException;

    /**
     * 获取注册表中所有 Bean 的名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
