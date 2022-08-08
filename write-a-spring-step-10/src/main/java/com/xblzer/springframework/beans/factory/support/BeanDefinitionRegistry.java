package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition 注册表
 * @author 行百里者
 * @date 2022-08-04 11:50
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注册 BeanDefinition
     * @param beanName Bean 名称
     * @param beanDefinition Bean 信息定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 根据 Bean 名称查询 BeanDefinition
     * @param beanName Bean 名称
     * @return BeanDefinition Bean 信息定义
     * @throws BeansException 抛出 BeansException 异常
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 是否包含 beanName 的 BeanDefinition
     * @param beanName Bean 名称
     * @return 包含返回true，否则返回false
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 返回注册表中所有 Bean 的名称
     * @return Bean 名称数组
     */
    String[] getBeanDefinitionNames();
}
