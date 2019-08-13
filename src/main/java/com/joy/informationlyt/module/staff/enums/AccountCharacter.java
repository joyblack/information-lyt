package com.joy.informationlyt.module.staff.enums;

public enum AccountCharacter {
    /**
     * 农业户口
     */
    RPR("农业户口"),
    /**
     * 非农户口
     */
    NRPR("非农户口");

    private String accountCharacter;

    AccountCharacter() {
    }

    AccountCharacter(String accountCharacter) {
        this.accountCharacter = accountCharacter;
    }

    public String getAccountCharacter() {
        return accountCharacter;
    }

    public void setAccountCharacter(String accountCharacter) {
        this.accountCharacter = accountCharacter;
    }
}
