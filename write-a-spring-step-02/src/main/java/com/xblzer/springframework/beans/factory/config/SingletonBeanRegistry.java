package com.xblzer.springframework.beans.factory.config;

/**
 * 单例Bean注册接口的定义
 * @author 行百里者
 * @date 2022-07-17 22:25
 */
public interface SingletonBeanRegistry {

    /**
     * 获取单例
     * @param beanName Bean名称
     * @return 单例实体类
     */
    Object getSingleton(String beanName);
}
