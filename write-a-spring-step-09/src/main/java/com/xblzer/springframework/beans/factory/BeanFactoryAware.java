package com.xblzer.springframework.beans.factory;

import com.xblzer.springframework.beans.BeansException;

/**
 * 实现此接口，就能感知到所属的 BeanFactory
 * @author 行百里者
 * @date 2022-08-04 15:27
 */
public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
