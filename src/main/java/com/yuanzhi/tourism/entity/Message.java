package com.yuanzhi.tourism.entity;

import java.io.Serializable;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/10 10:39
 */
public class Message implements Serializable {

    private String content;
    private String fromUserId;
    private String toUserId;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }
}
