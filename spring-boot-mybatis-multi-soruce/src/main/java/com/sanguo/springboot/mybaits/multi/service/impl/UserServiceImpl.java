package com.sanguo.springboot.mybaits.multi.service.impl;

import com.sanguo.springboot.mybaits.multi.dao.cluster.CityDao;
import com.sanguo.springboot.mybaits.multi.dao.master.UserDao;
import com.sanguo.springboot.mybaits.multi.domain.City;
import com.sanguo.springboot.mybaits.multi.domain.User;
import com.sanguo.springboot.mybaits.multi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现层
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao; // 主数据源

    @Autowired
    private CityDao cityDao; // 从数据源

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        City city = cityDao.findByName("温岭市");
        user.setCity(city);
        return user;
    }
}
