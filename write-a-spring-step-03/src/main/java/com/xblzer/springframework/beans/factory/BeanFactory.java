package com.xblzer.springframework.beans.factory;

import com.xblzer.springframework.beans.BeansException;

/**
 * @author 行百里者
 * @date 2022-07-18 15:55
 */
public interface BeanFactory {

    /**
     * 获取 Bean
     * @param name Bean 名称
     * @return Bean 对象
     * @throws BeansException 抛出 BeansException 异常
     */
    Object getBean(String name) throws BeansException;

    /**
     * 获取 Bean
     * @param name Bean 名称
     * @param args Bean 构造参数
     * @return Bean 对象
     * @throws BeansException 抛出 BeansException 异常
     */
    Object getBean(String name, Object... args) throws BeansException;

}
