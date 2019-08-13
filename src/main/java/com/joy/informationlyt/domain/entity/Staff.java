package com.joy.informationlyt.domain.entity;

import com.joy.informationlyt.module.staff.enums.AccountCharacter;
import lombok.Data;
import lombok.ToString;
import tk.mybatis.mapper.common.BaseMapper;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ToString(callSuper = true)
@Table(name = "all_position")
public class Staff extends BaseEntity {

    /**
     * 档案号
     */
    private String archive;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别 0-男 1-女 2-保密
     */
    private Integer sex;

    /**
     * 民族
     */
    private String nationality;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 身份证号码
     */
    @NotNull(message = "身份证号不能为空")
    private String idNumber;

    /**
     * 文化程度
     */
    private Integer education;

    /**
     * 户口性质 0-农业户口
     */
    private Integer accountCharacter;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 所属部门
     */
    private Long departmentId;

    /**
     * 拥有职位信息
     */
    private Long positionId;

    /**
     * 入职时间
     */
    private Date entryTime;

    /**
     * 参保状态
     */
    private Integer insured;

    /**
     * 参保时间
     */
    private Date insuredTime;

    /**
     * 体检医院
     */
    private String physicalExaminationHospital;

    /**
     * 体检时间
     */
    private Date physicalExaminationTime;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 毕业院校
     */
    private String graduationCollege;

    /**
     * 毕业时间
     */
    private Date graduationTime;

    /**
     * 专业
     */
    private String profession;

    /**
     * 薪酬
     */
    private Long remuneration;

    /**
     * 介绍人
     */
    private String introducer;

    /**
     * 员工状态 0-离职 1-在职 2-休假 3-黑名单
     */
    private Integer status;

}