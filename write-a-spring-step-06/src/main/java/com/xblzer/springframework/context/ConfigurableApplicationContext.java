package com.xblzer.springframework.context;

import com.xblzer.springframework.beans.BeansException;

/**
 * @author 行百里者
 * @date 2022-07-25 15:46
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 核心方法：刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
