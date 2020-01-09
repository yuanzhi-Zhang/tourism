package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Search {
    private Integer searchId;

    private Integer userId;

    private String searchContent;

    private String searchTime;

    private Integer searchTimes;

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent == null ? null : searchContent.trim();
    }

    public String getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(String searchTime) {
        this.searchTime = searchTime == null ? null : searchTime.trim();
    }

    public Integer getSearchTimes() {
        return searchTimes;
    }

    public void setSearchTimes(Integer searchTimes) {
        this.searchTimes = searchTimes;
    }
}