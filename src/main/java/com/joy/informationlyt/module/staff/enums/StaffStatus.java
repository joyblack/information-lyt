package com.joy.informationlyt.module.staff.enums;

public enum StaffStatus {

    DIMISSION("离职"),

    INCUMBENCY("在职"),

    HAVE_HOLIDAY("休假"),

    BLACKLIST("黑名单");


    private String name;

    StaffStatus(String name) {
        this.name = name;
    }

    StaffStatus() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
