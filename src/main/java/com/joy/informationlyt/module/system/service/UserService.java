package com.joy.informationlyt.module.system.service;

import com.joy.informationlyt.exception.JoyException;
import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.domain.entity.User;
import com.joy.informationlyt.domain.mapper.UserMapper;
import com.joy.informationlyt.utils.MD5Util;
import com.joy.informationlyt.utils.StringUtil;
import com.joy.informationlyt.utils.identity.IdNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public JoyResult register(User user) {
        /**
         * 检测密码是否一致
         */
        if(!StringUtil.equals(user.getPassword(),user.getAffirmPassword())){
            throw new JoyException("密码输入不一致");
        }
        /**
         * 校验： 身份证号、手机号、登录名
         */
        if(!IdNumberUtil.isIDNumber(user.getIdNumber())){
            throw new JoyException("身份证号错误");
        }
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("idNumber",user.getIdNumber());
        User checkUser = userMapper.selectOneByExample(example);
        if(null != checkUser){
            throw new JoyException("身份证号已注册");
        }

        example.clear();
        example.createCriteria().andEqualTo("phone",user.getPhone());
        checkUser = userMapper.selectOneByExample(example);;
        if(null != checkUser){
            throw new JoyException("该手机号已被注册");
        }

        example.clear();
        example.createCriteria().andEqualTo("loginName",user.getPhone());
        checkUser = userMapper.selectOneByExample(example);;
        if(null != checkUser){
            throw new JoyException("账户名已被注册");
        }
        // 密码
        user.setPassword(MD5Util.encode(user.getPassword()));
        // 保存数据
        userMapper.insertSelective(user);
        // 置空密码返回到客户端
        user.setPassword(null);
        return JoyResult.buildSuccessResultWithData(user);
    }
}
