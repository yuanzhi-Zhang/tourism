package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.entity.Praise;
import com.yuanzhi.tourism.entity.PraiseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PraiseMapper {
    long countByExample(PraiseExample example);

    int deleteByExample(PraiseExample example);

    int deleteByPrimaryKey(Integer praiseId);

    int insert(Praise record);

    int insertSelective(Praise record);

    List<Praise> selectByExample(PraiseExample example);

    Praise selectByPrimaryKey(Integer praiseId);

    int updateByExampleSelective(@Param("record") Praise record, @Param("example") PraiseExample example);

    int updateByExample(@Param("record") Praise record, @Param("example") PraiseExample example);

    int updateByPrimaryKeySelective(Praise record);

    int updateByPrimaryKey(Praise record);
}