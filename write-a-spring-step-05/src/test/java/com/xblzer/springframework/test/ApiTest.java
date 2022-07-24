package com.xblzer.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.xblzer.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xblzer.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.xblzer.springframework.core.io.DefaultResourceLoader;
import com.xblzer.springframework.core.io.Resource;
import com.xblzer.springframework.test.bean.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 行百里者
 * @date 2022-07-24 16:55
 */
public class ApiTest {

    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void testClassPath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @Test
    public void testXml() {
        //初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //读取配置文件 注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinition("classpath:spring.xml");
        //获取 bean
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.findUserById();
    }
}
