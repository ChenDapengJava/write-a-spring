package com.xblzer.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 把 ClassPath、FileSystem、URL 三种资源类型加载进行包装
 * @author 行百里者
 * @date 2022-07-24 16:06
 */
public class DefaultResourceLoader implements ResourceLoader {
    /**
     * 根据指定位置获取资源
     *
     * @param location 资源地址
     * @return 加载的资源
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                return new UrlResource(new URL(location));
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
