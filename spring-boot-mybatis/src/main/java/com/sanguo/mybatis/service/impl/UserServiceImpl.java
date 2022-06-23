package com.sanguo.mybatis.service.impl;

import com.sanguo.mybatis.mapper.UserMapper;
import com.sanguo.mybatis.domain.User;
import com.sanguo.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }
    @Override
    public int insert(User user){
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(String id) {
        return userMapper.delete(id);
    }
}
