package com.yuanzhi.tourism.dto;

import com.yuanzhi.tourism.entity.User;
import lombok.Data;

import java.util.Date;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/5 17:02
 */

@Data
public class CompanyDTO {

    private Integer companyId;

    private String companyTitle;

    private String companyStartArea;

    private String companyEndArea;

    private Integer companyPeopleNum;

    private Date companyStartTime;

    private String companyDuringTime;

    private Integer companyOwnerId;

    private String companyContent;

    private String companyMainImg;

    private String companyTime;

    private Integer companyAttendNum;

    private Integer companyEnterNum;

    private Integer companyViewNum;

    private Integer companyCommentNum;

    private User user;
}
