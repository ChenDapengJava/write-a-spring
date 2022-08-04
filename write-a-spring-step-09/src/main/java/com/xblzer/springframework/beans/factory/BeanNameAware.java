package com.xblzer.springframework.beans.factory;

/**
 * 实现此接口，就能感知到所属的 beanName
 * @author 行百里者
 * @date 2022-08-04 15:31
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);
}
