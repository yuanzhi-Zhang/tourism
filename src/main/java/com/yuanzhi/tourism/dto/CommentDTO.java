package com.yuanzhi.tourism.dto;

import com.yuanzhi.tourism.entity.User;
import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/20 20:59
 */

@Data
public class CommentDTO {
    private Integer cid;

    private Integer userid;

    private String commenttime;

    private String modifytime;

    private String commentcomment;

    private Integer parentid;

    private Integer type;

    private Integer commentcount;

    private User user;
}
