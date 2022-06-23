package com.sanguo.springboot.web.controller;

import com.sanguo.springboot.web.domain.LearnResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

//这里最好别用@RestDemoController，直接用@Controller即可
@Controller
@RequestMapping("/Thymeleaf")
public class ThymeleafController {
    @RequestMapping("/")
    public ModelAndView index() {
        List<LearnResource> learnList = new ArrayList<>();
        LearnResource bean = new LearnResource("官方参考文档", "Spring Boot Reference Guide", "http://");
        learnList.add(bean);

        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }

    @RequestMapping("/param")
    public ModelAndView hello(ModelAndView modelAndView,@ModelAttribute LearnResource learnResource){

        // 添加内容
        List<LearnResource> learnList = new ArrayList<>();
        LearnResource bean = learnResource;
        learnList.add(bean);

        //组装viewModel
        // templates下的文件名
        modelAndView.setViewName("/index");
        modelAndView.addObject("learnList", learnList);
        return modelAndView;
    }
}
