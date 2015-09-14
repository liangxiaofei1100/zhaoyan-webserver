package com.zhaoyan.webserver.common;

import com.zhaoyan.webserver.domain.common.GreetingModel;
import com.zhaoyan.webserver.service.common.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/common")
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @ResponseBody
    @RequestMapping(value = "/greeting", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public GreetingModel getGreeting() {
        return greetingService.getGreetingMessage();
    }

}
