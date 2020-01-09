package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.AttendMapper;
import com.yuanzhi.tourism.dao.CompanyMapper;
import com.yuanzhi.tourism.dao.NotificationMapper;
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
 * @Date: created in  2019/12/6 17:13
 */

@Service
public class AttendService {

    @Autowired
    AttendMapper attendMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    NotificationMapper notificationMapper;

    public void addAttend(Attend attend) {
        attendMapper.insertSelective(attend);

        Company company = companyMapper.selectByPrimaryKey(attend.getAttendTypeId());
        Integer receiverId = company.getCompanyOwnerId();
        if(receiverId == attend.getAttendUserId()){
            return;
        }
        String notificationerName = userMapper.selectByPrimaryKey(attend.getAttendUserId()).getUsername();
        String typeIdName = company.getCompanyTitle();
        //创建通知
        Notification notification = new Notification();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
        notification.setSendtime(dateFormat.format(date));
        notification.setType(NotificationTypeEnum.ATTEND_COMPANY.getType());
        notification.setTypeid(attend.getAttendTypeId());
        notification.setNotificationer(attend.getAttendUserId());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(receiverId);
        notification.setNotificationername(notificationerName);
        notification.setTypeidname(typeIdName);
        notificationMapper.insert(notification);
    }

    public Long isAttend(Attend attend) {
        AttendExample attendExample = new AttendExample();
        attendExample.createCriteria().andAttendTypeEqualTo(attend.getAttendType())
                .andAttendTypeIdEqualTo(attend.getAttendTypeId())
                .andAttendUserIdEqualTo(attend.getAttendUserId());
        return attendMapper.countByExample(attendExample);
    }

    public List<User> attendUserSelect(Integer attendType, Integer attendTypeId) {
        return attendMapper.attendUserSelect(attendType,attendTypeId);
    }
}
