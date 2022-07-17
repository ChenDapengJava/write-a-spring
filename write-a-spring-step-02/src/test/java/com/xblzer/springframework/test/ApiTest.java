package com.xblzer.springframework.test;

import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xblzer.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author 行百里者
 * @date 2022-07-17 23:11
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册 Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 第一次获取 Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
        // 第二次获取 Bean ，看是否从内存中直接获取（map中）
        UserService userService2 = (UserService) beanFactory.getBean("userService");
        userService2.getUserInfo();
    }
}
