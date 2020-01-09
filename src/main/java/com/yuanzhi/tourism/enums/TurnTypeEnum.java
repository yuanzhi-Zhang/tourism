package com.yuanzhi.tourism.enums;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/23 11:01
 */
public enum TurnTypeEnum {

    SCENE(1),
    STRATEGY(2),
    COMPANY(3),
    ALBUM(4),
    HOTEL(6);
    private Integer type;


    public Integer getType() {
        return type;
    }

    TurnTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (TurnTypeEnum turnTypeEnum : TurnTypeEnum.values()) {
            if (turnTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }

}
