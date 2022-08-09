package com.xblzer.springframework.test.event;

import com.xblzer.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * 用于监听 CustomEvent 事件的监听器
 * @author 行百里者
 * @date 2022-08-08 15:49
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息，时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
