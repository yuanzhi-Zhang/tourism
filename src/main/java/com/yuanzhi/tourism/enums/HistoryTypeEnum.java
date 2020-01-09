package com.yuanzhi.tourism.enums;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/2 21:15
 */
public enum HistoryTypeEnum {

    JOURNEY(1),
    STRATEGY(2),
    COMPANY(3),
    ALBUM(4),
    SCENE(5);
    private Integer type;


    public Integer getType() {
        return type;
    }

    HistoryTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (HistoryTypeEnum historyTypeEnum : HistoryTypeEnum.values()) {
            if (historyTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }

}
