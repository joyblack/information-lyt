package com.joy.informationlyt.module.system.enums;

/**
 * 性别
 */
public enum Sex {
    /**
     * 男性
     */
    MAN("男性"),
    /**
     * 女性
     */
    WOMAN("女性");

    private String sex;

    Sex() {
    }

    Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
