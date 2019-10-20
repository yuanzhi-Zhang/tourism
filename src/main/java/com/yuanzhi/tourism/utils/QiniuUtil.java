package com.yuanzhi.tourism.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.UrlSafeBase64;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/28 8:59
 */
public class QiniuUtil {

    // 在七牛注册后获得的accessKey和secretKey（改为自己的）
    private static String accessKey = "PlQetJcR-I2iTlbrQaOpV2wx3ISYsGjoBdCi5UEl";
    private static String secretKey = "sK6GGUcKR4-Bfd0bpcn81NLqX_CB532-yUgAmLxC";
    private static String bucket = "rwoxing"; // 七牛空间名（改为自己的）
    private static final String DOMAIN = "http://rwx.yuanz.top";

   // 获取覆盖同名文件的上传凭证
    public static String getToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, null, 3600, null, true); // 生成覆盖相同key文件的上传Token
        return upToken;
    }

    // 普通上传
    public static String upload(String filePath, String fileName) throws IOException {
        // 创建上传对象
        Configuration cfg = new Configuration(Zone.zone0());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            // 调用put方法上传
            if(StringUtils.isEmpty(upToken)) {
                System.out.println("未获取到token，请重试！");
                return null;
            }
            Response res = uploadManager.put(filePath, fileName, upToken);
            // 打印返回的信息
            System.out.println(res.bodyString());
            if (res.isOK()) {
                DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
                //如果不需要对图片进行样式处理，则使用以下方式即可
                return DOMAIN + putRet.key;
//                return DOMAIN + ret.key + "?" + style;
            }
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常信息
            System.err.println(r.toString());
            try {
                // 响应的文本信息
                System.err.println(r.bodyString());
            } catch (QiniuException e1) {
                // ignore
            }
        }
        return null;
    }

    //base64方式上传
    public static String put64image(byte[] base64, String key) throws Exception{
        String file64 = Base64.encodeToString(base64, 0);
        Integer len = base64.length;

        //华北空间使用 upload-z1.qiniu.com，华南空间使用 upload-z2.qiniu.com，北美空间使用 upload-na0.qiniu.com
        String url = "http://upload.qiniu.com/putb64/" + len + "/key/"+ UrlSafeBase64.encodeToString(key);

        RequestBody rb = RequestBody.create(null, file64);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getToken())
                .post(rb).build();
        //System.out.println(request.headers());
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
//        System.out.println(response);
        //如果不需要添加图片样式，使用以下方式
        return DOMAIN +"/"+ key;
//        return DOMAIN + key + "?" + style;
    }

    // 删除七牛中指定key的文件
    public static void delFile(String key) {
        // 构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Zone.zone0());
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            // 如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }

}
