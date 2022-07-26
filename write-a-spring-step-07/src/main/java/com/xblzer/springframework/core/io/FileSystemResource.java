package com.xblzer.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenpeng
 * @date 2022-07-26 17:40
 */
public class FileSystemResource implements Resource {

    private String path;

    private File file;

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

    public File getFile() {
        return file;
    }
}
