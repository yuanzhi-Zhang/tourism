package com.yuanzhi.tourism.controller.admin;

import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/23 19:04
 */

@Controller
public class UsersController {

    @Autowired
    UserService userService;

    /**
     * 查询所有用户,返回用户列表页面
     * @param model
     * @return
     */
    @GetMapping("/users")
    public String userList(Model model){
        Collection<User> users = userService.getAllUser();
        //放在请求域中
        model.addAttribute("users",users);
        //thymeleaf默认就会拼串
        //classpath:/templates/xxxxx.html
        return "admin/users/list";
    }

    /**
     * 来到添加用户界面
     * @return
     */
    @GetMapping("/user")
    public String toAddUser(){
        return "admin/users/add";
    }

    @PostMapping("/user")
    public String addUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

}
