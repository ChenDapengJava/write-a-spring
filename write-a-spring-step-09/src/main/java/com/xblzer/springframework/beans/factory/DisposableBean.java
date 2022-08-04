package com.xblzer.springframework.beans.factory;

/**
 * @author 行百里者
 * @date 2022-08-03 17:59
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
