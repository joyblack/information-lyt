package com.joy.informationlyt.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "all_department")
@Data
@ToString
public class Department extends BaseEntity{

    /**
     * 部门名称
     */
    @NotEmpty(message = "部门名称不能为空")
    private String name;

    /**
     * 编码
     */
    private String code;

    /**
     * 父节点部门信息
     */
    @NotNull(message = "父部门不能为空")
    private Long parentId;

    /**
     * 负责人
     */
    private String responseUser;

    /**
     * 联系电话
     */
    private String phone;

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
                ", responseUser='" + responseUser + '\'' +
                ", phone='" + phone + '\'' +
                "remark = " + getRemark() +
                '}';
    }
}