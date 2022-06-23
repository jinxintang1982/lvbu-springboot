package com.sanguo.mybatis.controller;

import com.sanguo.mybatis.domain.User;
import com.sanguo.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControl {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public User findOneCity(String id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public int insert(User user) {
        return userService.insert(user);
    }

    /**
     * User 中的Sex使用的是Enum类型，Contorller不能识别，但myBatis中可以识别
     * 所以我们可以新建一个Dto类作为Contorller的参数，添加一个防腐层进行Dto到Domain对象的转换
     * @param user
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public int update(User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public int delete(String id) {
        return userService.delete(id);
    }

}
