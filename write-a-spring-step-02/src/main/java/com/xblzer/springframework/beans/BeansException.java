package com.xblzer.springframework.beans;

/**
 * 定义 Bean 异常类
 * @author 行百里者
 * @date 2022-07-17 21:50
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
