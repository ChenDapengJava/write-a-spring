package com.xblzer.springframework;

import com.xblzer.springframework.bean.UserService;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author chenpeng
 * @date 2022-07-18 17:37
 */
public class ApiTest {

    @Test
    public void testInstantiate() {
        //初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //注册 Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        //获取 Bean
        UserService userService = (UserService) beanFactory.getBean("userService", "行百里者");
        userService.findUser();
    }
}
