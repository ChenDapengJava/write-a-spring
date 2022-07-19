package com.xblzer.springframework.beans.factory.config;

/**
 * Bean 的引用
 * @author chenpeng
 * @date 2022-07-19 15:56
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
