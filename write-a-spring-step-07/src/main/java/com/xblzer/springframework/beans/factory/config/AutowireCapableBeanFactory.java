package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.BeanFactory;

/**
 * @author chenpeng
 * @date 2022-07-25 22:40
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProfessor 接口实现类的 postProfessorBeforeInitialization 方法
     * @param existingBean 已经实例化的 Bean
     * @param beanName Bean 名称
     * @return 执行 postProfessorBeforeInitialization 方法后的 Bean 对象
     * @throws BeansException 抛出 BeansException 异常
     */
    Object applyBeanPostProfessorBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProfessor 接口实现类的 postProfessorAfterInitialization 方法
     * @param existingBean 已经实例化的 Bean
     * @param beanName Bean 名称
     * @return 执行 postProfessorBeforeInitialization 方法后的 Bean 对象
     * @throws BeansException 抛出 BeansException 异常
     */
    Object applyBeanPostProfessorAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
