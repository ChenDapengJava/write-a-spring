package com.xblzer.springframework.beans.factory.config;

/**
 * @author chenpeng
 * @date 2022-07-25 22:38
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
