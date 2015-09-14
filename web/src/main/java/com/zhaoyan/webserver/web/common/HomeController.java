package com.zhaoyan.webserver.web.common;


import com.zhaoyan.webserver.domain.common.GreetingModel;
import com.zhaoyan.webserver.service.common.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    GreetingService greetingService;

    @RequestMapping(value = {"/", "/index"})
    public String home(Model model) {
        GreetingModel greeting = greetingService.getGreetingMessage();
        logger.debug("Greeting message: {}", greeting.message);
        model.addAttribute("greetingMessage", greeting.message);
        return "home";
    }
}
