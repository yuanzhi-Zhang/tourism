package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * 用户登录信息核对
     * @param account 账号
     * @param password 密码
     * @param session 用户信息
     * @param map 账号密码错误信息
     * @return
     */
    @PostMapping(value = "/password")
    public String userLogin(@RequestParam("account") String account,
                            @RequestParam("password") String password,
                            HttpSession session, Map<String,Object> map){
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        User returnUser = userService.loginCheck(user);
        if (returnUser != null){
            session.setAttribute("loginUser",returnUser);
            return "redirect:/";
        }else {
            //登录失败
            map.put("failmsg","账号密码错误");
            return "user/userLogin";
        }
    }

    @PostMapping(value = "/regist")
    public String userRegister(@RequestParam("account") String account,
                               @RequestParam("password") String password,
                               @RequestParam("repwd") String repwd,
                               Map<String,Object> map,HttpSession session){
        if(!password.equals(repwd)){
            map.put("errmsg","前后密码不一致");
            return "user/userRegister";
        }else {
            User user = new User();
            user.setAccount(account);
            user.setPassword(password);
            user.setRepwd(repwd);
            User returnUser = userService.loginCheck(user);
            if (returnUser == null){
                userService.saveUser(user);
                session.setAttribute("loginUser",user);
                return "redirect:/self";
            }else {
                //注册失败
                map.put("registmsg","该号已被注册");
                return "user/userRegister";
            }
        }
    }

    @GetMapping("/signout")
    public String userSignout(HttpSession session){
        session.removeAttribute("loginUser");
        return null;
    }

}
