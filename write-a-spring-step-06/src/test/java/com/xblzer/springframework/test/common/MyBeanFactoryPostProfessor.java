package com.xblzer.springframework.test.common;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.PropertyValue;
import com.xblzer.springframework.beans.PropertyValues;
import com.xblzer.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author 行百里者
 * @date 2022-07-25 17:06
 */
public class MyBeanFactoryPostProfessor implements BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "修改为 字节"));
    }
}
