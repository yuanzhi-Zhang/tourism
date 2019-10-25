package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Friend {
    private Integer fid;

    private Integer userId;

    private Integer friendType;

    private Integer friendId;

    private String joinTime;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFriendType() {
        return friendType;
    }

    public void setFriendType(Integer friendType) {
        this.friendType = friendType;
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime == null ? null : joinTime.trim();
    }
}