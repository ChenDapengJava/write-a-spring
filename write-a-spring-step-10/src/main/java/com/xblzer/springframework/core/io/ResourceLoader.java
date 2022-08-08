package com.xblzer.springframework.core.io;

/**
 * @author 行百里者
 * @date 2022-08-04 12:05
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
