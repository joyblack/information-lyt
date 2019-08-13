package com.joy.informationlyt.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@ToString(callSuper = true)
@Table(name = "all_storehouse")
public class Storehouse extends BaseEntity {

    private Integer status;

    @NotNull(message = "仓库名称不能为空")
    private String name;

    @NotNull(message = "负责人不能为空")
    private String responseUser;

    private String code;

    @NotNull(message = "管理员不能为空")
    private String admin;
}