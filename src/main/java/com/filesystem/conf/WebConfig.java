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

    private String profile;

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getFilePath() {
        return profile + "file/";
    }

    public String getDownloadPath() {
        return profile + "download/";
    }

    public String getUploadPath() {
        return profile + "pod/";
    }
}
