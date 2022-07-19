package com.xblzer.springframework.beans.factory.config;

/**
 * 单例注册表
 * @author 行百里者
 * @date 2022-07-18 16:41
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例
     * @param beanName bean 名称
     * @return 单例
     */
    Object getSingleton(String beanName);

}
