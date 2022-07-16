package com.xblzer.springframework.test;

import com.xblzer.springframework.BeanDefinition;
import com.xblzer.springframework.BeanFactory;
import com.xblzer.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 测试用例
 * @author 行百里者
 * @date 2022-07-16 22:49
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        //1. 初始化Bean工厂
        BeanFactory beanFactory = new BeanFactory();

        //2. 向Bean工厂注册一个Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        //3. 获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.getUserInfo();
    }
}
