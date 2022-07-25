package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 行百里者
 * @date 2022-07-23 20:17
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 获取单例对象
     *
     * @param beanName Bean 名称
     * @return 单例对象
     */
    @Override
    public Object getSingleton(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    public void addSingleton(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
