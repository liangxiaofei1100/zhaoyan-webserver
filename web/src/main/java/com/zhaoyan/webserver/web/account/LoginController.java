package com.zhaoyan.webserver.web.account;

import com.zhaoyan.webserver.service.account.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    LoginService loginService;

    // 显示登录页面
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        logger.debug("Show login page.");
        return "login";
    }

    // 登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password,
                              HttpSession session,
                              @RequestParam(value = "savetime", required = false) String savetime) {
        logger.debug("login, username=" + username + ", password=" + password);
        ModelAndView modelAndView = new ModelAndView();
        boolean isLoginSuccess = loginService.login(username, password);
        logger.debug("login, isLoginSuccess=" + isLoginSuccess);
        if (isLoginSuccess) {
            modelAndView.setView(new RedirectView("/web/", false));
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
