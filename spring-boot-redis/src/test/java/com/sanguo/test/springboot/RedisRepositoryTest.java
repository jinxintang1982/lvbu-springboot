package com.sanguo.test.springboot;

import com.sanguo.springboot.redis.Application;
import com.sanguo.springboot.redis.domain.Employee;
import com.sanguo.springboot.redis.redisDao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: 用来测试springDataRedis的类
 * @author: zhangchangzhi
 * @create: 2020-06-27 14:18
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisRepositoryTest {
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void repositoryTest(){
        employeeDao.save(new Employee(1,"zhangsan"));
        employeeDao.save(new Employee(2,"lisi"));

        System.out.println(employeeDao.findByName("zhangsan"));
    }
}
