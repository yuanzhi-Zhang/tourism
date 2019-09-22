package com.yuanzhi.tourism.controller.admin;

import com.yuanzhi.tourism.entity.Admin;
import com.yuanzhi.tourism.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/22 8:40
 */
@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    @PostMapping(value = "/admin/login")
//    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("adminAccount") String adminAccount,    //@RequestParam("username")可以明确的告诉它是从请求参数里获取username，一旦用这个标注的没提交，就会报错
                        @RequestParam("adminPassword") String adminPassword,
                        Map<String,Object> map, HttpSession session){
        Admin admin = adminService.login(adminAccount,adminPassword);
        if (admin != null){
            //登录成功,防止表单重复提交，可以重定向到主页
            session.setAttribute("loginAdmin",admin);
            return "redirect:main.html";
        }else {
            //登录失败
            map.put("msg","账号密码错误");
            return "login";
        }
//        if (!StringUtils.isEmpty(adminAccount) && "123456".equals(adminPassword)){
//            //登录成功,防止表单重复提交，可以重定向到主页
//            session.setAttribute("loginAdmin",adminAccount);
//            return "redirect:/admin/main.html";
//        }else{
//            //登录失败
//            map.put("msg","用户名密码错误");
//            return "login";
//        }
    }

}
