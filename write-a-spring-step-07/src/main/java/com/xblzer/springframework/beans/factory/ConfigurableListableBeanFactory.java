package com.xblzer.springframework.beans.factory;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.BeanPostProfessor;
import com.xblzer.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author 行百里者
 * @date 2022-07-25 23:03
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    @Override
    void addBeanPostProfessor(BeanPostProfessor beanPostProfessor);
}
