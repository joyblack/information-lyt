package com.joy.informationlyt.domain.entity;

import com.joy.informationlyt.module.user.enums.UserStatus;
import com.joy.informationlyt.module.user.enums.UserType;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Table(name = "all_user")
@Data
@ToString
public class User extends BaseEntity{

    private String idNumber;

    @NotEmpty(message = "登陆名不能为空")
    private String loginName;

    private String password;

    @Transient
    private String affirmPassword;

    @NotEmpty(message = "电话号码不能为空")
    private String phone;

    private String name;

    private UserType type = UserType.ADMIN;

    private UserStatus status = UserStatus.START;



}