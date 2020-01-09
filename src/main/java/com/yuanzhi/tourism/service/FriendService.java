package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.*;
import com.yuanzhi.tourism.dto.FriendResultDTO;
import com.yuanzhi.tourism.entity.*;
import com.yuanzhi.tourism.enums.NotificationStatusEnum;
import com.yuanzhi.tourism.enums.NotificationTypeEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/10/24 21:41
 */

@Service
public class FriendService {

    @Autowired
    FriendMapper friendMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    NotificationMapper notificationMapper;

    /**
     * 根据好友类型查询用户的关注粉丝等查询
     * @param uid 用户id
     * @param friendType 类型
     * @return
     */
    public List<FriendResultDTO> getTypeFriend(Integer uid, Integer friendType) {
        FriendExample friendExample = new FriendExample();
        friendExample.createCriteria().andUserIdEqualTo(uid).andFriendTypeEqualTo(friendType);
        friendExample.setOrderByClause("join_time desc");
        List<Friend>friends = friendMapper.selectByExample(friendExample);

        if(friends.size() == 0){
            return new ArrayList<>();
        }

        Set<Integer> friendId = friends.stream().map(friend -> friend.getFriendId()).collect(Collectors.toSet());
        List<Integer> friendIds = new ArrayList();
        friendIds.addAll(friendId);

        UserExample userExample = new UserExample();
        userExample.createCriteria().andUidIn(friendIds);
        List<User> users = userMapper.selectByExample(userExample);
        Map<Integer, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getUid(), user -> user));

        List<FriendResultDTO> friendResultDTOS = friends.stream().map(friend -> {
            FriendResultDTO friendResultDTO = new FriendResultDTO();
            BeanUtils.copyProperties(friend, friendResultDTO);
            friendResultDTO.setUser(userMap.get(friend.getFriendId()));
            return friendResultDTO;
        }).collect(Collectors.toList());

        return friendResultDTOS;
    }

    /**
     * 添加关注
     * @param friend 要关注的人
     * @param fans 被关注的人增加粉丝
     * @return 成功与否的状态码
     */
    public Map<String,Object> addAttention(Friend friend,Friend fans) {
        FriendExample friendExample = new FriendExample();
        friendExample.createCriteria().andFriendTypeEqualTo(friend.getFriendType()).andUserIdEqualTo(friend.getUserId())
                .andFriendIdEqualTo(friend.getFriendId());
        Long friendList = friendMapper.countByExample(friendExample);
        Map<String,Object>result = new HashMap<String, Object>();
        if(friendList == 0){
            friendMapper.insertSelective(friend);
            friendMapper.insertSelective(fans);

            User user = userMapper.selectByPrimaryKey(friend.getUserId());
            String notificationerName = user.getUsername();
            //创建通知
            Notification notification = new Notification();
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm"); //HH代表24小时制，hh代表12小时制
            notification.setSendtime(dateFormat.format(date));
            notification.setType(NotificationTypeEnum.ATTEND_USER.getType());
            notification.setTypeid(friend.getFriendId());
            notification.setNotificationer(friend.getUserId());
            notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
            notification.setReceiver(friend.getFriendId());
            notification.setNotificationername(notificationerName);
            notificationMapper.insert(notification);
            result.put("code",2000);
            return result;
        }else {
            result.put("code",2001);
            return result;
        }
    }

    /**
     * 取消关注
     * @param fid 主键
     */
    public void cancelAttention(Integer fid,Friend friend) {
//        Integer friendId = friendMapper.selectByPrimaryKey(fid).getFriendId();
        FriendExample friendExample = new FriendExample();
        friendExample.createCriteria().andFriendIdEqualTo(friend.getFriendId())
                .andUserIdEqualTo(friend.getUserId())
                .andFriendTypeEqualTo(friend.getFriendType());
        friendMapper.deleteByPrimaryKey(fid);
        friendMapper.deleteByExample(friendExample);
//        userMapper.downFansCount(friendId);
    }

    public boolean isAttended(Integer uid, Integer friendType, Integer friendId) {
        FriendExample friendExample = new FriendExample();
        friendExample.createCriteria().andFriendIdEqualTo(friendId)
                .andUserIdEqualTo(uid)
                .andFriendTypeEqualTo(friendType);
        List<Friend> friends = friendMapper.selectByExample(friendExample);
        return friends.size() != 0;
    }
}
