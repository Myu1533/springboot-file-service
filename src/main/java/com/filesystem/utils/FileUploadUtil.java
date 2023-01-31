package com.filesystem.utils;

import com.filesystem.conf.WebConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Man Yu
 * @email manyu@hongtastock.com
 * @version 2023/1/30
 */
public class FileUploadUtil {
    @Autowired
    private WebConfig webConfig;
    public static final long DEFAULT_MAX_SIZE = 50 * 1024 * 1024;

    public static final int DEFAULT_FILE_NAME_LENGTH = 100;

    private String defaultBaseDir = webConfig.getProfile();

    public static final String FILE_EXTENSION = ".yml";

    private static int counter = 0;

    public void setDefaultBaseDir(String defaultBaseDir) {
        this.defaultBaseDir = defaultBaseDir;
    }

    public String getDefaultBaseDir() {
        return defaultBaseDir;
    }

    public static final String uploadFile(String baseDir, MultipartFile file) throws IOException {
        try {
            return upload(baseDir, file, FileUploadUtil.FILE_EXTENSION);
        } catch (Exception e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    public static final String uploadText(String baseDir, MultipartFile file) throws IOException {
        try {
            return upload(baseDir, file, ".txt");
        } catch (Exception e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    public static final String upload(String baseDir, MultipartFile file, String extension) throws IOException {
        int fileNameLength = file.getOriginalFilename().length();
        if (fileNameLength > FileUploadUtil.DEFAULT_FILE_NAME_LENGTH) {
            System.out.println("文件名过长");
        }

        assertAllowed(file);

        String fileName = extractFilename(file, extension);

        File desc = getAbsoluteFile(baseDir, baseDir + fileName);

        file.transferTo(desc);
        return fileName;
    }

    public static final String extractFilename(MultipartFile file, String extension) {
        String filename = file.getOriginalFilename();
        filename = CustomDateUtil.datePath() + "/" + encodingFilename(filename) + extension;
        return filename;
    }

    private static final File getAbsoluteFile(String uploadDir, String filename) throws IOException {
        File desc = new File(File.separator + filename);

        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }

        if (!desc.exists()) {
            desc.createNewFile();
        }

        return desc;
    }

    private static final String encodingFilename(String filename) {
        filename = filename.replace("_", "");
        filename = MD5Util.hash(filename + System.nanoTime() + counter++);
        return filename;
    }

    public static final void assertAllowed(MultipartFile file) {
        long size = file.getSize();
        if (size > DEFAULT_MAX_SIZE) {
            System.out.println("文件大小过大");
        }
    }
}
