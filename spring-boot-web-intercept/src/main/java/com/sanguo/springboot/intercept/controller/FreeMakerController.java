package com.sanguo.springboot.intercept.controller;

import com.sanguo.springboot.intercept.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freemarker")
public class FreeMakerController {
    Logger logger = LoggerFactory.getLogger(Object.class);

    @RequestMapping("/user")
    public String putUser(Model model,User user){
        logger.info(user.toString());
        model.addAttribute("user",user);
        return "index";
    }
}