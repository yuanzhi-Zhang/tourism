package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.entity.Collect;
import com.yuanzhi.tourism.enums.PraiseTypeEnum;
import com.yuanzhi.tourism.service.CollectService;
import com.yuanzhi.tourism.service.CommentService;
import com.yuanzhi.tourism.service.StrategyService;
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
public class CollectController {

    @Autowired
    CollectService collectService;
    @Autowired
    StrategyService strategyService;
    @Autowired
    CommentService commentService;

    /**
     * 收藏
     * @param data
     * @return
     */
    @PostMapping("/collect/add")
    @ResponseBody
    public Map<String,Object> addCollect(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
        String publishTime = dateFormat.format(date);
        Integer typeId = Integer.parseInt(data.get("typeId"));
        Collect collect = new Collect();
        collect.setCollectType(data.get("type"));
        collect.setCollectTypeId(typeId);
        collect.setUserId(Integer.parseInt(data.get("userId")));
        collect.setCollectTime(publishTime);
        collectService.addCollect(collect);
        if(data.get("type").equals(PraiseTypeEnum.STRATEGY.getType())){
            strategyService.incCollect(typeId);
        }else if(data.get("type").equals(PraiseTypeEnum.JOURNEY.getType())){

        }else if(data.get("type").equals(PraiseTypeEnum.COMMENT.getType())){
            commentService.incCommentCount(typeId);
        }else if(data.get("type").equals(PraiseTypeEnum.ASKANSWER.getType())){

        }
        map.put("code",200);
        return map;
    }

    /**
     * 取消收藏
     * @param data
     * @return
     */
    @PostMapping("/collect/delete")
    @ResponseBody
    public Map<String,Object> deleteCollect(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer typeId = Integer.parseInt(data.get("typeId"));
        Collect collect = new Collect();
        collect.setCollectType(data.get("type"));
        collect.setCollectTypeId(typeId);
        collect.setUserId(Integer.parseInt(data.get("userId")));
        collectService.deleteCollect(collect);
        if(data.get("type").equals(PraiseTypeEnum.STRATEGY.getType())){
            strategyService.downCollect(typeId);
        }else if(data.get("type").equals(PraiseTypeEnum.JOURNEY.getType())){

        }else if(data.get("type").equals(PraiseTypeEnum.COMMENT.getType())){
            commentService.downCommentCount(typeId);
        }else if(data.get("type").equals(PraiseTypeEnum.ASKANSWER.getType())){

        }
        map.put("code",200);
        return map;
    }

    /**
     * 查询用户是否已经收藏过某篇文章
     * @param data
     * @return
     */
    @PostMapping("/collect/select")
    @ResponseBody
    public Map<String,Object> selectCollect(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Collect collect = new Collect();
        collect.setCollectType(data.get("type"));
        collect.setCollectTypeId(Integer.parseInt(data.get("typeId")));
        collect.setUserId(Integer.parseInt(data.get("userId")));
        Integer collectSize = collectService.selectCollect(collect);
        map.put("collectSize",collectSize);
        return map;
    }

}
