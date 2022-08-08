package com.xblzer.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 行百里者
 * @date 2022-08-04 12:04
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
