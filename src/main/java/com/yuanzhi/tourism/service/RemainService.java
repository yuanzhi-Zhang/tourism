package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.NotificationMapper;
import com.yuanzhi.tourism.dao.RemainMapper;
import com.yuanzhi.tourism.dao.UserMapper;
import com.yuanzhi.tourism.dto.RemainResultDTO;
import com.yuanzhi.tourism.entity.Notification;
import com.yuanzhi.tourism.entity.Remain;
import com.yuanzhi.tourism.entity.RemainExample;
import com.yuanzhi.tourism.enums.NotificationStatusEnum;
import com.yuanzhi.tourism.enums.NotificationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/24 10:51
 */
@Service
public class RemainService {

    @Autowired
    RemainMapper remainMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    NotificationMapper notificationMapper;

    public List<RemainResultDTO> getAllRemain(Integer uid) {
        return remainMapper.selectWithUser(uid);
    }

    public void addRemain(Remain remain) {
        remainMapper.insertSelective(remain);

        if(remain.getRemainSenderId() == remain.getRemainReceiverId()){
            return;
        }
        String userName = userMapper.selectByPrimaryKey(remain.getRemainSenderId()).getUsername();
        Notification notification = new Notification();
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
        notification.setSendtime(dateFormat.format(date));
        notification.setType(NotificationTypeEnum.REMAIN_USER.getType());
        notification.setTypeid(remain.getRemainId());
        notification.setNotificationer(remain.getRemainSenderId());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(remain.getRemainReceiverId());
        notification.setNotificationername(userName);
        notification.setTypename(remain.getRemainContent());
        notificationMapper.insert(notification);
    }

    public void deleteRemain(Integer remainId) {
        remainMapper.deleteByPrimaryKey(remainId);
    }

    public Long remainNum() {
        return remainMapper.countByExample(null);
    }

    public List<Remain> getAll(Integer page, Integer limit) {
        return remainMapper.getAll(page,limit);
    }

    public void batchDelRemain(List<Integer> uidLst) {
        for (int i = 0; i < uidLst.size(); i++) {
            remainMapper.deleteByPrimaryKey(uidLst.get(i));
        }
    }
}
