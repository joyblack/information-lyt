package com.joy.informationlyt.module.user.enums;

public enum DepartmentRank {
    BASIC_LEVEL("基层"),

    MIDDLE_LEVEL("中层"),

    HING_LEVEL("高层");

    private String describe;

    DepartmentRank() {

    }

    DepartmentRank(String describe) {
        this.describe = describe;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
