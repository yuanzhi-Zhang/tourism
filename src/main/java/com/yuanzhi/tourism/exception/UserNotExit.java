package com.yuanzhi.tourism.exception;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/22 7:57
 */
public class UserNotExit extends RuntimeException {
    public UserNotExit() {
        super("用户不存在");
    }
}
