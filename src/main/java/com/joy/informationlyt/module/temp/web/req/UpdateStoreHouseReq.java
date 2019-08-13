package com.joy.informationlyt.module.temp.web.req;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class UpdateStoreHouseReq {
    @NotNull(message = "用户ID不能为空")
    private Long id;

    private String password;

    private String affirmPassword;

    private String phone;

    private String idNumber;
}
