package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author 行百里者
 * @date 2022-07-25 15:23
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

}
