package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Praise {
    private Integer praiseId;

    private Integer userid;

    private String praiseType;

    private Integer praiseTypeId;

    private String praiseTime;

    public Integer getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(Integer praiseId) {
        this.praiseId = praiseId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPraiseType() {
        return praiseType;
    }

    public void setPraiseType(String praiseType) {
        this.praiseType = praiseType == null ? null : praiseType.trim();
    }

    public Integer getPraiseTypeId() {
        return praiseTypeId;
    }

    public void setPraiseTypeId(Integer praiseTypeId) {
        this.praiseTypeId = praiseTypeId;
    }

    public String getPraiseTime() {
        return praiseTime;
    }

    public void setPraiseTime(String praiseTime) {
        this.praiseTime = praiseTime == null ? null : praiseTime.trim();
    }
}