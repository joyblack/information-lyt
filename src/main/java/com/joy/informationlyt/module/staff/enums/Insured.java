package com.joy.informationlyt.module.staff.enums;

/**
 * @author 13562
 */

public enum Insured {
    /**
     * 是
     */
    YES("是"),
    /**
     * 否
     */
    NO("否"),
    /**
     * 已停止
     */
    STOP("已停止"),
    ;

    private String insured;

    Insured() {
    }

    Insured(String insured) {
        this.insured = insured;
    }

    public String getInsured() {
        return insured;
    }

    public void setInsured(String insured) {
        this.insured = insured;
    }
}
