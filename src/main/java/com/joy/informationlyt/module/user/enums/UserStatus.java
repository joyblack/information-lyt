package com.joy.informationlyt.module.user.enums;

/**
 * 记录状态
 */
public enum UserStatus {
    START("START","启用"), STOP("STOP","停用");
    private String name;
    private String describe;

    UserStatus(String name, String describe) {
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
