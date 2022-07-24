package com.xblzer.springframework.beans.factory.config;

/**
 * 单例注册表
 * @author 行百里者
 * @date 2022-07-23 20:14
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例对象
     * @param beanName Bean 名称
     * @return 单例对象
     */
    Object getSingleton(String beanName);
}
