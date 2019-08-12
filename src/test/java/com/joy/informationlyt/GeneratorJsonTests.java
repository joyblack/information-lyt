package com.joy.informationlyt;

import cn.hutool.json.JSONUtil;
import com.joy.informationlyt.domain.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

public class GeneratorJsonTests {

    /**
     * 实体转化为JSON串
     */
    @Test
    public void department() {
        Department department = new Department();
        department.setCode("00");
        department.setName("信息分院");
        department.setParentId(0L);
        department.setPhone("13535565497");
        department.setResponseUser("jake");
        department.setRemark("备注信息");
        System.out.println( JSONUtil.toJsonPrettyStr(department));
    }



}
