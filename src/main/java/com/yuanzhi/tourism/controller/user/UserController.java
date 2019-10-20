package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.entity.Journey;
import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.service.JourneyService;
import com.yuanzhi.tourism.service.UserService;
import com.yuanzhi.tourism.utils.QiniuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
//     * @param session 用户信息
     * @param email 账号
     * @param password 密码
     * @param map 账号密码错误信息
     * @return
     */
    @PostMapping(value = "/password")
    public String userLogin(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session, Map<String,Object> map){
        User user = new User();
        user.setEmail(email);
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

    /**
     * 用户注册
     * @param username 账号
     * @param password 密码
     * @param repwd 重复密码核对
     * @param email 邮箱
     * @param map 错误提示信息
     * @param session 新用户信息
     * @return
     */
    @PostMapping(value = "/regist")
    public String userRegister(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("repwd") String repwd,
                               @RequestParam("email") String email,
                               Map<String,Object> map,HttpSession session){
        if(!password.equals(repwd)){
            map.put("errmsg","前后密码不一致");
            return "user/userRegister";
        }else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRepwd(repwd);
            user.setEmail(email);
            user.setStatus(1);
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
        String sex = userInfo.get("sex");
        String selfInfo = userInfo.get("selfInfo");
        String userName = userInfo.get("username");
        String address = userInfo.get("address");
        int id = Integer.parseInt(userInfo.get("id"));
        User user = new User();
        user.setBirthday(birth);
        user.setUsersex(sex);
        user.setSelfintro(selfInfo);
        user.setUsername(userName);
        user.setAddress(address);
        user.setUid(id);
        User returnUser = userService.updateUserInfo(user);
        session.setAttribute("loginUser",returnUser);
        return "ok";
    }

    /**
     * 用户修改密码
     * @param request
     * @param response
     * @param passwordInfo  前端传来的用户的密码修改的json对象
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/modifyPwd")
    @ResponseBody
    public String modifyPwd(HttpServletRequest request,HttpServletResponse response,
                            @RequestBody Map<String,String> passwordInfo) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        int id = Integer.parseInt(passwordInfo.get("id"));
        String newPwd = passwordInfo.get("newPassword");
        String renewPassword = passwordInfo.get("renewPassword");
        String oldPwd = passwordInfo.get("oldPassword");
        User user = new User();
        user.setUid(id);
        if(!oldPwd.equals(userService.selectUserByPrimary(id).getPassword())){
            return "error";   //判断原密码是否正确
        }else if(!newPwd.equals(renewPassword)){  //判断两次输入的密码是否一致
            return "differentError";
        }else {
            user.setPassword(newPwd);
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
                User returnUser = userService.updateUserInfo(user);
                session.setAttribute("loginUser",returnUser);
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
                User returnUser = userService.updateUserInfo(user);
                session.setAttribute("loginUser",returnUser);
            } catch (Exception e) {
                e.printStackTrace();
                result.put("success",0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping("/signout")
    public String userSignout(HttpSession session){
        session.removeAttribute("loginUser");
        return "redirect:/self";
    }

}
