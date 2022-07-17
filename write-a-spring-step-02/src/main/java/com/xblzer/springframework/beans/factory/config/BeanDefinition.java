package com.xblzer.springframework.beans.factory.config;

/**
 * BeanDefinition Bean定义
 * 在 Bean 定义类中已经把 Object bean 替换为 Class，这样就可以把 Bean 的实例化操作放到容器中处理了
 * @author 行百里者
 * @date 2022-07-17 22:08
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }
}
