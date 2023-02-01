package com.filesystem.podyml;

import com.filesystem.utils.CustomDateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author Man Yu
 * @version 2023/1/31
 */

@Service
public class PodYmlService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> query() {
        String sql = "select * from t_pod_yml";
        return jdbcTemplate.queryForList(sql);
    }

    public String create(String id, String url, Integer type) {
        String querySql = "select * from t_pod_yml where type = 1 and status = 1;";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(querySql);
        if(list.size() > 0) {
            list.forEach(item -> {
                String updateSql = "update t_pod_yml set status = 0 where id = '" + item.get("id") + "';";
                jdbcTemplate.update(updateSql);
            });
        }
        String createTimestamp = CustomDateUtil.getTime();
        String updateTimestamp = CustomDateUtil.getTime();
        String sql = "insert into t_pod_yml values ('" + id +
                "', '" + url +
                "', " + type +
                ", '" + createTimestamp +
                "', '" + updateTimestamp +
                "', 1);";
        try {
            jdbcTemplate.update(sql);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return "success";
    }
}
