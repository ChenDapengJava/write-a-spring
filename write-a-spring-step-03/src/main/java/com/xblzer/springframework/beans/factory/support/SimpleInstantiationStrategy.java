package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * JDK 实例化策略
 * @author chenpeng
 * @date 2022-07-18 17:03
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    /**
     * 实例化方法
     *
     * @param beanDefinition Bean 信息定义
     * @param beanName       Bean 名称
     * @param ctor           构造方法 为了拿到符合入参信息相对应的构造函数
     * @param args           入参信息 最终实例化会用到
     * @return 实例化对象
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object... args) throws BeansException {
        //首先通过 beanDefinition 获取 Class 信息，这个 Class 信息是在 Bean 定义的时候传递进去的
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (ctor != null) {
                //有构造函数实例化
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                //无构造函数实例化
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}
