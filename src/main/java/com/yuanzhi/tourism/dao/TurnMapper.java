package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.entity.Turn;
import com.yuanzhi.tourism.entity.TurnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnMapper {
    long countByExample(TurnExample example);

    int deleteByExample(TurnExample example);

    int deleteByPrimaryKey(Integer turnId);

    int insert(Turn record);

    int insertSelective(Turn record);

    List<Turn> selectByExample(TurnExample example);

    Turn selectByPrimaryKey(Integer turnId);

    int updateByExampleSelective(@Param("record") Turn record, @Param("example") TurnExample example);

    int updateByExample(@Param("record") Turn record, @Param("example") TurnExample example);

    int updateByPrimaryKeySelective(Turn record);

    int updateByPrimaryKey(Turn record);

    List<Turn> getAll(@Param("page")Integer page, @Param("limit")Integer limit);
}