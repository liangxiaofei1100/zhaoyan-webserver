package com.zhaoyan.webserver.domain.account.http;

import com.zhaoyan.webserver.domain.common.http.Request;

public class LoginRequest extends Request{
    /**
     * 登录用户名
     */
    public String loginName;
    /**
     * 登录密码
     */
    public String password;
    /**
     * 登录类型
     */
    public int loginType;
    /**
     * 登录类型：密码登录
     */
    public static final int LOGIN_TYPE_PASSWORD = 0;
    /**
     * 登录类型：自动登录
     */
    public static final int LOGIN_TYPE_AUTO = 1;
}
