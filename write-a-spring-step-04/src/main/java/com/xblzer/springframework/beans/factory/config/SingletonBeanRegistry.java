package com.xblzer.springframework.beans.factory.config;

/**
 * @author 行百里者
 * @date 2022-07-19 11:08
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例对象
     * @param beanName Bean 名称
     * @return 单例对象
     */
    Object getSingleton(String beanName);
}
