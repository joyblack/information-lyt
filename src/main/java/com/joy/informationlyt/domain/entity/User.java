package com.joy.informationlyt.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Data
@Table(name = "all_user")
@ToString
public class User extends BaseEntity {

    @NotEmpty(message = "身份证号码不能为空")
    private String idNumber;

    @NotEmpty(message = "登陆名不能为空")
    private String loginName;

    @NotEmpty(message = "密码不能为空")
    private String password;

    @Transient
    private String affirmPassword;

    @NotEmpty(message = "电话号码不能为空")
    @Column(nullable = false)
    private String phone;


}