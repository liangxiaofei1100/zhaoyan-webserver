package com.zhaoyan.webserver.domain.bce;

import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.model.BosObjectSummary;
import com.baidubce.services.bos.model.ListObjectsRequest;
import com.baidubce.services.bos.model.ListObjectsResponse;
import com.baidubce.services.bos.model.PutObjectResponse;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * 百度BOS工具类
 */
public class BosUtils {
    /**
     * 以文件形式上传Object
     */
    public static void putFileObject(BosClient client, String bucketName,
                                     String objectKey, File file) {
        // 以文件形式上传Object
        PutObjectResponse putObjectFromFileResponse = client.putObject(
                bucketName, objectKey, file);
        // 打印ETag
        System.out.println(putObjectFromFileResponse.getETag());
    }

    /**
     * 以数据流形式上传Object
     */
    public static void putInputStreamObject(BosClient client, String bucketName,
                                            String objectKey, InputStream inputStream) {
        // 以数据流形式上传Object
        PutObjectResponse putObjectResponseFromInputStream = client.putObject(
                bucketName, objectKey, inputStream);
        // 打印ETag
        System.out.println(putObjectResponseFromInputStream.getETag());
    }

    /**
     * 以二进制串上传Object
     */
    public static void putBytesObject(BosClient client, String bucketName,
                                      String objectKey, byte[] bytes) {
        // 以二进制串上传Object
        PutObjectResponse putObjectResponseFromByte = client.putObject(
                bucketName, objectKey, bytes);
        // 打印ETag
        System.out.println(putObjectResponseFromByte.getETag());
    }

    /**
     * 以字符串上传Object
     */
    public static void putStringObject(BosClient client, String bucketName,
                                       String objectKey, String str) {
        // 以字符串上传Object
        PutObjectResponse putObjectResponseFromString = client.putObject(
                bucketName, objectKey, str);
        // 打印ETag
        System.out.println(putObjectResponseFromString.getETag());
    }

    public static void listObjects(BosClient client, String bucketName) {
        // 获取指定Bucket下的所有Object信息
        ListObjectsResponse listing = client.listObjects(bucketName);

        // 遍历所有Object
        for (BosObjectSummary objectSummary : listing.getContents()) {
            System.out.println("ObjectKey: " + objectSummary.getKey());
        }
    }

    /**
     * 列出指定目录下的所有object。
     */
    public static void listObjectsInDir(BosClient client, String bucketName, String dir) {
        // 构造ListObjectsRequest请求
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(
                bucketName);

        // 递归列出fun目录下的所有文件
        if (dir != null && !dir.endsWith("/")) {
            dir += "/";
        }
        listObjectsRequest.setPrefix(dir);

        ListObjectsResponse listing = client.listObjects(listObjectsRequest);

        // 遍历所有Object
        System.out.println("Objects:");
        for (BosObjectSummary objectSummary : listing.getContents()) {
            System.out.println(objectSummary.getKey());
        }
    }

    /**
     * 获取下载Object的URL
     * <p/>
     * 用户在调用该函数前，需要手动设置endpoint为所属Region域名。百度开放云目前开放了多区域（Region）支持，
     * 如您需要开通多Region服务，请您提交工单联系百度工程师帮助您开通。目前支持“华北-北京”和“华南-广州”两个Region。
     * 北京Region：http://bj.bcebos.com 广州Region：http://gz.bcebos.com
     *
     * @param expirationInSeconds expirationInSeconds为指定的URL有效时长，时间从当前时间算起，为可选参数，不配置时系统默认值为1800秒
     *                            。如果要设置为永久不失效的时间，可以将expirationInSeconds参数设置为 -1，不可设置为其他负数。
     */
    public static String generatePresignedUrl(BosClient client, String bucketName,
                                              String objectKey, int expirationInSeconds) {
        URL url = client.generatePresignedUrl(bucketName, objectKey,
                expirationInSeconds);
        // 指定用户需要下载的Object所在的Bucket名称、该Object名称、时间戳、URL的有效时长
        return url.toString();
    }
}
