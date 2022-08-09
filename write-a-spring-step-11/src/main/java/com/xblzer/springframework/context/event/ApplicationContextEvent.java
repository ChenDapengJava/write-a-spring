package com.xblzer.springframework.context.event;

import com.xblzer.springframework.context.ApplicationContext;
import com.xblzer.springframework.context.ApplicationEvent;

/**
 * 定时事件
 * 所有的事件包括关闭、刷新，以及用户自己实现的事件，都需要继承这个类
 * @author 行百里者
 * @date 2022-08-08 12:41
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
