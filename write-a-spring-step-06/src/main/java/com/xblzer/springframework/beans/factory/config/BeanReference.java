package com.xblzer.springframework.beans.factory.config;

/**
 * Bean 的引用
 * @author 行百里者
 * @date 2022-07-25 15:23
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
