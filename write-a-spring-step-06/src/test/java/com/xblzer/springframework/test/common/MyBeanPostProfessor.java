package com.xblzer.springframework.test.common;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.config.BeanPostProcessor;
import com.xblzer.springframework.test.bean.UserService;

/**
 * @author 行百里者
 * @date 2022-07-25 17:09
 */
public class MyBeanPostProfessor implements BeanPostProcessor {
    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("初始化之前，将location改为北京");
        }
        return bean;
    }

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
