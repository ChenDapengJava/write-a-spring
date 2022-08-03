package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author chenpeng
 * @date 2022-08-03 18:15
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    /**
     * 添加 BeanPostProfessor
     * @param beanPostProfessor BeanPostProfessor
     */
    void addBeanPostProfessor(BeanPostProfessor beanPostProfessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
