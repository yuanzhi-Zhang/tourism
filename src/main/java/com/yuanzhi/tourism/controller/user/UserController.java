package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.service.JourneyService;
import com.yuanzhi.tourism.service.UserService;
import com.yuanzhi.tourism.utils.BCryptPasswordEncoder;
import com.yuanzhi.tourism.utils.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/24 16:06
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    JourneyService journeyService;

    /**
     * 用户登录信息核对
     * @param account
     * @param accountType
     * @param password
     * @param response
     * @return
     */
    @RequestMapping(value = "/password")
    @ResponseBody
    public Map<String,Object> userLogin(@RequestParam("account") String account,
                            @RequestParam("accountType") Integer accountType,
                            @RequestParam("password") String password,
                            HttpServletResponse response){
        Map<String, Object> result = new HashMap<String, Object>();
        String token = UUID.randomUUID().toString();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User returnUser = userService.loginCheck(account,accountType,password,token);
        if(returnUser == null){
            result.put("success",0);
            return result;
        }
        if (!encoder.matches(password,returnUser.getPassword())) {
            result.put("success",0);
            return result;
        }else{
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
            response.addCookie(cookie);
            result.put("user", returnUser);
            result.put("success",1);
            return result;
        }
        /*if (returnUser != null){
            result.put("success",1);
            return result;
        }else {
            //登录失败
            result.put("success",0);
            return result;
        }*/
    }

    /**
     * 用户注册
     * @param username 账号
     * @param password 密码
     * @param email 邮箱
     * @return
     */
    @PostMapping(value = "/regist")
    @ResponseBody
    public Map<String,Object> userRegister(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("email") String email,
                               @RequestParam("checkCode") String checkCode,
                               HttpServletResponse response,HttpServletRequest request){
        Map<String,Object>map = new HashMap<String, Object>();
        if(!checkCode.equals(request.getSession().getAttribute("checkCode"))){
            map.put("code",2001);     //验证码错误
            return map;
        }else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(password);
            User user = new User();
            user.setUsername(username);
            user.setPassword(encodedPassword);
            user.setEmail(email);
            user.setStatus(1);
            String token = UUID.randomUUID().toString();
            user.setStatuscode(token);
            User returnUser = userService.loginCheck(email,1,password,token);
            Cookie cookie = new Cookie("token", token);
            cookie.setMaxAge(60 * 60 * 24 * 30 * 6);
            response.addCookie(cookie);
            if (returnUser == null){
                user.setFanscount(0);
                user.setJourneycount(0);
                user.setHistorycount(0);
                userService.saveUser(user);
                map.put("code",2000);       //成功
                return map;
            }else {
                //注册失败
                map.put("code",2002);     //该号已被注册
                return map;
            }
        }
    }

    /**
     * 用户修改个人信息
     * @param request
     * @param response
     * @param userInfo 前端传来的json对象
     * @param session 修改后的用户信息
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/userInfo")
    @ResponseBody
    public String userInfoChange(HttpServletRequest request, HttpServletResponse response,
                       @RequestBody Map<String,String> userInfo,HttpSession session ) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String birth = userInfo.get("birth");
        String phone = userInfo.get("phone");
        String sex = userInfo.get("sex");
        String selfInfo = userInfo.get("selfInfo");
        String userName = userInfo.get("username");
        String address = userInfo.get("address");
        int id = Integer.parseInt(userInfo.get("id"));
        User user = new User();
        user.setBirthday(birth);
        user.setPhone(phone);
        user.setUsersex(sex);
        user.setSelfintro(selfInfo);
        user.setUsername(userName);
        user.setAddress(address);
        user.setUid(id);
        userService.updateUserInfo(user);
//        User returnUser = userService.updateUserInfo(user);
//        session.setAttribute("loginUser",returnUser);
        return "ok";
    }

    /**
     * 用户添加或修改个人自我介绍
     * @param id 用户id
     * @param selfInfo 自我介绍内容
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/selfInfo")
    @ResponseBody
    public String userInfoChange(@RequestParam(value = "id")Integer id,
                                 @RequestParam(value = "selfInfo")String selfInfo, HttpSession session ) throws IOException {
        User user = new User();
        user.setSelfintro(selfInfo);
        user.setUid(id);
        userService.updateUserInfo(user);
//        User returnUser = userService.updateUserInfo(user);
//        session.setAttribute("loginUser",returnUser);
        return "ok";
    }

    /**
     * 用户修改密码
     * @param passwordInfo  前端传来的用户的密码修改的json对象
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/modifyPwd")
    @ResponseBody
    public String modifyPwd(@RequestBody Map<String,String> passwordInfo) throws UnsupportedEncodingException {
        int id = Integer.parseInt(passwordInfo.get("id"));
        String newPwd = passwordInfo.get("newPassword");
        String renewPassword = passwordInfo.get("renewPassword");
        String oldPwd = passwordInfo.get("oldPassword");
        User user = new User();
        user.setUid(id);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(oldPwd,userService.selectUserByPrimary(id).getPassword())){
            return "error";   //判断原密码是否正确
        }else if(!newPwd.equals(renewPassword)){  //判断两次输入的密码是否一致
            return "differentError";
        }else {
            String encodedPassword = encoder.encode(newPwd);
            user.setPassword(encodedPassword);
            userService.updateUserInfo(user);
            return "ok";
        }
    }

    /**
     * 用户更换个人头像
     * @param file 上传的头像文件
     * @param uid 用户id
     * @param session 修改后的用户信息
     * @return 成功信息（0,1）与经过七牛处理的图片路径
     */
    @PostMapping(value = "/uploadImg")
    @ResponseBody
    public Map<String, Object> uploadImg(@RequestParam(value = "projectImg",required = true) MultipartFile file,
                                         int uid,HttpSession session){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            byte[] bytes = file.getBytes();
            String imageName = UUID.randomUUID().toString();
//            System.out.println(imageName);
            //使用base64方式上传到七牛云
            try {
                String url = QiniuUtil.put64image(bytes, imageName);
                System.out.println(url);
                result.put("imgUrl",url);
                result.put("success",1);
                User user = new User();
                user.setUid(uid);
                user.setImgurl(url);
                userService.updateUserInfo(user);
//                User returnUser = userService.updateUserInfo(user);
//                session.setAttribute("loginUser",returnUser);
            } catch (Exception e) {
                e.printStackTrace();
                result.put("success",0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 用户更换个人中心的背景图
     * @param file 用户上传的背景图文件
     * @param uid 用户id
     * @param session 信息的用户信息
     * @return 成功信息（0,1）与经过七牛处理的图片路径
     */
    @PostMapping(value = "/changeBackPic")
    @ResponseBody
    public Map<String, Object> changeBackPic(@RequestParam(value = "projectImg",required = false) MultipartFile file,
                                         Integer uid,HttpSession session){
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            byte[] bytes = file.getBytes();
            String imageName = UUID.randomUUID().toString();
//            System.out.println(imageName);
            //使用base64方式上传到七牛云
            try {
                String url = QiniuUtil.put64image(bytes, imageName);
                System.out.println(url);
                result.put("imgUrl",url);
                result.put("success",1);
                User user = new User();
                user.setUid(uid);
                user.setBackimg(url);
                userService.updateUserInfo(user);
//                User returnUser = userService.updateUserInfo(user);
//                session.setAttribute("loginUser",returnUser);
            } catch (Exception e) {
                e.printStackTrace();
                result.put("success",0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 跳转到对应的用户中心页面
     * @param uid
     * @param model
     * @return
     */
    @GetMapping("/u/{uid}")
    public String toOtherUser(@PathVariable(name = "uid")Integer uid,Model model){
        User user = userService.selectUserByPrimary(uid);
        model.addAttribute("others",user);
        return "user/otherUser";
    }

    @GetMapping("/user/{uid}")
    @ResponseBody
    public User toOtherUsers(@PathVariable(name = "uid")Integer uid){
        User user = userService.selectUserByPrimary(uid);
        return user;
    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/signout")
    public String userSignout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("loginUser");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

    /**
     * 查询最热门的八个用户
     * @return
     */
    @PostMapping("/user/selectHotUser")
    @ResponseBody
    public Map<String,Object> selectWithUserThreeNumMost(){
        Map<String,Object> map = new HashMap<String, Object>();
        List<User> userList = userService.selectHotUser();
        map.put("userList",userList);
        return map;
    }

}
