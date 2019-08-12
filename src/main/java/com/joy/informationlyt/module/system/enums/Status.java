package com.joy.informationlyt.module.system.enums;

/**
 * 记录状态
 */
public enum Status {
    START("START","启用"), STOP("STOP","停用");
    private String name;
    private String describe;

    Status(String name, String describe) {
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
