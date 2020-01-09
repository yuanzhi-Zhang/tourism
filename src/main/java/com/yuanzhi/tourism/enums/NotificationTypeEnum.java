package com.yuanzhi.tourism.enums;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/22 9:06
 */
public enum  NotificationTypeEnum {
    REPLY_JOURNEY(1, "评论了游记"),
    REPLY_STRATEGY(2, "评论了攻略"),
    REPLY_COMPANY(3, "评论了结伴"),
    ENTER_COMPANY(4, "报名了结伴"),
    REPLY_COMMENT(5, "回复了评论"),
    ATTEND_USER(6, "关注了用户"),
    PRAISE_JOURNEY(7, "点赞了游记"),
    PRAISE_STRATEGY(8, "点赞了攻略"),
    COLLECT_STRATEGY(9, "收藏了攻略"),
    ATTEND_COMPANY(10, "关注了结伴"),
    REMAIN_USER(11, "留言了用户");
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
