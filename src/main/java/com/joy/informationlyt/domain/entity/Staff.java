package com.joy.informationlyt.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import java.util.Date;

@Data
@ToString(callSuper = true)
@Table(name = "all_position")
public class Staff {

    private String archive;

    private String name;

    private Integer sex;

    private String nationality;

    private Date birthDate;

    private String idNumber;

    private Integer education;

    private Integer accountCharacter;

    private String phone;

    private String homeAddress;

    private Long departmentId;

    private Long positionId;

    private Date entryTime;

    private Integer insured;

    private Date insuredTime;

    private String physicalExaminationHospital;

    private Date physicalExaminationTime;

    private String nativePlace;

    private String graduationCollege;

    private Date graduationTime;

    private String professsion;

    private Long remuneration;

    private String introducer;

    private Integer status;

}