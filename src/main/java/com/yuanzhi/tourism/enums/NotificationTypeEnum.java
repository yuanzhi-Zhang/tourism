package com.yuanzhi.tourism.enums;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/22 9:06
 */
public enum  NotificationTypeEnum {
    REPLY_JOURNEY(1, "回复了游记"),
    REPLY_STRATEGY(2, "回复了攻略"),
    REPLY_ALBUM(3, "回复了相册"),
    REPLY_SCENE(4, "回复了景点"),
    REPLY_COMMENT(5, "回复了评论");
    private int type;
    private String name;


    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NotificationTypeEnum(int status, String name) {
        this.type = status;
        this.name = name;
    }

    public static String nameOfType(int type) {
        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
            if (notificationTypeEnum.getType() == type) {
                return notificationTypeEnum.getName();
            }
        }
        return "";
    }
}
