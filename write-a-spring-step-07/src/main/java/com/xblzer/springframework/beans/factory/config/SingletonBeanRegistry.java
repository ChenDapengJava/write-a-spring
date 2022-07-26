package com.xblzer.springframework.beans.factory.config;

/**
 * @author 行百里者
 * @date 2022-07-25 22:38
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
