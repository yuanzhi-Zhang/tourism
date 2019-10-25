package com.yuanzhi.tourism.enums;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/23 19:41
 */
public enum FriendTypeEnum {
    MY_ATTENTION(1),
    MY_FENS(2),
    MY_BAN(3);

    private Integer type;

    public Integer getType() {
        return type;
    }

    FriendTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (FriendTypeEnum friendTypeEnum : FriendTypeEnum.values()) {
            if (friendTypeEnum.getType() == type) {
                return true;
            }
        }
        return false;
    }
}
