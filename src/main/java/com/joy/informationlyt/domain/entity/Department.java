package com.joy.informationlyt.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name = "all_department")
@Data
@ToString(callSuper = true)
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


    public static interface PositionMapper {
        int deleteByPrimaryKey(Long id);

        int insert(Position record);

        int insertSelective(Position record);

        Position selectByPrimaryKey(Long id);

        int updateByPrimaryKeySelective(Position record);

        int updateByPrimaryKeyWithBLOBs(Position record);

        int updateByPrimaryKey(Position record);
    }

    public static interface StaffMapper {
        int deleteByPrimaryKey(Long id);

        int insert(Staff record);

        int insertSelective(Staff record);

        Staff selectByPrimaryKey(Long id);

        int updateByPrimaryKeySelective(Staff record);

        int updateByPrimaryKeyWithBLOBs(Staff record);

        int updateByPrimaryKey(Staff record);
    }
}