package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Comment {
    private Integer cid;

    private Integer userid;

    private String commenttime;

    private String commentcomment;

    private Integer lastcommentid;

    private Integer albumid;

    private Integer sceneid;

    private Integer strategyid;

    private Integer journeyid;

    private Integer commentcount;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(String commenttime) {
        this.commenttime = commenttime == null ? null : commenttime.trim();
    }

    public String getCommentcomment() {
        return commentcomment;
    }

    public void setCommentcomment(String commentcomment) {
        this.commentcomment = commentcomment == null ? null : commentcomment.trim();
    }

    public Integer getLastcommentid() {
        return lastcommentid;
    }

    public void setLastcommentid(Integer lastcommentid) {
        this.lastcommentid = lastcommentid;
    }

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public Integer getSceneid() {
        return sceneid;
    }

    public void setSceneid(Integer sceneid) {
        this.sceneid = sceneid;
    }

    public Integer getStrategyid() {
        return strategyid;
    }

    public void setStrategyid(Integer strategyid) {
        this.strategyid = strategyid;
    }

    public Integer getJourneyid() {
        return journeyid;
    }

    public void setJourneyid(Integer journeyid) {
        this.journeyid = journeyid;
    }

    public Integer getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(Integer commentcount) {
        this.commentcount = commentcount;
    }
}