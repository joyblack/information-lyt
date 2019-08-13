package com.joy.informationlyt.domain.mapper;

import com.joy.informationlyt.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    // 根据身份证查询，并且指定不为某个ID
    User selectOneByIdNumberAndIdNot(@Param("idNumber") String idNumber, @Param("id") Long id);

    // 根据电话号码查询，并且指定不为某个ID
    User selectOneByPhoneAndIdNot(@Param("phone") String phone, @Param("id") Long id);

    List<User> selectBySearch(@Param("search") String search);
}