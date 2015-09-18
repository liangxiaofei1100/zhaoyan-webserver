package com.zhaoyan.webserver.domain.bce;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;


/**
 * 在百度申请的BOS服务
 */
public class ZhaoYanBos {
    private static final String BUCKET_ZHAOYAN_WEB = "zhaoyanweb-bos";

    // 用户的Access Key ID
    private static final String ACCESS_KEY_ID = "AD174d932d66106fdd1ada9978f0f21d";
    // 用户的Secret Access Key
    private static final String SECRET_ACCESS_KEY = "C9fb1a79f8d76f1fab3a4ec1b0b0dde7";

    public static BosClient getBosClient() {
        // 初始化一个BosClient
        BosClientConfiguration config = new BosClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(ACCESS_KEY_ID,
                SECRET_ACCESS_KEY));
        // 设置Region，由于Object生成URL时需要指定endPoint
        // 北京Region：http://bj.bcebos.com
        // 广州Region：http://gz.bcebos.com
        config.setEndpoint("http://bj.bcebos.com");

        BosClient client = new BosClient(config);
        return client;
    }

    public static String getBucketZhaoyanWeb() {
        return BUCKET_ZHAOYAN_WEB;
    }

    public static String getZhaoyanWebProductImageDir() {
        return "product/images/";
    }
}
