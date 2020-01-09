package com.yuanzhi.tourism.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Attend {
    private Integer attendId;

    private Integer attendType;

    private Integer attendTypeId;

    private Integer attendUserId;

    private Date attendTime;

    public Integer getAttendId() {
        return attendId;
    }

    public void setAttendId(Integer attendId) {
        this.attendId = attendId;
    }

    public Integer getAttendType() {
        return attendType;
    }

    public void setAttendType(Integer attendType) {
        this.attendType = attendType;
    }

    public Integer getAttendTypeId() {
        return attendTypeId;
    }

    public void setAttendTypeId(Integer attendTypeId) {
        this.attendTypeId = attendTypeId;
    }

    public Integer getAttendUserId() {
        return attendUserId;
    }

    public void setAttendUserId(Integer attendUserId) {
        this.attendUserId = attendUserId;
    }

    public Date getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Date attendTime) {
        this.attendTime = attendTime;
    }
}