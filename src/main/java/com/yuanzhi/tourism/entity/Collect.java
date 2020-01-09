package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Collect {
    private Integer collectId;

    private Integer userId;

    private String collectType;

    private Integer collectTypeId;

    private String collectTime;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCollectType() {
        return collectType;
    }

    public void setCollectType(String collectType) {
        this.collectType = collectType == null ? null : collectType.trim();
    }

    public Integer getCollectTypeId() {
        return collectTypeId;
    }

    public void setCollectTypeId(Integer collectTypeId) {
        this.collectTypeId = collectTypeId;
    }

    public String getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(String collectTime) {
        this.collectTime = collectTime == null ? null : collectTime.trim();
    }
}