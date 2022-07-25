package com.xblzer.springframework.core.io;

import cn.hutool.core.lang.Assert;
import com.xblzer.springframework.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassPath 流文件操作
 * @author 行百里者
 * @date 2022-07-24 15:41
 */
public class ClassPathResource implements Resource {

    private final String path;

    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path,"Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    /**
     * 基于 ClassLoader 读取 ClassPath 下的文件信息
     * @return InputStream
     */
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(path);
        if (is == null) {
            throw new FileNotFoundException(path + "不存在，无法获取文件流");
        }
        return is;
    }
}
