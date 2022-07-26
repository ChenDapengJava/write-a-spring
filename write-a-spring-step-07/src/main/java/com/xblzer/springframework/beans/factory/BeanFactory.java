package com.xblzer.springframework.beans.factory;

import com.xblzer.springframework.beans.BeansException;

/**
 * @author 行百里者
 * @date 2022-07-25 22:25
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object[] args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
