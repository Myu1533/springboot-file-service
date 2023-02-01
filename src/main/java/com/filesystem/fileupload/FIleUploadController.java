package com.filesystem.fileupload;

import com.filesystem.conf.WebConfig;
import com.filesystem.podyml.PodYmlService;
import com.filesystem.utils.FileUploadUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Man Yu
 * @version 2023/1/31
 */
@RestController
@RequestMapping("file")
public class FIleUploadController {
    @Autowired
    private WebConfig webConfig;
    @Autowired
    private PodYmlService podYmlService;
    @PostMapping("/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file, @RequestParam("type") String type) {
        try {
            if (!file.isEmpty()) {
                String url = FileUploadUtil.uploadFile(webConfig.getUploadPath(), file);
                String fileName = StringUtils.substringAfterLast(url, "/");
                String id = StringUtils.substringBeforeLast(fileName, ".");

                podYmlService.create(id, url, Integer.valueOf(type));
            }
            return "success";
        } catch (Exception e) {
            return new Error(e);
        }
    }
}
