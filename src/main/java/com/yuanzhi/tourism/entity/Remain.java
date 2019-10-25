package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Remain {
    private Integer remainId;

    private Integer remainSenderId;

    private Integer remainReceiverId;

    private String remainContent;

    private String remainTime;

    private User user;
}