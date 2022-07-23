package com.xblzer.springframework.beans;

/**
 * @author 行百里者
 * @date 2022-07-19 11:06
 */
public class BeansException extends RuntimeException {
    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
