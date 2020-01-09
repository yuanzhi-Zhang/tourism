package com.yuanzhi.tourism.dto;

import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/25 11:57
 */

@Data
public class FriendWithUserDTO {
    private Integer uid;

    private String username;

    private String usersex;

    private String imgurl;

    private Integer journeycount;

    private Integer historycount;

    private Integer fanscount;
}
