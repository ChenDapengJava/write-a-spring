package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 行百里者
 * @date 2022-07-19 11:09
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

    /**
     * 实现一个保护的 addSingleton 方法，这个方法可以被继承此类的其他类调用
     * @param beanName Bean 名称
     * @param beanDefinition Bean 信息定义
     */
    protected void addSingleton(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
