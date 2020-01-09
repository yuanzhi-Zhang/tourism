package com.yuanzhi.tourism.enums;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/4 10:54
 */
public enum PraiseTypeEnum {
    JOURNEY("1"),
    STRATEGY("2"),
    COMMENT("3"),
    ASKANSWER("4");
    private String type;


    public String getType() {
        return type;
    }

    PraiseTypeEnum(String type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (PraiseTypeEnum praiseEnum : PraiseTypeEnum.values()) {
            if (praiseEnum.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }
}
