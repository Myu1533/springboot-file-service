package com.filesystem.controller;

import com.filesystem.conf.WebConfig;
import com.filesystem.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Man Yu
 * @version 2023/1/31
 * @email manyu@hongtastock.com
 */
@RestController
@RequestMapping("file")
public class FIleUploadController {
    @Autowired
    private WebConfig webConfig;
    @PostMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                String fileName = FileUploadUtil.uploadFile(webConfig.getUploadPath(), file);
                System.out.println("filename:" + fileName);
            }
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}
