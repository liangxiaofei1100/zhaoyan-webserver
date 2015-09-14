package com.zhaoyan.webserver.app.common;


import com.zhaoyan.webserver.domain.common.GreetingModel;
import com.zhaoyan.webserver.service.common.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeAction {
    @Autowired
    GreetingService greetingService;

    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

    @RequestMapping(value = "/", produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String home(Model model) {
        String message = "欢迎来到App主页，当前时间：" + format.format(new Date());

        GreetingModel greeting = greetingService.getGreetingMessage();
        model.addAttribute("greetingMessage", greeting.message);
        System.out.println("message: " + greeting.message);

        message += "\n";
        message += greeting.message;
        return message;
    }
}
