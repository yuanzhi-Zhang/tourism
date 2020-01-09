package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.CompanyMapper;
import com.yuanzhi.tourism.dao.EnterMapper;
import com.yuanzhi.tourism.dao.NotificationMapper;
import com.yuanzhi.tourism.dao.UserMapper;
import com.yuanzhi.tourism.dto.EnterCompanyDTO;
import com.yuanzhi.tourism.dto.EnterDTO;
import com.yuanzhi.tourism.entity.Company;
import com.yuanzhi.tourism.entity.Enter;
import com.yuanzhi.tourism.entity.EnterExample;
import com.yuanzhi.tourism.entity.Notification;
import com.yuanzhi.tourism.enums.NotificationStatusEnum;
import com.yuanzhi.tourism.enums.NotificationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/5 13:17
 */

@Service
public class EnterService {

    @Autowired
    EnterMapper enterMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    NotificationMapper notificationMapper;

    public void addEnter(Enter enter) {
        enterMapper.insertSelective(enter);

        Company company = companyMapper.selectByPrimaryKey(enter.getCompanyId());
        Integer receiverId = company.getCompanyOwnerId();
        String notificationerName = userMapper.selectByPrimaryKey(enter.getUserId()).getUsername();
        String typeIdName = company.getCompanyTitle();
        //创建通知
        Notification notification = new Notification();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
        notification.setSendtime(dateFormat.format(date));
        notification.setType(NotificationTypeEnum.ENTER_COMPANY.getType());
        notification.setTypeid(enter.getCompanyId());
        notification.setNotificationer(enter.getUserId());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(receiverId);
        notification.setNotificationername(notificationerName);
        notification.setTypeidname(typeIdName);
        notificationMapper.insert(notification);
    }

    public Long isEntered(Integer companyId, Integer userId) {
        EnterExample enterExample = new EnterExample();
        enterExample.createCriteria().andCompanyIdEqualTo(companyId)
                .andUserIdEqualTo(userId);
        return enterMapper.countByExample(enterExample);
    }

    public List<EnterDTO> getWithUser(Integer companyId) {
        return enterMapper.selectWithUser(companyId);
    }

    public List<EnterCompanyDTO> getUserEnter(Integer userId) {
        return enterMapper.getByUser(userId);
    }
}
