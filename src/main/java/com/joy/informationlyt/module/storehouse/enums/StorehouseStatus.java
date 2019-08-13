package com.joy.informationlyt.module.storehouse.enums;

/**
 * 记录状态
 */
public enum StorehouseStatus {
    STOP("STOP","停用"),
    START("START","启用");
    private String name;
    private String describe;

    StorehouseStatus(String name, String describe) {
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
