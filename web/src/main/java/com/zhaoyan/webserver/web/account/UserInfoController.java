package com.zhaoyan.webserver.web.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/account/userinfo")
public class UserInfoController {

    @RequestMapping(value = "/modify")
    public String modifyUserInfo() {

        return "user_info";
    }
}
