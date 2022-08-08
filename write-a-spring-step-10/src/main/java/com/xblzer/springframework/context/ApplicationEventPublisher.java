package com.xblzer.springframework.context;

/**
 * 所有的事件都需要从这个接口发布出去
 * @author 行百里者
 * @date 2022-08-08 14:48
 */
public interface ApplicationEventPublisher {

    /**
     * 发布事件
     * @param event 事件
     */
    void publishEvent(ApplicationEvent event);
}
