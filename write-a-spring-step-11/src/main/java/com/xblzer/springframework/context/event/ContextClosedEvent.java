package com.xblzer.springframework.context.event;

/**
 * 监听关闭动作
 * @author 行百里者
 * @date 2022-08-08 12:48
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
