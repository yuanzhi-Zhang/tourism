package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/24 16:06
 */
@Controller
public class UserLoginController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user/login")
    public String userLogin(@RequestParam("account") String account,
                            @RequestParam("password") String password,
                            HttpSession session, Map<String,Object> map){
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        User returnUser = userService.loginCheck(user);
        if (returnUser != null){
            session.setAttribute("loginUser",returnUser);
            return "redirect:/destiny.html";
        }else {
            //登录失败
            map.put("failmsg","账号密码错误");
            return "user/userLogin";
        }
    }

}
