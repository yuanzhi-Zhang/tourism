package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.UserMapper;
import com.yuanzhi.tourism.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
}
