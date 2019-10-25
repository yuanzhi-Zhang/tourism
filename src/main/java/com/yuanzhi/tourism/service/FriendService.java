package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.FriendMapper;
import com.yuanzhi.tourism.dao.HistoryMapper;
import com.yuanzhi.tourism.dao.JourneyMapper;
import com.yuanzhi.tourism.dao.UserMapper;
import com.yuanzhi.tourism.dto.FriendResultDTO;
import com.yuanzhi.tourism.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    JourneyMapper journeyMapper;
    @Autowired
    HistoryMapper historyMapper;

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

        JourneyExample journeyExample = new JourneyExample();
        journeyExample.createCriteria().andUseridIn(friendIds);
        Long journeyCount = journeyMapper.countByExample(journeyExample);

        FriendExample friendExample1 = new FriendExample();
        friendExample1.createCriteria().andFriendTypeEqualTo(2).andFriendIdIn(friendIds);
        Long fansCount = friendMapper.countByExample(friendExample1);

        HistoryExample historyExample = new HistoryExample();
        historyExample.createCriteria().andUserIdIn(friendIds);
        Long historyCount = historyMapper.countByExample(historyExample);

        List<FriendResultDTO>friendResultDTOS = friends.stream().map(friend -> {
            FriendResultDTO friendResultDTO = new FriendResultDTO();
            BeanUtils.copyProperties(friend, friendResultDTO);
            friendResultDTO.setUser(userMap.get(friend.getFriendId()));
            friendResultDTO.setJourneyCount(journeyCount);
            friendResultDTO.setFansCount(fansCount);
            friendResultDTO.setHistoryCount(historyCount);
            return friendResultDTO;
        }).collect(Collectors.toList());
        System.out.println(friendResultDTOS);

        return null;
    }
}
