package com.joy.informationlyt.module.login.service;

import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.config.JwtParamConfig;
import com.joy.informationlyt.domain.entity.User;
import com.joy.informationlyt.domain.mapper.UserMapper;
import com.joy.informationlyt.module.login.web.request.LoginRequest;
import com.joy.informationlyt.utils.MD5Util;
import com.joy.informationlyt.utils.jwt.JwtUtil;
import com.joy.informationlyt.utils.jwt.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtParamConfig jwtParamConfig;

    public JoyResult login(LoginRequest loginReq) {
        if (StringUtil.isEmpty(loginReq.getLoginName())) {
            return JoyResult.buildFailedResult("用户名不能为空");
        }
        if (StringUtil.isEmpty(loginReq.getPassword())) {
            return JoyResult.buildFailedResult("密码不能为空");
        }

        String md5Password = MD5Util.encode(loginReq.getPassword());

        // 先用电话号码查询
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("phone", loginReq.getLoginName())
                .andEqualTo("password", md5Password);
        User user = userMapper.selectOneByExample(example);
        // 登录名查询
        if(user == null){
            example.clear();
            example.createCriteria()
                    .andEqualTo("loginName", loginReq.getLoginName())
                    .andEqualTo("password", md5Password);
            user =  userMapper.selectOneByExample(example);
        }
        if(user == null){
            example.clear();
            example.createCriteria()
                    .andEqualTo("idNumber", loginReq.getLoginName())
                    .andEqualTo("password", md5Password);
            user =  userMapper.selectOneByExample(example);
        }
        if(user != null){
            Map<String, Object> claims = new HashMap<String, Object>();
            claims.put(Token.USER.getName(), user);
            System.out.println(user);
            return JoyResult.buildSuccessResultWithData(JwtUtil.createJWT(claims, jwtParamConfig));
        }else{
            return JoyResult.buildFailedResult("登录名/手机号/身份证/与密码不匹配");
        }
    }


}
