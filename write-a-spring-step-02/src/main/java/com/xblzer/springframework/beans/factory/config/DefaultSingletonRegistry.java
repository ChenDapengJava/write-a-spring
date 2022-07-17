package com.xblzer.springframework.beans.factory.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认的单例注册接口
 * @author 行百里者
 * @date 2022-07-17 22:28
 */
public class DefaultSingletonRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 获取单例
     *
     * @param beanName Bean名称
     * @return 单例实体类
     */
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 注册单例 放到内存中，以hashMap承载
     * @param beanName Bean名称
     * @param singletonObject 单例类
     */
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
