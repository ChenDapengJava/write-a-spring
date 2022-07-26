package com.xblzer.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenpeng
 * @date 2022-07-26 17:19
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
