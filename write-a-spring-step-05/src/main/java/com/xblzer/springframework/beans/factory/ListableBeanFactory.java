package com.xblzer.springframework.beans.factory;

import com.xblzer.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author 行百里者
 * @date 2022-07-24 17:42
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 根据类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 返回注册表中所的 Bean 名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
