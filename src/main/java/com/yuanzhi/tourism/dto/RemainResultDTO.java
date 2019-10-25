package com.yuanzhi.tourism.dto;

import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/24 13:18
 */

@Data
public class RemainResultDTO {
    private Integer remainId;

    private Integer remainSenderId;

    private String remainContent;

    private String remainTime;

    private String userName;

    private String imgUrl;
}
