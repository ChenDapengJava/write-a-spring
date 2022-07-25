package com.xblzer.springframework.test;

import com.xblzer.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.xblzer.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.xblzer.springframework.context.support.ClasspathXmlApplicationContext;
import com.xblzer.springframework.test.bean.UserService;
import com.xblzer.springframework.test.common.MyBeanFactoryPostProfessor;
import com.xblzer.springframework.test.common.MyBeanPostProfessor;
import org.junit.Test;

/**
 * @author 行百里者
 * @date 2022-07-25 17:00
 */
public class ApiTest {

    @Test
    public void testBeanFactoryPostProfessorAndBeanPostProfessor() {
        // 1. 创建 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 读取配置文件、注册 Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");
        // 3. BeanDefinition 加载完成、Bean 实例化之前修改 BeanDefinition 属性值
        MyBeanFactoryPostProfessor myBeanFactoryPostProfessor = new MyBeanFactoryPostProfessor();
        myBeanFactoryPostProfessor.postProcessBeanFactory(beanFactory);
        // 4. Bean 实例化之后，修改 Bean 属性信息
        MyBeanPostProfessor myBeanPostProfessor = new MyBeanPostProfessor();
        beanFactory.addBeanPostProcessor(myBeanPostProfessor);
        // 5. 获取 Bean 对象，调用方法
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.findUserById();
    }

    @Test
    public void testClasspathXml() {
        // 1. 初始化 BeanFactory
        ClasspathXmlApplicationContext ctx = new ClasspathXmlApplicationContext("classpath:springPostProfessor.xml");
        // 2. 获取 Bean 对象，调用方法
        UserService userService = ctx.getBean("userService", UserService.class);
        userService.findUserById();
    }
}
