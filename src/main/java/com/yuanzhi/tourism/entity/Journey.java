package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Journey {
    private Integer tid;

    private Integer userid;

    private String publishtime;

    private String starttime;

    private String people;

    private String money;

    private String daysnum;

    private String jourtitle;

    private String jourcontent;

    private Integer readtimes;

    private Integer praisetimes;

    private String mainimg;

    private Integer commentcount;

    private User user;
}