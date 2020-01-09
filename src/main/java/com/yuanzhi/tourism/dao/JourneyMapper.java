package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.dto.JourneyDTO;
import com.yuanzhi.tourism.dto.RefreshNumDTO;
import com.yuanzhi.tourism.entity.Journey;
import com.yuanzhi.tourism.entity.JourneyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyMapper {
    long countByExample(JourneyExample example);

    int deleteByExample(JourneyExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Journey record);

    int insertSelective(Journey record);

    int incView(Integer tid);

    List<Journey> selectWithUser();

    List<Journey> selectByExample(JourneyExample example);

    Journey selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") Journey record, @Param("example") JourneyExample example);

    int updateByExample(@Param("record") Journey record, @Param("example") JourneyExample example);

    int updateByPrimaryKeySelective(Journey record);

    int updateByPrimaryKey(Journey record);

    Journey selectWithUserByPrimaryKey(Integer tid);

    int incCommentCount(Integer tid);

    RefreshNumDTO refreshNum(Integer tid);

    void incPrise(Integer tid);

    void downPrise(Integer tid);

    List<JourneyDTO> getAll(@Param("page") Integer page, @Param("limit") Integer limit);

    List<Journey> selectThreePraiseMost();
}