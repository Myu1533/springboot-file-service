package com.filesystem.podyml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Man Yu
 * @version 2023/1/31
 * @email manyu@hongtastock.com
 */
@RestController
@RequestMapping("pod")
public class PodYmlController {
    @Autowired
    private PodYmlService podYmlService;
    @GetMapping("/list")
    @ResponseBody
    public List<Map<String, Object>> getList() throws IOException {
        return podYmlService.query();
    }

    @PostMapping("/yml")
    @ResponseBody
    public String add() throws IOException {
        return podYmlService.add();
    }
}
