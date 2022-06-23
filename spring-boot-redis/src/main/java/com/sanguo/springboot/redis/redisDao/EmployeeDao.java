package com.sanguo.springboot.redis.redisDao;

import com.sanguo.springboot.redis.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @description: employee的crud库
 * @author: zhangchangzhi
 * @create: 2020-06-27 14:13
 **/

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    List<Employee> findByName(String name);
}
