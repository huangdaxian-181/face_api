package com.example.face.utils;

import com.example.face.common.config.GlobalConfig;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 获取百度人脸设备验证token(单例模式)
 *
 * @author 搬砖的码农
 * @date 2022/05/13
 * @email
 **/

@Component
public class GetAccessTokenUtils {
    private static GetAccessTokenUtils getAccessTokenUtils;


    private GetAccessTokenUtils(){
    }

    public GetAccessTokenUtils getAccessToken(){
        return getAccessTokenUtils;
    }

    public static String getToken(){
        String token = getAuth(GlobalConfig.CLIENTID,GlobalConfig.CLIENT_SECRET);

        return token;
    }

    /**
     * 私有方法 内部调用
     * */
    private static String getAuth(String ak,String sk){
          /**
           * 访问地址
           * https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=Va5yQRHlA4Fq5eR3LT0vuXV4&client_secret=0rDSjzQ20XUj5itV6WRtznPQSzr5pVw2&
           * */
          String authHost = "https://aip.baidubce.com/oauth/2.0/token?";

          String getAccessTokenUrl = authHost
                  +"grant_type=client_credentials"
                  +"&client_id="+ ak
                  +"&client_secret="+sk;

          try{
              URL realUrl = new URL(getAccessTokenUrl);

              HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();

              connection.setRequestMethod("GET");

              connection.connect();

              //获取响应头字段
              Map<String,List<String>> map = connection.getHeaderFields();

              BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

              String result = "";

              String line;

              while ((line = bufferedReader.readLine()) != null){
                  result += line;
              }

              //返回结果
              JSONObject jsonObject = new JSONObject(result);

              String access_token = jsonObject.getString("access_token");

              return access_token;
          }
          catch (Exception e){
              System.err.printf("获取token失败！");
              e.printStackTrace();
          }

          return "";
    }




}
