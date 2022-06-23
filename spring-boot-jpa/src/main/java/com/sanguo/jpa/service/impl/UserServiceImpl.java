package com.sanguo.jpa.service.impl;


import com.sanguo.jpa.domain.User;
import com.sanguo.jpa.repositorys.UserRepository;
import com.sanguo.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public User findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public int update(User user) {
        return userRepository.update(user);
    }

    @Override
    @Transactional
    public int delete(Long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public List<Long> findIdsByName(String name) {
        return userRepository.findIdsByName(name);
    }

    @Override
    public List<User> findByUser(User user) {
        return userRepository.findByUser(user);
    }
}
