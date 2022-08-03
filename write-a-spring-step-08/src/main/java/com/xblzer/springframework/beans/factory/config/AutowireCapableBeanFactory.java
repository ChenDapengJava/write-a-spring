package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.BeanFactory;

/**
 * 有 Autowire 扩展能力的 BeanFactory
 * @author chenpeng
 * @date 2022-08-03 18:24
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     * @param existingBean 当前 Bean
     * @param beanName Bean 名称
     * @return 执行过方法后的 Bean
     * @throws BeansException 抛出 BeansException 异常
     */
    Object applyBeanPostProfessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;


    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessAfterInitialization 方法
     * @param existingBean 当前 Bean
     * @param beanName Bean 名称
     * @return 执行过方法后的 Bean
     * @throws BeansException 抛出 BeansException 异常
     */
    Object applyBeanPostProfessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
