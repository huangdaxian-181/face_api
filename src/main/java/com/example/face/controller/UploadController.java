package com.example.face.controller;

import com.example.face.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 上传控制器
 *
 * @author 搬砖的码农
 * @date 2022/05/15
 * @email
 **/
@RestController
public class UploadController {
    @Autowired
    UploadService uploadService;

    @PostMapping("/upload")
    @ResponseBody
    public void upload(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {

        try {
            String getOriginalFilename = file.getOriginalFilename();

            String fileName = UUID.randomUUID().toString().replace("-", "").toLowerCase();

            InputStream inputStream = (InputStream) file.getInputStream();

            String path = uploadService.upload(inputStream, fileName);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
