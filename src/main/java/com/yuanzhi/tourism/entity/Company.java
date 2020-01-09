package com.yuanzhi.tourism.entity;

import java.util.Date;

public class Company {
    private Integer companyId;

    private String companyTitle;

    private String companyStartArea;

    private String companyEndArea;

    private Integer companyPeopleNum;

    private Date companyStartTime;

    private String companyDuringTime;

    private Integer companyOwnerId;

    private String companyContent;

    private String companyMainImg;

    private String companyTime;

    private Integer companyAttendNum;

    private Integer companyEnterNum;

    private Integer companyViewNum;

    private Integer companyCommentNum;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle == null ? null : companyTitle.trim();
    }

    public String getCompanyStartArea() {
        return companyStartArea;
    }

    public void setCompanyStartArea(String companyStartArea) {
        this.companyStartArea = companyStartArea == null ? null : companyStartArea.trim();
    }

    public String getCompanyEndArea() {
        return companyEndArea;
    }

    public void setCompanyEndArea(String companyEndArea) {
        this.companyEndArea = companyEndArea == null ? null : companyEndArea.trim();
    }

    public Integer getCompanyPeopleNum() {
        return companyPeopleNum;
    }

    public void setCompanyPeopleNum(Integer companyPeopleNum) {
        this.companyPeopleNum = companyPeopleNum;
    }

    public Date getCompanyStartTime() {
        return companyStartTime;
    }

    public void setCompanyStartTime(Date companyStartTime) {
        this.companyStartTime = companyStartTime;
    }

    public String getCompanyDuringTime() {
        return companyDuringTime;
    }

    public void setCompanyDuringTime(String companyDuringTime) {
        this.companyDuringTime = companyDuringTime == null ? null : companyDuringTime.trim();
    }

    public Integer getCompanyOwnerId() {
        return companyOwnerId;
    }

    public void setCompanyOwnerId(Integer companyOwnerId) {
        this.companyOwnerId = companyOwnerId;
    }

    public String getCompanyContent() {
        return companyContent;
    }

    public void setCompanyContent(String companyContent) {
        this.companyContent = companyContent == null ? null : companyContent.trim();
    }

    public String getCompanyMainImg() {
        return companyMainImg;
    }

    public void setCompanyMainImg(String companyMainImg) {
        this.companyMainImg = companyMainImg == null ? null : companyMainImg.trim();
    }

    public String getCompanyTime() {
        return companyTime;
    }

    public void setCompanyTime(String companyTime) {
        this.companyTime = companyTime == null ? null : companyTime.trim();
    }

    public Integer getCompanyAttendNum() {
        return companyAttendNum;
    }

    public void setCompanyAttendNum(Integer companyAttendNum) {
        this.companyAttendNum = companyAttendNum;
    }

    public Integer getCompanyEnterNum() {
        return companyEnterNum;
    }

    public void setCompanyEnterNum(Integer companyEnterNum) {
        this.companyEnterNum = companyEnterNum;
    }

    public Integer getCompanyViewNum() {
        return companyViewNum;
    }

    public void setCompanyViewNum(Integer companyViewNum) {
        this.companyViewNum = companyViewNum;
    }

    public Integer getCompanyCommentNum() {
        return companyCommentNum;
    }

    public void setCompanyCommentNum(Integer companyCommentNum) {
        this.companyCommentNum = companyCommentNum;
    }
}