package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 行百里者
 * @date 2022-07-24 11:31
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    /**
     * 对象实例化
     *
     * @param beanDefinition Bean 定义
     * @param beanName       Bean 名称
     * @param ctor           构造函数
     * @param args           参数
     * @return 实例化对象
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (ctor != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Instantiate bean failed", e);
        }
    }
}
