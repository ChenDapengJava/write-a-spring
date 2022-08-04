package com.xblzer.springframework.context;

import com.xblzer.springframework.beans.BeansException;
import com.xblzer.springframework.beans.factory.Aware;

/**
 * 实现此接口，既能感知到所属的 ApplicationContext
 * @author 行百里者
 * @date 2022-08-04 15:33
 */
public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
