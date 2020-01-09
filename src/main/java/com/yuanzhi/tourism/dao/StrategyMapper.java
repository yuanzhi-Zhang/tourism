package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.dto.RefreshNumDTO;
import com.yuanzhi.tourism.dto.StrategyDTO;
import com.yuanzhi.tourism.entity.Strategy;
import com.yuanzhi.tourism.entity.StrategyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StrategyMapper {
    long countByExample(StrategyExample example);

    int deleteByExample(StrategyExample example);

    int deleteByPrimaryKey(Integer strategyId);

    int insert(Strategy record);

    int insertSelective(Strategy record);

    List<Strategy> selectByExample(StrategyExample example);

    Strategy selectByPrimaryKey(Integer strategyId);

    int updateByExampleSelective(@Param("record") Strategy record, @Param("example") StrategyExample example);

    int updateByExample(@Param("record") Strategy record, @Param("example") StrategyExample example);

    int updateByPrimaryKeySelective(Strategy record);

    int updateByPrimaryKey(Strategy record);

    List<Strategy> getStrategyPage(@Param("page") Integer page, @Param("size") Integer size);

    void incView(Integer strategyId);

    void incPraise(Integer strategyId);

    void incComment(Integer strategyId);

    void incCollect(Integer strategyId);

    void downPraise(Integer strategyId);

    void downCollect(Integer strategyId);

    RefreshNumDTO refreshNum(Integer strategyId);

    List<Strategy> selectThreePraiseMost();

    List<StrategyDTO> getAll(@Param("page")Integer page, @Param("limit")Integer limit);
}