package com.example.face.controller;

import com.example.face.service.FaceService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.face.utils.GetAccessTokenUtils;

/**
 * 首页类
 *
 * @author 搬砖的码农
 * @date 2022/05/13
 * @email
 **/
@RestController
public class IndexController {

    @Autowired
    private FaceService faceService;

    /**
     * 人脸对比
     */
    @PostMapping("/faceContrast")
    @ResponseBody
    public void faceContrast() {
        String token = GetAccessTokenUtils.getToken();

        List<Object> list = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        String uri = "http://120.26.217.42/1.jpg";
        map1.put("image", uri);
        map1.put("image_type", "URL");
        map1.put("face_type", "LIVE");
        map1.put("quality_control", "NONE");
        map1.put("liveness_control", "NONE");
        list.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        String uri1 = "http://120.26.217.42/1.jpg";
        map2.put("image", uri1);
        map2.put("image_type", "URL");
        map2.put("face_type", "LIVE");
        map2.put("quality_control", "NONE");
        map2.put("liveness_control", "NONE");
        list.add(map2);

        String result = faceService.faceDiscern(token, list);

        JSONObject jsonObject = new JSONObject(result);

        String error_msg = jsonObject.getString("error_msg");

        int timestamp = jsonObject.getInt("timestamp");


        if (!error_msg.equals("SUCCESS")) {
            System.out.println("发生错误");
        }


        JSONObject jo = jsonObject.getJSONObject("result");

        if (jo.getInt("score") == 0) {
            System.out.println("相似度为:" + jo.getInt("score"));
        } else {
            System.out.println("相似度为:" + jo.getInt("score"));
        }

    }


    /**
     * 人脸搜索与库管理
     */
    @PostMapping("/faceSearchMana")
    @ResponseBody
    public void faceSearchMana() {
        String token = GetAccessTokenUtils.getToken();

        List<Object> list = new ArrayList<>();

        Map<Object, String> map = new HashMap<>(3);
        map.put("image", "http://120.26.217.42/2.jpeg");
        map.put("image_type", "URL");
        map.put("group_id_list", "d_2022");

        String result = faceService.FaceData(token, map);

        JSONObject jsonObject = new JSONObject(result);

        Object score = jsonObject.getJSONObject("result").getJSONArray("user_list").getJSONObject(0).get("score");

        if (Integer.parseInt(score.toString()) > 80) {
            System.out.println("匹配成功");
            return;
        }

        System.out.println("不匹配");
        return;
    }


    /**
     * 人脸注册
     */
    @PostMapping("/faceRegister")
    @ResponseBody
    public void faceRegister() {
        String token = GetAccessTokenUtils.getToken();

        Map<String,Object> map = new HashMap<>(5);

        String group_id = "d_2022";

        String user_id = "z_2";

        map.put("image","http://img.devour.work/9e8947b10e1f41fb916f4e1adb4bc560");
        map.put("image_type","URL");
        map.put("group_id",group_id);
        map.put("user_id",user_id);
        map.put("user_info","帅哥的照片");

        faceService.faceReg(map,token);
    }
}
