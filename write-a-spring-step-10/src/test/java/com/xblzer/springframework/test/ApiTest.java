package com.xblzer.springframework.test;

import com.xblzer.springframework.context.support.ClassPathXmlApplicationContext;
import com.xblzer.springframework.test.bean.UserService;
import com.xblzer.springframework.test.event.CustomEvent;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author 行百里者
 * @date 2022-08-04 15:47
 */
public class ApiTest {

    @Test
    public void test_event() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "发布事件成功了"));

        applicationContext.registerShutdownHook();


    }

}
