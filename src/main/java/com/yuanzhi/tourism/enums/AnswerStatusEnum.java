package com.yuanzhi.tourism.enums;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/23 19:32
 */
public enum AnswerStatusEnum {
    ACCEPT(1),
    GOLDEN(2);

    private Integer type;

    public Integer getType(){return type;}

    AnswerStatusEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (AnswerStatusEnum answerStatusEnum : AnswerStatusEnum.values()) {
            if (answerStatusEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }
}
