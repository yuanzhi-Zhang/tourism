package com.yuanzhi.tourism.dto;

import com.yuanzhi.tourism.entity.User;
import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/6 16:13
 */

@Data
public class EnterDTO {

    private Integer enterId;

    private Integer companyId;

    private Integer userId;

    private String userPhone;

    private String enterTime;

    private String enterRemarks;

    private Integer companyMaleNum;

    private Integer companyFemaleNum;

    private User user;

}
