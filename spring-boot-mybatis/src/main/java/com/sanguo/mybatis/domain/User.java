package com.sanguo.mybatis.domain;

import com.sanguo.mybatis.domain.enums.SexEnum;

import java.io.Serializable;

/**
 * @author zhangchangzhi
 * @version 2017/8/2
 * @Description:
 */

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String password;
    private Double weight;
    private SexEnum sex;

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public User(){}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
