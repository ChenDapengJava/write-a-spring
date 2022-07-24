package com.xblzer.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取 InputStream 流的方法
 * 后续分别实现三种不同的流文件操作：classPath，FileSystem，URL
 * @author 行百里者
 * @date 2022-07-24 12:04
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
