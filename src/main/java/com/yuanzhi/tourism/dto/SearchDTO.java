package com.yuanzhi.tourism.dto;

import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/24 19:49
 */

@Data
public class SearchDTO {
    private Integer searchId;

    private Integer userId;

    private String searchContent;

    private String searchTime;

    private String username;

    private Integer searchTimes;
}
