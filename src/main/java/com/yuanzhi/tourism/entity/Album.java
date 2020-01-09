package com.yuanzhi.tourism.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Album {
    private Integer albumid;

    private Integer userid;

    private String albumtitle;

    private String albuminfo;

    private Date publishtime;

    private Integer viewtimes;

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAlbumtitle() {
        return albumtitle;
    }

    public void setAlbumtitle(String albumtitle) {
        this.albumtitle = albumtitle == null ? null : albumtitle.trim();
    }

    public String getAlbuminfo() {
        return albuminfo;
    }

    public void setAlbuminfo(String albuminfo) {
        this.albuminfo = albuminfo == null ? null : albuminfo.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public Integer getViewtimes() {
        return viewtimes;
    }

    public void setViewtimes(Integer viewtimes) {
        this.viewtimes = viewtimes;
    }
}