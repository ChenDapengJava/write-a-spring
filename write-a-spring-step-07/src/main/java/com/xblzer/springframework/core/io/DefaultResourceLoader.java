package com.xblzer.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author chenpeng
 * @date 2022-07-26 17:45
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "location must not be null.");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClasspathResource(location);
        } else {
            try {
                return new UrlResource(new URL(location));
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
