package com.xblzer.springframework;

/**
 * 定义Bean的实例化信息
 * @author 行百里者
 * @date 2022-07-16 22:27
 */
public class BeanDefinition {

    /**
     * 用一个Object存放bean对象
     */
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
