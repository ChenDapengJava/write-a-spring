package com.xblzer.springframework.context.support;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.BeanPostProcessor;
import com.xblzer.springframework.context.ApplicationContext;
import com.xblzer.springframework.context.ApplicationContextAware;

/**
 * @author 行百里者
 * @date 2022-08-04 15:35
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 在 Bean 对象初始化之前，执行此方法
     *
     * @param bean     Bean 对象
     * @param beanName Bean 名称
     * @return Bean
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public Object postProfessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    /**
     * 在 Bean 对象初始化之后，执行此方法
     *
     * @param bean     Bean 对象
     * @param beanName Bean 名称
     * @return Bean
     * @throws BeansException 抛出 BeansException 异常
     */
    @Override
    public Object postProfessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
