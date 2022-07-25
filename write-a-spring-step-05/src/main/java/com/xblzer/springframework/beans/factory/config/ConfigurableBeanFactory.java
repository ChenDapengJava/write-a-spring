package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author 行百里者
 * @date 2022-07-24 17:51
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
