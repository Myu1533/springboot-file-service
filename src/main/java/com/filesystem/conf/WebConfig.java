package com.filesystem.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Man Yu
 * @version 2023/1/19
 * @email manyu@hongtastock.com
 */
@Component
@ConfigurationProperties(prefix = "file-service")
public class WebConfig {

    private static String profile;

    public static String getProfile() {
        return profile;
    }

    public static void setProfile(String profile) {
        WebConfig.profile = profile;
    }

    public static String getFilePath() {
        return profile + "file/";
    }

    public static String getDownloadPath() {
        return profile + "download/";
    }

    public static String getUploadPath() {
        return profile + "upload/";
    }
}
