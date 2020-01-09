package com.yuanzhi.tourism.dto;

import com.yuanzhi.tourism.entity.User;
import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/24 21:52
 */

@Data
public class FriendResultDTO {

    private Integer fid;

    private Integer friendId;

    private User user;

}
