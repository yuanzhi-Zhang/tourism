package com.yuanzhi.tourism.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Strategy {
    private Integer strategyId;

    private Integer userId;

    private Date publishTime;

    private String firstImg;

    private String secondImg;

    private String thirdImg;

    private String strategyTitle;

    private String strategyIntro;

    private String strategyContent;

    private Integer readTimes;

    private Integer praiseTimes;

    private Integer commentNum;

    private Integer collectNum;

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg == null ? null : firstImg.trim();
    }

    public String getSecondImg() {
        return secondImg;
    }

    public void setSecondImg(String secondImg) {
        this.secondImg = secondImg == null ? null : secondImg.trim();
    }

    public String getThirdImg() {
        return thirdImg;
    }

    public void setThirdImg(String thirdImg) {
        this.thirdImg = thirdImg == null ? null : thirdImg.trim();
    }

    public String getStrategyTitle() {
        return strategyTitle;
    }

    public void setStrategyTitle(String strategyTitle) {
        this.strategyTitle = strategyTitle == null ? null : strategyTitle.trim();
    }

    public String getStrategyIntro() {
        return strategyIntro;
    }

    public void setStrategyIntro(String strategyIntro) {
        this.strategyIntro = strategyIntro == null ? null : strategyIntro.trim();
    }

    public String getStrategyContent() {
        return strategyContent;
    }

    public void setStrategyContent(String strategyContent) {
        this.strategyContent = strategyContent == null ? null : strategyContent.trim();
    }

    public Integer getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(Integer readTimes) {
        this.readTimes = readTimes;
    }

    public Integer getPraiseTimes() {
        return praiseTimes;
    }

    public void setPraiseTimes(Integer praiseTimes) {
        this.praiseTimes = praiseTimes;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }
}