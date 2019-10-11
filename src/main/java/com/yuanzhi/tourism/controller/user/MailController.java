package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/10 19:44
 */
@Controller
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping("getCheckCode")
    @ResponseBody
    public String getCheckCode(String email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "【任我行】竭诚为您服务"+"\n"+"您的注册验证码为："+checkCode+"，如非本人操作，请忽略此信息";
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
        }catch (Exception e){
            return "";
        }
        return checkCode;
    }
}
