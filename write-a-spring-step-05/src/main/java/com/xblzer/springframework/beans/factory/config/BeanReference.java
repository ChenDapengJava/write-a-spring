package com.xblzer.springframework.beans.factory.config;

/**
 * @author 行百里者
 * @date 2022-07-23 20:13
 */
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
