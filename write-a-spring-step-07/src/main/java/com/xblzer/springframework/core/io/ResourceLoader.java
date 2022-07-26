package com.xblzer.springframework.core.io;

/**
 * @author chenpeng
 * @date 2022-07-26 17:19
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
