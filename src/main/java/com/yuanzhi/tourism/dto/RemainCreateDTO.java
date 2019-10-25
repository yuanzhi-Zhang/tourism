package com.yuanzhi.tourism.dto;

import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/24 11:03
 */

@Data
public class RemainCreateDTO {

    private String remainContent;

    private Integer remainSenderId;

    private Integer remainReceiverId;

    private String remainTime;

}
