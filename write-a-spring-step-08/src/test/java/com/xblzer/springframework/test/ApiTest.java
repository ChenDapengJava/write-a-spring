package com.xblzer.springframework.test;

import com.xblzer.springframework.context.support.ClassPathXmlApplicationContext;
import com.xblzer.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author 行百里者
 * @date 2022-08-04 15:47
 */
public class ApiTest {

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);

        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());

    }
}
