package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.service.MailService;
import com.yuanzhi.tourism.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public boolean getCheckCode(String email, HttpServletRequest request){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        request.getSession().setAttribute("checkCode",checkCode);
        String message = "【任我行】竭诚为您服务"+"\n"+"您的注册验证码为："+checkCode+"，如非本人操作，请忽略此信息";
        try {
            mailService.sendSimpleMail(email, "任我行旅游网注册", message);
//            MailUtil.sendMail("任我行旅游网激活","请点击<a href='http://localhost:8088/rwx/'>http://localhost:8088/rwx/</a>激活您的账号，如非本人操作，请忽略此信息",email);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
