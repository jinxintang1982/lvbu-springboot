package com.sanguo.springboot.redis.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;

/**
 * @description: 工人
 * @author: zhangchangzhi
 * @create: 2020-06-27 14:08
 **/

@RedisHash("employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 6835815975637187630L;
    @Id
    private Integer id;

    @Indexed
    private String name;


    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Employee [id=" + id + ", name =" + name + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}