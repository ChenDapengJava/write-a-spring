package com.xblzer.springframework.context;

import com.xblzer.springframework.beans.BeansException;

/**
 * @author 行百里者
 * @date 2022-07-26 17:15
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 钩子，调用销毁方法
     */
    void registerShutdownHook();

    void close();
}
