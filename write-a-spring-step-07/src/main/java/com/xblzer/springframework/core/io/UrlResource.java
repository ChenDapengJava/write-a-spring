package com.xblzer.springframework.core.io;

import cn.hutool.http.HttpConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author chenpeng
 * @date 2022-07-26 17:31
 */
public class UrlResource implements Resource {

    private URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = url.openConnection();
        try {
            return connection.getInputStream();
        } catch (Exception e) {
            if (connection instanceof HttpURLConnection) {
                ((HttpURLConnection) connection).disconnect();
            }
            throw e;
        }
    }

    public URL getUrl() {
        return url;
    }
}
