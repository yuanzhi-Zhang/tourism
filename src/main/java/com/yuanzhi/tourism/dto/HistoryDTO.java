package com.yuanzhi.tourism.dto;

import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/24 19:48
 */

@Data
public class HistoryDTO {
    private Integer historyId;

    private Integer userId;

    private Integer historyType;

    private Integer typeId;

    private String historyTypeName;

    private String historyTypeImgurl;

    private String historyTime;

    private String username;

    private Integer historyTimes;
}
