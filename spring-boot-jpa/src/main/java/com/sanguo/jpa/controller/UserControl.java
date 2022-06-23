package com.sanguo.jpa.controller;

import com.sanguo.jpa.domain.User;
import com.sanguo.jpa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControl {
    Logger logger = LoggerFactory.getLogger(Object.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public User findById(Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public User insert(User user) {
        return userService.insert(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public int update(User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public int delete(Long id) {
        return userService.delete(id);
    }

    @RequestMapping(value = "/findByUser",method = RequestMethod.GET)
    public List<User> findByUser(User user){
        return userService.findByUser(user);
    }

    @RequestMapping(value = "/findIdsByName", method = RequestMethod.GET)
    public List<Long> findIdsByName(String userName) {
        return userService.findIdsByName(userName);
    }

}
