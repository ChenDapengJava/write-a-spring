package com.xblzer.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean工厂 包括了Bean的注册（注册Bean的定义信息）、获取Bean
 * @author 行百里者
 * @date 2022-07-16 22:30
 */
public class BeanFactory {

    /**
     * 用concurrentHashMap存放Bean的定义信息
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 注册Bean——向map容器中添加Bean信息
     * @param name Bean的名称最为map容器的key
     * @param beanDefinition Bean的定义信息
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(name, beanDefinition);
    }

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }
}
