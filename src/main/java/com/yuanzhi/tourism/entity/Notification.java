package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Notification {
    private Integer nid;

    private String sendtime;

    private Integer type;

    private Integer typeid;

    private String typename;

    private Integer receiver;

    private Integer notificationer;

    private String notificationername;

    private Integer status;
}