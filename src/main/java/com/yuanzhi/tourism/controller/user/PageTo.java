package com.yuanzhi.tourism.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: yuanzhi...
 *   页面的跳转
 * @Date: created in  2019/9/25 17:35
 */

@Controller
public class PageTo {

    /**
     * 跳转到用户登录页面
     * @return
     */
    @GetMapping("/account")
    public String toLogin(){
        return "user/userLogin";
    }

    @GetMapping("/register")
    public String toRegister(){
        return "user/userRegister";
    }

    /**
     * 跳转到旅行相册（findworld）页面
     * @return
     */
    @GetMapping("/albumworld")
    public String toFindWorld(){
        return "user/findWorld";
    }

    /**
     * 跳转到个人中心页面
     * @return
     */
    @GetMapping("/self")
    public String toOwn(){
        return "user/own";
    }

    /**
     * 跳转到游记详情页面
     * @return
     */
    @GetMapping("/journeyDetail")
    public String toTourAlbumDetail(){
        return "user/journeyDetail";
    }

    /**
     * 跳转到机票页面
     * @return
     */
    @GetMapping("/flight")
    public String toFlight(){
        return "user/flight";
    }

    /**
     * 跳转到酒店页面
     * @return
     */
    @GetMapping("/hotel")
    public String toOrderHotel(){
        return "user/orderHotel";
    }

    /**
     * 跳转到个人信息设置页面
     * @return
     */
    @GetMapping("/setting")
    public String toSetting(){
        return "user/setting";
    }

    /**
     * 跳转到个人信息的我的头像页面
     * @return
     */
    @GetMapping("/setting/ownImg")
    public String userImg(){
        return "user/ownInfo/ownImg";
    }

    /**
     * 跳转到个人信息的我的粉丝页面
     * @return
     */
    @GetMapping("/setting/ownFan")
    public String userFan(){
        return "user/ownInfo/ownFan";
    }

    /**
     * 跳转到个人信息的黑名单页面
     * @return
     */
    @GetMapping("/setting/blackBan")
    public String userBlackBan(){
        return "user/ownInfo/blackBan";
    }

    /**
     * 跳转到个人信息的修改密码页面
     * @return
     */
    @GetMapping("/setting/modifyPwd")
    public String userModifyPwd(){
        return "user/ownInfo/modifyPwd";
    }

    /**
     * 跳转到个人信息的我的关注页面
     * @return
     */
    @GetMapping("/setting/ownAttended")
    public String userAttended(){
        return "user/ownInfo/ownAttended";
    }

    /**
     * 跳转到旅游攻略页面
     * @return
     */
    @GetMapping("/strategy")
    public String toStrategy(){
        return "user/strategy";
    }

    /**
     * 跳转到旅游攻略详情页面
     * @return
     */
    @GetMapping("/strategyDetail")
    public String toStrategyDetail(){
        return "user/strategyDetail";
    }

    @GetMapping("/mail")
    public String toMail(){
        return "user/mailtest";
    }

}
