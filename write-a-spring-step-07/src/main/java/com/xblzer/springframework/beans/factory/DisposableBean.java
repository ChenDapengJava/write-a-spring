package com.xblzer.springframework.beans.factory;

/**
 * @author chenpeng
 * @date 2022-07-25 23:26
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
