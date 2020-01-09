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

    /**
     * 跳转到注册页面
     * @return
     */
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
        return "user/albumworld";
    }

    /**
     * 跳转到景点页面
     * @return
     */
    @GetMapping("/scene")
    public String toScene(){
        return "user/scene";
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

    /**
     * 跳转到旅游攻略发布页面
     * @return
     */
    @GetMapping("/strategyPublish")
    public String toStrategyPublish(){
        return "user/strategyPublish";
    }

    /**
     * 跳转到游记发布页面
     * @return
     */
    @GetMapping("/journeyPublish")
    public String toJourneyPublish(){
        return "user/journeyPublish";
    }

    /**
     * 跳转到问答页面
     * @return
     */
    @GetMapping("/askAnswer")
    public String toAskAnswer(){
        return "user/askAnswer";
    }

    /**
     * 跳转到自由行页面
     * @return
     */
    @GetMapping("/freeTour")
    public String toFreeTour(){
        return "user/freeTour";
    }

    /**
     * 跳转到当地游页面
     * @return
     */
    @GetMapping("/localTour")
    public String toLocalTour(){
        return "user/localTour";
    }

    /**
     * 跳转到组团游页面
     * @return
     */
    @GetMapping("/groupTour")
    public String toGroupTour(){
        return "user/groupTour";
    }

    /**
     * 跳转到结伴页面
     * @return
     */
    @GetMapping("/company")
    public String toCompany(){
        return "user/company";
    }

    /**
     * 跳转到结伴详情页面
     * @return
     */
    @GetMapping("/company/detail")
    public String toCompanyDetail(){
        return "user/companyDetail";
    }

    /**
     * 跳转到结伴发布页面
     * @return
     */
    @GetMapping("/company/publish")
    public String toCompanyPublish(){
        return "user/companyPublish";
    }

    /**
     * 跳转到线路/景点详情页面
     * @return
     */
    @GetMapping("/routeDetail")
    public String toRouteDetail(){
        return "user/routeDetail";
    }

    /**
     * 跳转到发布问题页面
     * @return
     */
    @GetMapping("/askPublish")
    public String toAskPublish(){
        return "user/askPublish";
    }

    /**
     * 跳转到问题详情页面
     * @return
     */
    @GetMapping("/askAnswerDetail")
    public String toAskDetail(){
        return "user/askAnswerDetail";
    }

    /**
     * 跳转到通知页面
     * @return
     */
    @GetMapping("/note")
    public String toNotification(){
        return "user/notification";
    }

    @GetMapping("/search")
    public String toSearch(){
        return "user/search";
    }

    @GetMapping("/album")
    public String toAlbum(){
        return "user/album";
    }

    @GetMapping("/albumUpload")
    public String toAlbumUpload(){
        return "user/albumUpload";
    }

    @GetMapping("/message")
    public String toMessage(){
        return "user/message";
    }

    @GetMapping("/mail")
    public String toMail(){
        return "user/mailtest";
    }

    @GetMapping("/webSocket")
    public String toWebSocket(){
        return "user/webSocket";
    }

}
