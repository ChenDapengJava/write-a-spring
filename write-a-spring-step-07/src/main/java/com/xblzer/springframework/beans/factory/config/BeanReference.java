package com.xblzer.springframework.beans.factory.config;

/**
 * @author 行百里者
 * @date 2022-07-25 22:38
 */
public class BeanReference {

    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
