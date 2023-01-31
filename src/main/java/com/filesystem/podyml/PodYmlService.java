package com.filesystem.podyml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Man Yu
 * @version 2023/1/31
 * @email manyu@hongtastock.com
 */

@Service
public class PodYmlService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> query() throws IOException {
        String sql = "select * from t_pod_yml";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    public String add() {
        String sql = "insert into t_pod_yml values ('1', 'test', 1, '2023-01-12 13:42:33', '2023-01-12 13:42:33', 1);";
        try {
            jdbcTemplate.update(sql);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
}
