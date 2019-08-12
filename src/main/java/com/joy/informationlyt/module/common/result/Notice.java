package com.joy.informationlyt.module.common.result;

public enum Notice{



    EXECUTE_IS_SUCCESS("操作成功", 200),
    EXECUTE_IS_FAILED("操作失败", 234),

    // 公共模块
    REQUEST_PARAMETER_IS_ERROR("请求参数缺失或未空值", 100000),
    IDENTITY_NUMBER_ERROR("身份证信息错误", 100001),
    PHONE_ERROR("电话号码错误", 100002),
    PASSWORD_AFFIRM_ERROR("确认密码不匹配", 100003),
    IDENTITY_NUMBER_ALREADY_EXIST("身份证号码已存在", 100004),
    PHONE_ALREADY_EXIST("电话号码已存在", 100004),
    LOGIN_NAME_ALREADY_EXIST("用户名已存在", 100004),


    // user
    USER_NOT_LOGIN("用户未登录", 10100),
    USER_NOT_EXIST("用户信息不存在", 10101),


    // department
    DEPARTMENT_NOT_EXIST("部门信息不存在",10200),
    DEPARTMENT_PARENT_NOT_EXIST("父部门信息不存在", 10201),
    DEPARTMENT_NAME_HAS_EXIST("部门名称已存在", 10202),





    ;
    private String message;
    private int code;

    Notice(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
