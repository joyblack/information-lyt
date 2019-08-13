package com.joy.informationlyt.module.storehouse.web.req;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class UpdateStoreHouseReq {
    @NotNull(message = "ID不能为空")
    private Long id;

    private Integer status;

    private String name;

    private String responseUser;

    private String code;

    private String admin;
}
