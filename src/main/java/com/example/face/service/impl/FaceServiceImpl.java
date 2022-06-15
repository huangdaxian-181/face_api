package com.example.face.service.impl;

import com.example.face.service.FaceService;
import com.example.face.utils.GsonUtils;
import com.example.face.utils.HttpUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @author 搬砖的码农
 * @date 2022/05/14
 * @email
 **/
@Service
public class FaceServiceImpl implements FaceService {

    /**
     * 人脸对比
     */
    @Override
        public String faceDiscern(String token, List<Object> list) {
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/match";
        try {
            String params = GsonUtils.toJson(list);

            String result = HttpUtil.post(url, token, "application/json", params);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 人脸搜索与库管理
     */
    @Override
    public String FaceData(String token, Map list) {

        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
           String params = GsonUtils.toJson(list);

           String result = HttpUtil.post(url,token,"application/json",params);

           return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
    /**
     * 人脸注册
     * */
    @Override
    public void faceReg(Map map,String token){

          String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
          try{
              String params = GsonUtils.toJson(map);

              String result = HttpUtil.post(url,token,params);

              System.out.println(result);
          }
          catch (Exception e){
              e.printStackTrace();
          }
    }
}
