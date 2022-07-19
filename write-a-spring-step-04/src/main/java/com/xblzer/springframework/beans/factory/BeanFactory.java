package com.xblzer.springframework.beans.factory;

import com.xblzer.springframework.beans.BeansException;

/**
 * @author chenpeng
 * @date 2022-07-19 11:27
 */
public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

    Object getBean(String beanName, Object[] args) throws BeansException;
}
