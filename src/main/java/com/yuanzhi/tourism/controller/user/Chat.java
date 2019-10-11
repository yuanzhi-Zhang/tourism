package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.entity.Message;
import com.yuanzhi.tourism.utils.WebSocketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/9 8:33
 */

@Controller
@ServerEndpoint("/chat/{username}")  //说明创建websocket的endpoint
public class Chat {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    /**
     * 访问聊天室页面
     * @return
     */
    @GetMapping("/chatPage")
    public String chatPage(){
        return "user/chat";
    }
    @GetMapping("/chatPage2")
    public String chatPage2(){
        return "user/chat2";
    }
    @GetMapping("/chatPage3")
    public String chatPage3(Long id, ModelMap modelMap){
        modelMap.addAttribute("id",id);
        return "user/chat3";
    }
    @GetMapping("/chatPage4")
    public String chatPage4(Long id, ModelMap modelMap){
        modelMap.addAttribute("id",id);
        return "user/chat4";
    }
    @MessageMapping("/message")
    public void message(Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getToUserId(),"/message/get",message);
    }

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session){
        //存储用户
        WebSocketUtil.USERS_ONLINE.put(username, session);
        //向所有在线用户发送用户上线通知消息
        String message = "["+username+"]进入聊天室";
        System.out.println(message);
        WebSocketUtil.sendMessageToAllOnlineUser(message);
    }

    @OnClose
    public void closeSession(@PathParam("username") String username, Session session){
        //删除用户
        WebSocketUtil.USERS_ONLINE.remove(username);
        //向所有在线用户发送用户下线通知消息
        String message = "["+username+"]离开了聊天室";
        System.out.println(message);
        WebSocketUtil.sendMessageToAllOnlineUser(message);
        //下线后关闭session
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, String message){
        //向聊天室中的人发送消息
        message = "["+username+"]：" + message;
        System.out.println(message);
        WebSocketUtil.sendMessageToAllOnlineUser(message);
    }

    @OnError
    public void sessionError(Session session, Throwable throwable){
        try {
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("WebSocket连接发生异常，message:"+throwable.getMessage());
    }
}
