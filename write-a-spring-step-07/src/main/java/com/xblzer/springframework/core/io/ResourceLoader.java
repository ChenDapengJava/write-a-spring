package com.xblzer.springframework.core.io;

/**
 * @author 行百里者
 * @date 2022-07-26 17:19
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
