package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.entity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    void updateToken(@Param("statuscode") String statuscode, @Param("uid") Integer uid);

    void incFansCount(Integer uid);

    void downFansCount(Integer uid);

    void incJourneyCount(Integer uid);

    List<User> selectHotUser();

    List<User> selectUser(@Param("page")Integer page, @Param("limit")Integer limit);
}