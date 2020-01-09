package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.entity.Attend;
import com.yuanzhi.tourism.entity.AttendExample;
import java.util.List;

import com.yuanzhi.tourism.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendMapper {
    long countByExample(AttendExample example);

    int deleteByExample(AttendExample example);

    int deleteByPrimaryKey(Integer attendId);

    int insert(Attend record);

    int insertSelective(Attend record);

    List<Attend> selectByExample(AttendExample example);

    Attend selectByPrimaryKey(Integer attendId);

    int updateByExampleSelective(@Param("record") Attend record, @Param("example") AttendExample example);

    int updateByExample(@Param("record") Attend record, @Param("example") AttendExample example);

    int updateByPrimaryKeySelective(Attend record);

    int updateByPrimaryKey(Attend record);

    List<User> attendUserSelect(@Param("attendType") Integer attendType, @Param("attendTypeId") Integer attendTypeId);
}