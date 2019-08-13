package com.joy.informationlyt.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ToString(callSuper = true)
@Table(name = "all_position")
public class Position extends BaseEntity{
    @NotNull(message = "职位名称不能为空")
    private String name;

    private String describe;

}