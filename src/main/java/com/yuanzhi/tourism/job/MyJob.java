package com.yuanzhi.tourism.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/10 8:49
 */
@Configuration
public class MyJob {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

//    @Scheduled(fixedRate = 3000)
//    public void sendMessage(){
//        System.out.println("来自服务端的消息");
//        simpMessagingTemplate.convertAndSend("/server/sendMessageByServer",System.currentTimeMillis());
//    }
//    @Scheduled(fixedRate = 10000)
//    public void sendMessageToUser(){
//        System.out.println("来自服务端给指定用户推送的消息");
//        simpMessagingTemplate.convertAndSendToUser("1","/sendMessageByServer",System.currentTimeMillis());
//    }
}
