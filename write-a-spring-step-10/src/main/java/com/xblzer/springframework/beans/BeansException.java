package com.xblzer.springframework.beans;

/**
 * @author 行百里者
 * @date 2022-08-03 17:48
 */
public class BeansException extends RuntimeException {
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
