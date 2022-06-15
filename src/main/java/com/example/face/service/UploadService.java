package com.example.face.service;

import java.io.InputStream;

/**
 * @author huangdaxian
 * @date 2022/05/14
 * @email 3081476398@qq.com
 **/
public interface UploadService {
    String upload(InputStream file, String fileName);
}
