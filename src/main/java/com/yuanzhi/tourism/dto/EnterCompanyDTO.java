package com.yuanzhi.tourism.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/15 15:41
 */

@Data
public class EnterCompanyDTO {

    private Integer enterId;

    private Integer companyId;

    private Integer userId;

    private String userPhone;

    private String enterTime;

    private String enterRemarks;

    private Integer companyMaleNum;

    private Integer companyFemaleNum;

    private String companyTitle;

    private String companyEndArea;

    private Date companyStartTime;

    private String companyMainImg;

    private String companyTime;

    private String username;

    private String usersex;

    private String imgurl;

    private String address;

    private Integer companyAttendNum;

}
