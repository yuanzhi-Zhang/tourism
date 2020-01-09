package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.dto.SearchDTO;
import com.yuanzhi.tourism.entity.Search;
import com.yuanzhi.tourism.entity.SearchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchMapper {
    long countByExample(SearchExample example);

    int deleteByExample(SearchExample example);

    int deleteByPrimaryKey(Integer searchId);

    int insert(Search record);

    int insertSelective(Search record);

    List<Search> selectByExample(SearchExample example);

    Search selectByPrimaryKey(Integer searchId);

    int updateByExampleSelective(@Param("record") Search record, @Param("example") SearchExample example);

    int updateByExample(@Param("record") Search record, @Param("example") SearchExample example);

    int updateByPrimaryKeySelective(Search record);

    int updateByPrimaryKey(Search record);

    void incTimes(Integer searchId);

    List<SearchDTO> getAll(@Param("page")Integer page, @Param("limit")Integer limit);
}