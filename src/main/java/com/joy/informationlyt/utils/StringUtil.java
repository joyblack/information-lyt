package com.joy.informationlyt.utils;

public class StringUtil {
    /**
     * 判断字符串是否为空串
     */
    public static boolean isEmpty(String value){
        if ((value == null) || (value.equals(""))) {
            return true;
        }
        return false;
    }

    /**
     * 判断两字符串是否相等
     */
    public static boolean equals(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        } else {
            return false;
        }
    }
}
