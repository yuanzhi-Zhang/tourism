package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class History {
    private Integer historyId;

    private Integer userId;

    private Integer historyType;

    private Integer typeId;

    private String historyTypeName;

    private String historyTypeImgurl;

    private String historyTime;

    private Integer historyTimes;

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHistoryType() {
        return historyType;
    }

    public void setHistoryType(Integer historyType) {
        this.historyType = historyType;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getHistoryTypeName() {
        return historyTypeName;
    }

    public void setHistoryTypeName(String historyTypeName) {
        this.historyTypeName = historyTypeName == null ? null : historyTypeName.trim();
    }

    public String getHistoryTypeImgurl() {
        return historyTypeImgurl;
    }

    public void setHistoryTypeImgurl(String historyTypeImgurl) {
        this.historyTypeImgurl = historyTypeImgurl == null ? null : historyTypeImgurl.trim();
    }

    public String getHistoryTime() {
        return historyTime;
    }

    public void setHistoryTime(String historyTime) {
        this.historyTime = historyTime == null ? null : historyTime.trim();
    }

    public Integer getHistoryTimes() {
        return historyTimes;
    }

    public void setHistoryTimes(Integer historyTimes) {
        this.historyTimes = historyTimes;
    }
}