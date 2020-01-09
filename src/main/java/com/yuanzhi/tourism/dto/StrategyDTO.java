package com.yuanzhi.tourism.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/13 16:19
 */

@Data
public class StrategyDTO {

    private Integer strategyId;

    private Integer userId;

    private Date publishTime;

    private String firstImg;

    private String secondImg;

    private String thirdImg;

    private String strategyTitle;

    private String strategyIntro;

    private String strategyContent;

    private Integer readTimes;

    private Integer praiseTimes;

    private Integer commentNum;

    private Integer collectNum;

    private String username;

}
