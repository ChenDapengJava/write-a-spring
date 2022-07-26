package com.xblzer.springframework.test;

import com.xblzer.springframework.context.support.ClasspathXmlApplicationContext;
import com.xblzer.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author chenpeng
 * @date 2022-07-26 18:39
 */
public class ApiTest {

    @Test
    public void test_xml() {
        ClasspathXmlApplicationContext ctx = new ClasspathXmlApplicationContext("classpath:spring.xml");
        ctx.registerShutdownHook();

        UserService userService = ctx.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("result:" + result);
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }
}
