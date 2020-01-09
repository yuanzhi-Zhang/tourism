package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.CollectMapper;
import com.yuanzhi.tourism.dao.NotificationMapper;
import com.yuanzhi.tourism.dao.StrategyMapper;
import com.yuanzhi.tourism.dao.UserMapper;
import com.yuanzhi.tourism.entity.Collect;
import com.yuanzhi.tourism.entity.CollectExample;
import com.yuanzhi.tourism.entity.Notification;
import com.yuanzhi.tourism.entity.Strategy;
import com.yuanzhi.tourism.enums.NotificationStatusEnum;
import com.yuanzhi.tourism.enums.NotificationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/3 22:18
 */

@Service
public class CollectService {

    @Autowired
    CollectMapper collectMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    NotificationMapper notificationMapper;
    @Autowired
    StrategyMapper strategyMapper;

    public void addCollect(Collect collect) {
        collectMapper.insertSelective(collect);

        Strategy strategy = strategyMapper.selectByPrimaryKey(collect.getCollectTypeId());
        Integer receiverId = strategy.getUserId();
        if(receiverId == collect.getUserId()){
            return;
        }
        String notificationerName = userMapper.selectByPrimaryKey(collect.getUserId()).getUsername();
        String typeIdName = strategy.getStrategyTitle();
        //创建通知
        Notification notification = new Notification();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
        notification.setSendtime(dateFormat.format(date));
        notification.setType(NotificationTypeEnum.COLLECT_STRATEGY.getType());
        notification.setTypeid(collect.getCollectTypeId());
        notification.setNotificationer(collect.getUserId());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(receiverId);
        notification.setNotificationername(notificationerName);
        notification.setTypeidname(typeIdName);
        notificationMapper.insert(notification);
    }

    public void deleteCollect(Collect collect) {
        CollectExample collectExample = new CollectExample();
        collectExample.createCriteria().andCollectTypeEqualTo(collect.getCollectType())
                .andCollectTypeIdEqualTo(collect.getCollectTypeId())
                .andUserIdEqualTo(collect.getUserId());
        collectMapper.deleteByExample(collectExample);
    }

    public Integer selectCollect(Collect collect) {
        CollectExample collectExample = new CollectExample();
        collectExample.createCriteria().andCollectTypeEqualTo(collect.getCollectType())
                .andCollectTypeIdEqualTo(collect.getCollectTypeId())
                .andUserIdEqualTo(collect.getUserId());
        return collectMapper.selectByExample(collectExample).size();
    }
}
