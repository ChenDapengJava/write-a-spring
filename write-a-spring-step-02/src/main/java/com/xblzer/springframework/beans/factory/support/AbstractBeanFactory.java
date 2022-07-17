package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.BeanFactory;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.DefaultSingletonRegistry;

/**
 * 抽象类定义模板方法
 * 继承了 DefaultSingletonRegistry ，也就具备了使用单例注册类方法
 *
 * @author 行百里者
 * @date 2022-07-17 22:33
 */
public abstract class AbstractBeanFactory extends DefaultSingletonRegistry implements BeanFactory {

    /**
     * 获取实例
     * 主要是对单例 Bean 对象的获取以及在获取不到时需要拿到 Bean 的定义做相应 Bean 实例化操作
     * @param name 实例名称
     * @return 实体类
     * @throws BeansException 抛出 Bean 异常信息
     */
    @Override
    public Object getBean(String name) throws BeansException {
        //获取单例类
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        //如果实体类为空，则创建实例（具备了创建实例的能力）
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    /**
     * 获取 Bean 定义
     * 由实现此抽象类的其他类做相应的实现
     * @param beanName Bean名称
     * @return Bean 的定义信息
     * @throws BeansException 抛出Bean异常
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 抽象方法：创建 Bean 实例
     * 由实现此抽象类的其他类做相应的实现
     * @param beanName Bean 名称
     * @param beanDefinition Bean 的定义信息
     * @return Bean 实体类
     * @throws BeansException 抛出Bean异常
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
