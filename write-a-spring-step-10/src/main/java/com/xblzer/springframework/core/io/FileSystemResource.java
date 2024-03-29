package com.xblzer.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author 行百里者
 * @date 2022-08-04 12:09
 */
public class FileSystemResource implements Resource {

    private final String path;

    private final File file;

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.path = file.getPath();
        this.file = file;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }

    public final String getPath() {
        return path;
    }
}
