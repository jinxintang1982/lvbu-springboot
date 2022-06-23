package com.sanguo.jpa.service;

import com.sanguo.jpa.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
     User findById(Long id);
     User findByName(String name);
     User findByPassword(String password);
     User insert(User user);
     int update(User user);
     int delete(Long id);

     List<Long> findIdsByName(String name);
     List<User> findByUser(User user);
}
