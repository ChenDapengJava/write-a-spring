package com.xblzer.springframework.beans.factory.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;

/**
 * @author 行百里者
 * @date 2022-07-17 22:54
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    /**
     * 创建 Bean 实例
     *
     * @param beanName       Bean 名称
     * @param beanDefinition Bean 的定义信息
     * @return Bean 实体类
     * @throws BeansException 抛出Bean异常
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            //这块会埋下一个坑，有构造函数入参的对象怎么处理？——反射？
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("实例化 Bean 失败", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
