package com.joy.informationlyt.module.common.web.request;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class IdRequest {
    @NotNull(message = "删除对象的ID不能为空")
    private Long id;
}
