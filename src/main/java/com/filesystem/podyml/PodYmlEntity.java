package com.filesystem.podyml;

import java.sql.Timestamp;

/**
 * @author Man Yu
 * @version 2023/1/31
 * @email manyu@hongtastock.com
 */
public class PodYmlEntity {
    private String id;
    private String url;
    private Integer type;
    private Timestamp create_timestamp;
    private Timestamp update_timestamp;
    private Integer status;

    public PodYmlEntity(String id, String url, Integer type, Timestamp create_timestamp, Timestamp update_timestamp, Integer status) {
        this.id = id;
        this.url = url;
        this.type = type;
        this.create_timestamp = create_timestamp;
        this.update_timestamp = update_timestamp;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Timestamp getCreate_timestamp() {
        return create_timestamp;
    }

    public void setCreate_timestamp(Timestamp create_timestamp) {
        this.create_timestamp = create_timestamp;
    }

    public Timestamp getUpdate_timestamp() {
        return update_timestamp;
    }

    public void setUpdate_timestamp(Timestamp update_timestamp) {
        this.update_timestamp = update_timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
