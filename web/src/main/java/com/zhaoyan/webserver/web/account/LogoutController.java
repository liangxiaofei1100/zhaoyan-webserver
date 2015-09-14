package com.zhaoyan.webserver.web.account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/account")
public class LogoutController {

    @RequestMapping(value = "/logout")
    public String logout() {

        return "/";
    }
}
