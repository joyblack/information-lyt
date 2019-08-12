package com.joy.informationlyt.module.user.enums;

public enum UserType {

    ADMIN("ADMIN","系统管理员"),

    COMMON("COMMON","普通用户");

    private String name;

    private String describe;

    UserType(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
