package com.xblzer.springframework.context;

import java.util.EventObject;

/**
 * 具备事件功能的抽象类
 * @author 行百里者
 * @date 2022-08-08 12:39
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
