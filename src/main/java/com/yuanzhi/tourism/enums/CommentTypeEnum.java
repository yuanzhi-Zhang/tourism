package com.yuanzhi.tourism.enums;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/20 10:20
 */
public enum  CommentTypeEnum {
    JOURNEY(1),
    STRATEGY(2),
    COMPANY(3),
    SCENE(4),
    COMMENT(5);
    private Integer type;


    public Integer getType() {
        return type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()) {
            if (commentTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }
}
