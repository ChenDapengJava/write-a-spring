package com.xblzer.springframework.beans.factory;

import com.xblzer.springframework.beans.BeansException;

/**
 * @author 行百里者
 * @date 2022-07-17 22:35
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;

}
