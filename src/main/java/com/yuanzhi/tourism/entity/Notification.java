package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Notification {
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

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime == null ? null : sendtime.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getTypeidname() {
        return typeidname;
    }

    public void setTypeidname(String typeidname) {
        this.typeidname = typeidname == null ? null : typeidname.trim();
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    public Integer getNotificationer() {
        return notificationer;
    }

    public void setNotificationer(Integer notificationer) {
        this.notificationer = notificationer;
    }

    public String getNotificationername() {
        return notificationername;
    }

    public void setNotificationername(String notificationername) {
        this.notificationername = notificationername == null ? null : notificationername.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}