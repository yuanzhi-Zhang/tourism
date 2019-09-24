package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.UserMapper;
import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/23 19:06
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Collection<User> getAllUser() {

        return userMapper.selectByExample(null);

    }

    public void saveUser(User user) {

        userMapper.insert(user);

    }

    /**
     * 核对用户的登录信息是否正确
     * @param user
     * @return
     */
    public User loginCheck(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        UserExample.Criteria account = criteria.andAccountEqualTo(user.getAccount());
        UserExample.Criteria password = criteria.andAccountEqualTo(user.getPassword());
        List<User> returnUser = userMapper.selectByExample(userExample);
        return returnUser.get(0);
    }
}
