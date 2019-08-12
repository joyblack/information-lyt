package com.joy.informationlyt.module.system.enums;

/**
 * 教育程度
 */
public enum Education {
    /**
     * 博士
     */
    DOCTOR("博士"),
    /**
     * 硕士
     */
    MASTER("硕士"),
    /**
     * 本科
     */
    BACHELOR("本科"),
    /**
     * 大专
     */
    COLLEGE("大专"),
    /**
     * 中专
     */
    SECONDARY("中专"),
    /**
     * 中技
     */
    POLYTECHNIC("中技"),
    /**
     * 高中
     */
    SENIORMIDDLESCHOOL("高中"),
    /**
     * 初中
     */
    JUNIOR_MIDDLE_SCHOOL("初中"),
    /**
     * 小学
     */
    PRIMARY_SCHOOL("小学"),
    /**
     * 文盲
     */
    ILLITERACY("文盲");
    private String education;

    Education() {
    }

    Education(String education) {
        this.education = education;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
