package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Enter {
    private Integer enterId;

    private Integer companyId;

    private Integer userId;

    private String userPhone;

    private String enterTime;

    private String enterRemarks;

    private Integer companyMaleNum;

    private Integer companyFemaleNum;

    public Integer getEnterId() {
        return enterId;
    }

    public void setEnterId(Integer enterId) {
        this.enterId = enterId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime == null ? null : enterTime.trim();
    }

    public String getEnterRemarks() {
        return enterRemarks;
    }

    public void setEnterRemarks(String enterRemarks) {
        this.enterRemarks = enterRemarks == null ? null : enterRemarks.trim();
    }

    public Integer getCompanyMaleNum() {
        return companyMaleNum;
    }

    public void setCompanyMaleNum(Integer companyMaleNum) {
        this.companyMaleNum = companyMaleNum;
    }

    public Integer getCompanyFemaleNum() {
        return companyFemaleNum;
    }

    public void setCompanyFemaleNum(Integer companyFemaleNum) {
        this.companyFemaleNum = companyFemaleNum;
    }
}