package com.xblzer.springframework.beans.factory.config;

import com.xblzer.springframework.beans.PropertyValues;

/**
 * @author chenpeng
 * @date 2022-07-19 11:07
 */
public class BeanDefinition {

    /**
     * 类定义
     */
    private Class beanClass;

    /**
     * 属性定义
     */
    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        //防止空指针异常
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        //防止空指针异常
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }
}
