package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.UserMapper;
import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.entity.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/23 19:06
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 查询所有用户
     * @return
     * @param page
     * @param limit
     */
    public List<User> getAllUser(Integer page, Integer limit) {
        return userMapper.selectUser(page,limit);
    }

    /**
     * 添加用户
     * @param user
     */
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    /**
     * 核对用户的登录信息是否正确
     * @param account 账号
     * @param accountType 账号类型（1表示邮箱登录，0表示手机号登录）
     * @param password 密码
     * @return
     */
    public User loginCheck(String account,Integer accountType,String password,String statuscode) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if(accountType == 1){
            criteria.andEmailEqualTo(account);
        }else if(accountType == 0){
            criteria.andPhoneEqualTo(account);
        }
//        criteria.andPasswordEqualTo(password);
        List<User> returnUser = userMapper.selectByExample(userExample);
        if (returnUser.size() == 0){
            return null;
        }else {
            User dbUser =returnUser.get(0);
            userMapper.updateToken(statuscode,dbUser.getUid());
            return returnUser.get(0);
        }
    }

    /**
     * 根据主键修改用户信息
     * @param user
     * @return
     */
//    public User updateUserInfo(User user) {
//        UserExample userExample = new UserExample();
//        UserExample.Criteria criteria = userExample.createCriteria();
//        criteria.andUidEqualTo(user.getUid());
//        userMapper.updateByExampleSelective(user,userExample);
//        return userMapper.selectByPrimaryKey(user.getUid());
//    }
    public void updateUserInfo(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUidEqualTo(user.getUid());
        userMapper.updateByExampleSelective(user,userExample);
    }

    public User selectUserByPrimary(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据令牌查询用户信息
     * @param token
     * @return
     */
    public List<User> selectByExample(String token) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andStatuscodeEqualTo(token);
        return userMapper.selectByExample(userExample);
    }

    public void incFans(Integer friendId) {
        userMapper.incFansCount(friendId);
    }

    public void downFansCount(Integer friendId) {
        userMapper.downFansCount(friendId);
    }

    public void incJourneyCount(Integer uid) {
        userMapper.incJourneyCount(uid);
    }

    public List<User> selectHotUser() {
        return userMapper.selectHotUser();
    }

    public void delUser(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    public void batchDelUser(List<Integer> uidLst) {
        for (int i = 0; i < uidLst.size(); i++) {
            userMapper.deleteByPrimaryKey(uidLst.get(i));
        }
    }

    public Long getUserNum() {
        return userMapper.countByExample(null);
    }

    public Long getMaleNum() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsersexEqualTo("男");
        return userMapper.countByExample(userExample);
    }

    public Long getfeMaleNum() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsersexEqualTo("女");
        return userMapper.countByExample(userExample);
    }

    public Long getfeUnKnowNum() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsersexIsNull();
        return userMapper.countByExample(userExample);
    }
}
