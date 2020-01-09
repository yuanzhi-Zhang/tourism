package com.yuanzhi.tourism.entity;

import lombok.Data;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/29 13:32
 */

@Data
public class SocketMsg {
    private int type;   //聊天类型0：群聊，1：单聊.
    private String fromUser;//发送者.
    private String toUser;//接受者.
    private String msg;//消息
}
