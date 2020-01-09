package com.yuanzhi.tourism.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/15 21:54
 */

@Data
public class AlbumWithViewDTO {

    private Integer albumid;

    private String albumtitle;

    private String albuminfo;

    private Date publishtime;

    private Integer pictureNum;

    private Integer viewtimes;

    private String pictureUrl;

    private String username;

    private String usersex;

    private String imgurl;

}
