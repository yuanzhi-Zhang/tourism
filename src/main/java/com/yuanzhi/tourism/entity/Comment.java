package com.yuanzhi.tourism.entity;

import lombok.Data;

@Data
public class Comment {
    private Integer cid;

    private Integer userid;

    private String commenttime;

    private String modifytime;

    private String commentcomment;

    private Integer parentid;

    private Integer type;

    private Integer commentcount;

    private User user;
}