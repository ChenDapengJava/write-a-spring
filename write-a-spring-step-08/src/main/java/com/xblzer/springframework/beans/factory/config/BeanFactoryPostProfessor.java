package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * 允许自定义修改 BeanDefinition 属性信息
 * @author chenpeng
 * @date 2022-08-03 18:19
 */
public interface BeanFactoryPostProfessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory ConfigurableListableBeanFactory
     * @throws BeansException 抛出 BeansException 异常
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
