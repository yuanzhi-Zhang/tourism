package com.yuanzhi.tourism.dto;

import com.yuanzhi.tourism.entity.User;
import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/11/9 17:44
 */

@Data
public class QuestionDTO {

    private User user;

    private Integer questionId;

    private String questionTime;

    private Integer questionCreatorId;

    private String questionTitle;

    private String questionImg;

    private String questionContent;

    private String questionDestiny;

    private Integer viewCount;

    private Integer likeCount;

    private Integer commentCount;

    private Integer attentionCount;

}
