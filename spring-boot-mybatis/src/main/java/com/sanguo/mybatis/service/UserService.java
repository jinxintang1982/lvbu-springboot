package com.sanguo.mybatis.service;

import com.sanguo.mybatis.domain.User;

public interface UserService {
     User findById(String id);
     int insert(User user);
     int update(User user);
     int delete(String id);
}
