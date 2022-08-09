package com.xblzer.springframework.context;

import java.util.EventListener;

/**
 * @author 行百里者
 * @date 2022-08-08 12:53
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
