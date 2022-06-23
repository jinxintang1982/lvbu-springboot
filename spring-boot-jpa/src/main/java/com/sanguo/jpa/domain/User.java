package com.sanguo.jpa.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhangchangzhi
 * @version 2017/8/2
 * @Description:
 */
@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_name",nullable = false, unique = true)
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name="sex")
    private Integer sex;
    @Column(name="weight")
    private Double weight;

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
