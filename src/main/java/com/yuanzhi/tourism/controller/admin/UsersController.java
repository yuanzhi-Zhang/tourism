package com.yuanzhi.tourism.controller.admin;

import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * @param
     * @return
     */
    /*@GetMapping("/users")
    public String userList(Model model){
        Collection<User> users = userService.getAllUser();
        //放在请求域中
        model.addAttribute("users",users);
        //thymeleaf默认就会拼串
        //classpath:/templates/xxxxx.html
        return "admin/users/list";
    }*/

    /**
     * 分页查询所有用户
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/users")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<User> users = userService.getAllUser(page,limit);
        Long total = userService.getUserNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",total);
        map.put("data",users);
        return map;
    }

    /**
     * 获取用户数量
     * @return
     */
    @GetMapping("/admin/userNum")
    @ResponseBody
    public Map<String,Object> userNum(){
        Map<String,Object> map = new HashMap<>();
        Long total = userService.getUserNum();
        map.put("total",total);
        return map;
    }

    @GetMapping("/admin/sexNum")
    @ResponseBody
    public Map<String,Object> sexNum(){
        Map<String,Object> map = new HashMap<>();
        Long maleNum = userService.getMaleNum();
        Long femaleNum = userService.getfeMaleNum();
        Long unKnowNum = userService.getfeUnKnowNum();
        map.put("maleNum",maleNum);
        map.put("femaleNum",femaleNum);
        map.put("unKnowNum",unKnowNum);
        return map;
    }

    /**
     * 删除用户
     * @return
     */
    @PostMapping("/admin/deleteUser")
    @ResponseBody
    public Map<String,Object> delUser(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer userId = Integer.parseInt(data.get("userId"));
        userService.delUser(userId);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 批量删除
     * @param data
     * @return
     */
    @PostMapping("/admin/batchDelUser")
    @ResponseBody
    public Map<String,Object> batchDelUser(@RequestBody Map<String,Object> data){
        Map<String, Object>map = new HashMap<String, Object>();
        List<Integer>uidLst = (List<Integer>) data.get("userLists");
        userService.batchDelUser(uidLst);
        map.put("msg","删除成功");
        return map;
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
