package com.example.face.service.impl;

import com.example.face.service.UploadService;
import com.example.face.utils.QiniuTokenUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 上传图片
 *
 * @author 搬砖的码农
 * @date 2022/05/14
 * @email
 **/
@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public String upload(InputStream file, String fileName){

        String path = QiniuTokenUtils.getQiniuTokenUtils().uploadOne(file,fileName);

        return path;
    }
}
