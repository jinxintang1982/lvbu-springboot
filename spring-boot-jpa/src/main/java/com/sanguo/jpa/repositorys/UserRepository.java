package com.sanguo.jpa.repositorys;

import com.sanguo.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface
UserRepository  extends JpaRepository<User, Long> {
    //根据domain中的属性名匹配
    User findByUserName(String userName);
    User findByPassword(String password);
    User findById(Long Id);
    int deleteById(Long tenantId);

    //根据SQL进行操作
    @Modifying
    @Query("update User po set " +
            "po.userName = :#{#user.userName}," +
            "po.password = :#{#user.password}," +
            "po.sex = :#{#user.sex}," +
            "po.weight = :#{#user.weight}" +
            " where po.id = :#{#user.id}")
    int update(@Param("user")User user);

    @Query("from User u where 1=1 and u.userName= :#{#user.userName}")
    List<User> findByUser(@Param("user") User user);

    @Query(value = "select id from User  where 1=1 and userName=:userName")
    List<Long> findIdsByName(@Param("userName") String userName);
}
