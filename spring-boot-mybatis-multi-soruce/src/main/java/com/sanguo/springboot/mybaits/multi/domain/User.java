package com.sanguo.springboot.mybaits.multi.domain;

/**
 * 用户实体类
 *
 * Created by bysocket on 07/02/2017.
 */
public class User {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 城市名称
     */
    private String userName;

    private City city;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
