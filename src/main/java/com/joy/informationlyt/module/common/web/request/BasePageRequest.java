package com.joy.informationlyt.module.common.web.request;

import com.joy.informationlyt.utils.StringUtil;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BasePageRequest {

    private int page = 1;

    private int size = 10;
    /**
     * 模糊搜索字段
     */
    private String search;

    private String sort;

    private String order;

    public String getOrderByString(){
        if(StringUtil.isEmpty(sort)){
            return null;
        }else{
            return StringUtil.toLine(sort) + " " + order;
        }
    }

}
