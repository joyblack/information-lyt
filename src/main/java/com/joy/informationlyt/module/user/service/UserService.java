package com.joy.informationlyt.module.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.joy.informationlyt.domain.entity.User;
import com.joy.informationlyt.domain.mapper.UserMapper;
import com.joy.informationlyt.exception.JoyException;
import com.joy.informationlyt.module.common.result.JoyResult;
import com.joy.informationlyt.module.common.result.Notice;
import com.joy.informationlyt.module.common.service.BaseService;
import com.joy.informationlyt.module.common.web.request.BasePageRequest;
import com.joy.informationlyt.module.user.web.req.UpdateUserReq;
import com.joy.informationlyt.utils.JoyBeanUtil;
import com.joy.informationlyt.utils.MD5Util;
import com.joy.informationlyt.utils.PhoneUtil;
import com.joy.informationlyt.utils.StringUtil;
import com.joy.informationlyt.utils.identity.IdNumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;

    public JoyResult add(User user) {
        /**
         * 检测密码是否一致
         */
        if(!StringUtil.equals(user.getPassword(),user.getAffirmPassword())){
            return JoyResult.buildFailedResult(Notice.PASSWORD_AFFIRM_ERROR);
        }
        /**
         * 校验： 身份证号、手机号、登录名
         */
        Example example = new Example(User.class);
        User checkUser = new User();
        if(user.getIdNumber()!= null ){
            if(!IdNumberUtil.isIDNumber(user.getIdNumber())){
                return JoyResult.buildFailedResult(Notice.IDENTITY_NUMBER_ERROR);
            }

            example.createCriteria().andEqualTo("idNumber",user.getIdNumber());
            checkUser = userMapper.selectOneByExample(example);
            if(null != checkUser){
                return JoyResult.buildFailedResult(Notice.IDENTITY_NUMBER_ALREADY_EXIST);
            }
        }
        if(user.getPhone() != null){
            if(!PhoneUtil.isMobile(user.getPhone())){
                return JoyResult.buildFailedResult(Notice.PHONE_ERROR);
            }
            example.clear();
            example.createCriteria().andEqualTo("phone",user.getPhone());
            checkUser = userMapper.selectOneByExample(example);;
            if(null != checkUser){
                throw new JoyException(Notice.PHONE_ALREADY_EXIST);
            }
        }

        example.clear();
        example.createCriteria().andEqualTo("loginName",user.getLoginName());
        checkUser = userMapper.selectOneByExample(example);;
        if(null != checkUser){
            throw new JoyException(Notice.LOGIN_NAME_ALREADY_EXIST);
        }
        // 密码
        user.setPassword(MD5Util.encode(user.getPassword()));
        // 保存数据
        insertSelective(user);
        // 置空密码返回到客户端
        user.setPassword(null);
        return JoyResult.buildSuccessResultWithData(user);
    }

    public JoyResult update(UpdateUserReq updateUserReq) {
        User oldUser = userMapper.selectByPrimaryKey(updateUserReq.getId());
        if(oldUser == null){
            return JoyResult.buildFailedResult(Notice.USER_NOT_EXIST);
        }
        // 如果有配置身份证信息
        if(StringUtil.isNotEmpty(updateUserReq.getIdNumber())){
            if(!IdNumberUtil.isIDNumber(updateUserReq.getIdNumber())){
                return JoyResult.buildFailedResult(Notice.IDENTITY_NUMBER_ERROR);
            }
            User checkUser = userMapper.selectOneByIdNumberAndIdNot(updateUserReq.getIdNumber(), updateUserReq.getId());
            if(checkUser != null){
                return JoyResult.buildFailedResult(Notice.IDENTITY_NUMBER_ALREADY_EXIST);
            }
        }

        // 如果有配置电话号码信息
        if(StringUtil.isNotEmpty(updateUserReq.getPhone())){
            if(!PhoneUtil.isMobile(updateUserReq.getPhone())){
                return JoyResult.buildFailedResult(Notice.PHONE_ERROR);
            }
            User checkUser = userMapper.selectOneByPhoneAndIdNot(updateUserReq.getPhone(), updateUserReq.getId());
            if(checkUser != null){
                return JoyResult.buildFailedResult(Notice.PHONE_ALREADY_EXIST);
            }
        }

        // 如果有配置密码信息
        if(StringUtil.isNotEmpty(updateUserReq.getPassword())){
            if(!StringUtil.equals(updateUserReq.getPassword(),updateUserReq.getAffirmPassword())){
                return JoyResult.buildFailedResult(Notice.PASSWORD_AFFIRM_ERROR);
            }
        }

        // 密码
        updateUserReq.setPassword(MD5Util.encode(updateUserReq.getPassword()));
        // 拷贝属性到oldUser之上
        JoyBeanUtil.copyPropertiesIgnoreSourceNullProperties(updateUserReq, oldUser);
        updateByPrimaryKeySelective(oldUser);
        // 获取最新的用户信息，置空密码
        oldUser.setPassword(null);
        return JoyResult.buildSuccessResultWithData(oldUser);
    }

    public JoyResult delete(Long id) {
        // 获取部门信息
        User user = userMapper.selectByPrimaryKey(id);
        if(user == null){
            return JoyResult.buildFailedResult(Notice.USER_NOT_EXIST);
        }
        User delete = new User();
        delete.setId(user.getId());
        delete.setUpdateTime(new Date());
        delete.setIsDelete(true);
        updateByPrimaryKeySelective(delete);
        return JoyResult.buildSuccessResult("删除成功");
    }

    public JoyResult getList(BasePageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(),pageRequest.getSize(), pageRequest.getOrderByString());
        List<User> users = userMapper.selectBySearch(pageRequest.getSearch());
        //List<User> users = userMapper.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return JoyResult.buildSuccessResultWithData(userPageInfo);

    }

    public JoyResult test(){
        int recordNum = 100;
        while(recordNum -- > 0){
            User user = new User();
            user.setPassword(MD5Util.encode("123456"));
            user.setIdNumber("522401199401025931");
            user.setLoginName("zhaoyi" + recordNum);
            user.setPhone("13535565497");
            user.setStatus(0);
            insertSelective(user);
        }
        return JoyResult.buildSuccessResult("完成测试...");
    }
}
