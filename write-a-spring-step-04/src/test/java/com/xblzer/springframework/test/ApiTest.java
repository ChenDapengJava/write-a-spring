package com.xblzer.springframework.test;

import com.xblzer.springframework.beans.PropertyValue;
import com.xblzer.springframework.beans.PropertyValues;
import com.xblzer.springframework.beans.factory.config.BeanDefinition;
import com.xblzer.springframework.beans.factory.config.BeanReference;
import com.xblzer.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xblzer.springframework.test.bean.UserDAO;
import com.xblzer.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author 行百里者
 * @date 2022-07-19 16:11
 */
public class ApiTest {

    @Test
    public void testBeanFactory() {
        //初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //UserDAO 注册
        BeanDefinition beanDefinition = new BeanDefinition(UserDAO.class);
        beanFactory.registerBeanDefinition("userDAO", beanDefinition);

        //设置 UserService 属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("userId", "1001"));
        //属性 userDAO 是引用类型
        propertyValues.addPropertyValue(new PropertyValue("userDAO", new BeanReference("userDAO")));
        System.out.println(propertyValues);

        //UserService 注册 带属性
        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));

        //获取 UserService 这个 Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.findUserById();
    }
}
