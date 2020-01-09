package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.dto.HistoryDTO;
import com.yuanzhi.tourism.entity.History;
import com.yuanzhi.tourism.entity.HistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryMapper {
    long countByExample(HistoryExample example);

    int deleteByExample(HistoryExample example);

    int deleteByPrimaryKey(Integer historyId);

    int insert(History record);

    int insertSelective(History record);

    List<History> selectByExample(HistoryExample example);

    History selectByPrimaryKey(Integer historyId);

    int updateByExampleSelective(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByExample(@Param("record") History record, @Param("example") HistoryExample example);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);

    void incTimes(Integer historyId);

    List<HistoryDTO> getAll(@Param("page")Integer page, @Param("limit")Integer limit);
}