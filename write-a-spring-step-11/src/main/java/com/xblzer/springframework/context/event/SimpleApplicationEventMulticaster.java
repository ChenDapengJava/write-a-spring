package com.xblzer.springframework.context.event;

import com.xblzer.springframework.beans.factory.BeanFactory;
import com.xblzer.springframework.context.ApplicationEvent;
import com.xblzer.springframework.context.ApplicationListener;

/**
 * @author 行百里者
 * @date 2022-08-08 15:00
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    /**
     * 事件广播
     *
     * @param event ApplicationEvent 事件
     */
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
