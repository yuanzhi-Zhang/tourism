package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Turn {
    private Integer turnId;

    private String turnUrl;

    private String turnType;

    private Integer turnTypeId;

    private String turnRemarks;

    public Integer getTurnId() {
        return turnId;
    }

    public void setTurnId(Integer turnId) {
        this.turnId = turnId;
    }

    public String getTurnUrl() {
        return turnUrl;
    }

    public void setTurnUrl(String turnUrl) {
        this.turnUrl = turnUrl == null ? null : turnUrl.trim();
    }

    public String getTurnType() {
        return turnType;
    }

    public void setTurnType(String turnType) {
        this.turnType = turnType == null ? null : turnType.trim();
    }

    public Integer getTurnTypeId() {
        return turnTypeId;
    }

    public void setTurnTypeId(Integer turnTypeId) {
        this.turnTypeId = turnTypeId;
    }

    public String getTurnRemarks() {
        return turnRemarks;
    }

    public void setTurnRemarks(String turnRemarks) {
        this.turnRemarks = turnRemarks == null ? null : turnRemarks.trim();
    }
}