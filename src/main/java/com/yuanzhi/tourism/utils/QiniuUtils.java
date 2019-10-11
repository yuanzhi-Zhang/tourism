package com.yuanzhi.tourism.utils;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/28 8:59
 */
public class QiniuUtils {

    // 在七牛注册后获得的accessKey和secretKey（改为自己的）
//    private static String accessKey = "PlQetJcR-I2iTlbrQaOpV2wx3ISYsGjoBdCi5UEl";
//    private static String secretKey = "sK6GGUcKR4-Bfd0bpcn81NLqX_CB532-yUgAmLxC";
//    private static String bucket = "rwoxing"; // 七牛空间名（改为自己的）
//
////    // 获取覆盖同名文件的上传凭证
//    public static String getToken(String key) {
//        Auth auth = Auth.create(accessKey, secretKey);
//        String upToken = auth.uploadToken(bucket, key, 3600, null, true); // 生成覆盖相同key文件的上传Token
//        return upToken;
//    }
//
//    // 删除七牛中指定key的文件
//    public static void delFile(String key) {
//        // 构造一个带指定Zone对象的配置类
//        Configuration cfg = new Configuration(Zone.zone0());
//        Auth auth = Auth.create(accessKey, secretKey);
//        BucketManager bucketManager = new BucketManager(auth, cfg);
//        try {
//            bucketManager.delete(bucket, key);
//        } catch (QiniuException ex) {
//            // 如果遇到异常，说明删除失败
//            System.err.println(ex.code());
//            System.err.println(ex.response.toString());
//        }
//    }

}
