package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenpeng
 * @date 2022-07-18 16:50
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 获取单例
     *
     * @param beanName bean 名称
     * @return 单例
     */
    @Override
    public Object getSingleton(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    protected void addSingleton(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
