package com.xblzer.springframework.beans.factory.config;

/**
 * 单例注册表
 * @author 行百里者
 * @date 2022-08-03 18:14
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
