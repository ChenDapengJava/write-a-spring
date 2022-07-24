package com.xblzer.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 通过指定文件路径的方式读取文件信息
 * @author 行百里者
 * @date 2022-07-24 15:55
 */
public class FileSystemResource implements Resource {

    private final String path;

    private final File file;

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    public String getPath() {
        return path;
    }
}
