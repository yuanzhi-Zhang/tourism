package com.yuanzhi.tourism.dto;

import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/13 18:50
 */

@Data
public class NotificationDTO {

    private Integer nid;

    private String sendtime;

    private Integer type;

    private Integer typeid;

    private String typename;

    private String typeidname;

    private Integer receiver;

    private Integer notificationer;

    private String notificationername;

    private Integer status;

    private String username;

}
