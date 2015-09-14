package com.zhaoyan.webserver.domain.common.http;

public class RequestHeader {
    /**
     * 服务版本号
     */
    public int serviceVersion;
    /**
     * 用户id
     */
    public String userToken;
    /**
     * 渠道号
     */
    public String sourceID;
    /**
     * 客户端设备id
     */
    public String clientID;
    /**
     * app版本号
     */
    public String clientVersion;
    /**
     * 手机型号
     */
    public String phoneModels;
    /**
     * 客户端时间
     */
    public long requestTime;
}
