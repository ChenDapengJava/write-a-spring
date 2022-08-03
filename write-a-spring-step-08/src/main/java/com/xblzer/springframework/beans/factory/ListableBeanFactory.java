package com.xblzer.springframework.beans.factory;

import com.xblzer.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author 行百里者
 * @date 2022-08-03 18:00
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 根据类型返回 Bean 实例
     * @param type 类型
     * @param <T> 泛型
     * @return Bean 实例 map 集合
     * @throws BeansException 抛出 BeansException 异常
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有 Bean 的名称
     * @return Bean 的名称数组
     * @throws BeansException 抛出 BeansException 异常
     */
    String[] getBeanDefinitionNames() throws BeansException;
}
