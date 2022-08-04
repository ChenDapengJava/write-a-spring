package com.xblzer.springframework.context;

import com.xblzer.springframework.beans.BeansException;

/**
 * @author chenpeng
 * @date 2022-08-04 12:17
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException BeansException
     */
    void refresh() throws BeansException;

    /**
     * 注册关闭的钩子
     */
    void registerShutdownHook();

    /**
     * 关闭
     */
    void close();
}
