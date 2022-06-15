package com.example.face.service;

import java.util.List;
import java.util.Map;

/**
 * 操作类
 *
 * @author huangdaxian
 * @date 2022/05/14
 * @email 3081476398@qq.com
 **/
public interface FaceService {

    /**
     * 人脸对比
     * */
    String faceDiscern(String token, List<Object> list);


    /**
     * 人脸搜索与库管理
     * */
    String FaceData(String token, Map list);

    /**
     * 人脸注册
     * */
    void faceReg(Map map,String token);
}
