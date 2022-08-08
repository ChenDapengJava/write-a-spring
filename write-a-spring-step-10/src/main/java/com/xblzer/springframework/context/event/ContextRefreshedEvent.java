package com.xblzer.springframework.context.event;

/**
 * 监听刷新动作
 * @author 行百里者
 * @date 2022-08-08 12:49
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
