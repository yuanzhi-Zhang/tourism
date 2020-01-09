package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.entity.Praise;
import com.yuanzhi.tourism.enums.PraiseTypeEnum;
import com.yuanzhi.tourism.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/3 22:19
 */

@Controller
public class PraiseController {

    @Autowired
    PraiseService praiseService;
    @Autowired
    StrategyService strategyService;
    @Autowired
    JourneyService journeyService;
    @Autowired
    CommentService commentService;
    @Autowired
    NotificationService notificationService;

    /**
     * 点赞
     * @param data
     * @return
     */
    @PostMapping("/praise/add")
    @ResponseBody
    public Map<String,Object> addPraise(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
        String publishTime = dateFormat.format(date);
        Integer typeId = Integer.parseInt(data.get("typeId"));
        Praise praise = new Praise();
        praise.setUserid(Integer.parseInt(data.get("userId")));
        praise.setPraiseType(data.get("type"));
        praise.setPraiseTypeId(typeId);
        praise.setPraiseTime(publishTime);
        praiseService.addPraise(praise);
        if(data.get("type").equals(PraiseTypeEnum.STRATEGY.getType())){
            strategyService.incPraise(typeId);
            notificationService.addStrategyNotice(praise);
        }else if(data.get("type").equals(PraiseTypeEnum.JOURNEY.getType())){
            journeyService.incPrise(typeId);
            notificationService.addJourneyNotice(praise);
        }else if(data.get("type").equals(PraiseTypeEnum.COMMENT.getType())){
            commentService.incCommentPraiseNum(typeId);
        }else if(data.get("type").equals(PraiseTypeEnum.ASKANSWER.getType())){

        }
        map.put("code",200);
        return map;
    }

    /**
     * 取消点赞
     * @param data
     * @return
     */
    @PostMapping("/praise/delete")
    @ResponseBody
    public Map<String,Object> deletePraise(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer typeId = Integer.parseInt(data.get("typeId"));
        Praise praise = new Praise();
        praise.setUserid(Integer.parseInt(data.get("userId")));
        praise.setPraiseType(data.get("type"));
        praise.setPraiseTypeId(typeId);
        praiseService.deletePraise(praise);
        if(data.get("type").equals(PraiseTypeEnum.STRATEGY.getType())){
            strategyService.downPraise(typeId);
        }else if(data.get("type").equals(PraiseTypeEnum.JOURNEY.getType())){
            journeyService.downPrise(typeId);
        }else if(data.get("type").equals(PraiseTypeEnum.COMMENT.getType())){
            commentService.downCommentPraiseNum(typeId);
        }else if(data.get("type").equals(PraiseTypeEnum.ASKANSWER.getType())){

        }
        map.put("code",200);
        return map;
    }

    /**
     * 查询用户是否已经点赞过某篇文章
     * @param data
     * @return
     */
    @PostMapping("/praise/select")
    @ResponseBody
    public Map<String,Object> selectPraise(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Praise praise = new Praise();
        praise.setUserid(Integer.parseInt(data.get("userId")));
        praise.setPraiseType(data.get("type"));
        praise.setPraiseTypeId(Integer.parseInt(data.get("typeId")));
        Integer praiseSize =  praiseService.selectPraise(praise);
        map.put("praiseSize",praiseSize);
        return map;
    }

}
