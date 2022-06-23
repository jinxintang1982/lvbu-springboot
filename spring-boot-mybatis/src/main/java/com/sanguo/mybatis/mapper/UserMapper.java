package com.sanguo.mybatis.mapper;

import com.sanguo.mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findById(@Param("id") String userId);

    int insert(User user);

    int update(User user);

    int delete(String id);
}
