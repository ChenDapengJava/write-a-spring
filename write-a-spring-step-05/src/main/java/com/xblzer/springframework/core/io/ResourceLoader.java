package com.xblzer.springframework.core.io;

/**
 * 包装加载资源接口
 * @author 行百里者
 * @date 2022-07-24 16:03
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    /**
     * 根据指定位置获取资源
     * @param location 资源地址
     * @return 加载的资源
     */
    Resource getResource(String location);
}
