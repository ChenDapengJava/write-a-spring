package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author chenpeng
 * @date 2022-07-25 22:47
 */
public interface BeanFactoryPostProfessor {

    /**
     * 在所有的 BeanDefinition 加载完成后并且在实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
