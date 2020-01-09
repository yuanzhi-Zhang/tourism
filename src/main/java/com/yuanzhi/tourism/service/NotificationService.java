package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.JourneyMapper;
import com.yuanzhi.tourism.dao.NotificationMapper;
import com.yuanzhi.tourism.dao.StrategyMapper;
import com.yuanzhi.tourism.dao.UserMapper;
import com.yuanzhi.tourism.entity.*;
import com.yuanzhi.tourism.enums.NotificationStatusEnum;
import com.yuanzhi.tourism.enums.NotificationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/8 15:32
 */

@Service
public class NotificationService {

    @Autowired
    NotificationMapper notificationMapper;
    @Autowired
    StrategyMapper strategyMapper;
    @Autowired
    JourneyMapper journeyMapper;
    @Autowired
    UserMapper userMapper;


    public List<Notification> getByUser(Integer userId) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andReceiverEqualTo(userId);
        notificationExample.setOrderByClause("sendTime desc");
        return notificationMapper.selectByExample(notificationExample);
    }

    public void upRead(Integer noteId) {
        Notification notification = new Notification();
        notification.setNid(noteId);
        notification.setStatus(1);
        notificationMapper.updateByPrimaryKeySelective(notification);
    }

    public void upDelete(Integer noteId) {
        notificationMapper.deleteByPrimaryKey(noteId);
    }

    public Long noteNum(Integer userId) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andReceiverEqualTo(userId).andStatusEqualTo(0);
        return notificationMapper.countByExample(notificationExample);
    }

    public void addStrategyNotice(Praise praise) {
        Strategy strategy = strategyMapper.selectByPrimaryKey(praise.getPraiseTypeId());
        Integer receiverId = strategy.getUserId();
        if(praise.getUserid() == receiverId){
            return;
        }
        String notificationerName = userMapper.selectByPrimaryKey(praise.getUserid()).getUsername();
        String typeIdName = strategy.getStrategyTitle();
        //创建通知
        Notification notification = new Notification();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
        notification.setSendtime(dateFormat.format(date));
        notification.setType(NotificationTypeEnum.PRAISE_STRATEGY.getType());
        notification.setTypeid(praise.getPraiseTypeId());
        notification.setNotificationer(praise.getUserid());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(receiverId);
        notification.setNotificationername(notificationerName);
        notification.setTypeidname(typeIdName);
        notificationMapper.insert(notification);
    }

    public void addJourneyNotice(Praise praise) {
        Journey journey = journeyMapper.selectByPrimaryKey(praise.getPraiseTypeId());
        Integer receiverId = journey.getUserid();
        if(praise.getUserid() == receiverId){
            return;
        }
        String notificationerName = userMapper.selectByPrimaryKey(praise.getUserid()).getUsername();
        String typeIdName = journey.getJourtitle();
        //创建通知
        Notification notification = new Notification();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
        notification.setSendtime(dateFormat.format(date));
        notification.setType(NotificationTypeEnum.PRAISE_JOURNEY.getType());
        notification.setTypeid(praise.getPraiseTypeId());
        notification.setNotificationer(praise.getUserid());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(receiverId);
        notification.setNotificationername(notificationerName);
        notification.setTypeidname(typeIdName);
        notificationMapper.insert(notification);
    }

    public Long noteTotal() {
        return notificationMapper.countByExample(null);
    }

    public List<Notification> getAll(Integer page, Integer limit) {
        return notificationMapper.getAll(page,limit);
    }

    public void deleteNotice(Integer companyId) {
        notificationMapper.deleteByPrimaryKey(companyId);
    }

    public void batchDelNotice(List<Integer> uidLst) {
        for (int i = 0; i < uidLst.size(); i++) {
            notificationMapper.deleteByPrimaryKey(uidLst.get(i));
        }
    }
}
