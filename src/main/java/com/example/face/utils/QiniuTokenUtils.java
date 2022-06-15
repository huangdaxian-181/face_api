package com.example.face.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.http.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 七牛工具类
 *
 * @author 搬砖的码农
 * @date 2022/05/15
 * @email
 **/
@Component
public class QiniuTokenUtils {
    private static QiniuTokenUtils qiniuTokenUtils = new QiniuTokenUtils();

    private QiniuTokenUtils() {
    }


    public static QiniuTokenUtils getQiniuTokenUtils() {
        return qiniuTokenUtils;
    }


    /**
     * ak
     */
    private static final String ACCESSKEY = "XA1q0OPKgHCmiM8xSUi6FLzL-DY0Fz5JDAl7PZ_9";


    /**
     * sk
     */
    private static final String SECRETKEY = "Q6gHj3ot640FLoePtG7hKcnQgVWyv6JlLUOgvx5N";

    /**
     * 空间名称
     */
    private static final String BUCKET = "devour";


    /**
     * 地址
     * */
    private static final String DOMAIN = "http://img.devour.work/";

    private static String token;


    public void init() {

    }

    private String getToken() {
        Auth auth = Auth.create(ACCESSKEY, SECRETKEY);

        String upTOken = auth.uploadToken(BUCKET);


        return upTOken;
    }

    public String uploadOne(InputStream file, String fileName){

        Configuration cfg = new Configuration(Region.region2());

        UploadManager uploadManager = new UploadManager(cfg);

        try{

            Response response = uploadManager.put(file,fileName,getToken(),null,null);


            //解析上传成功结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(),DefaultPutRet.class);

            System.out.println(putRet.key);


            return DOMAIN+putRet.key;

        }
        catch (QiniuException ex){
            Response r = ex.response;
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }

        return "";
    }


}
