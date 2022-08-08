package com.xblzer.springframework.context.event;

import com.xblzer.springframework.context.ApplicationEvent;
import com.xblzer.springframework.context.ApplicationListener;

/**
 * 事件广播器
 * @author 行百里者
 * @date 2022-08-08 12:51
 */
public interface ApplicationEventMulticaster {

    /**
     * 添加监听
     * @param listener ApplicationListener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 删除监听
     * @param listener ApplicationListener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 事件广播
     * @param event ApplicationEvent 事件
     */
    void multicastEvent(ApplicationEvent event);
}
