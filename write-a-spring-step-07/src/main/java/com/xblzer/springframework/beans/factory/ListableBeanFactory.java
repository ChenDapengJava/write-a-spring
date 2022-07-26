package com.xblzer.springframework.beans.factory;

import com.xblzer.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author 行百里者
 * @date 2022-07-25 22:27
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 根据类型返回 Bean 实例
     * @param type 类型
     * @param <T> 类的类型 泛型
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所有的 Bean 名称
     * @return Bean 名称数组
     * @throws BeansException
     */
    String[] getBeanDefinitionNames() throws BeansException;
}
