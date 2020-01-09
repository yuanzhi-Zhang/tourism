package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.dto.RemainResultDTO;
import com.yuanzhi.tourism.entity.Remain;
import com.yuanzhi.tourism.entity.RemainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RemainMapper {
    long countByExample(RemainExample example);

    int deleteByExample(RemainExample example);

    int deleteByPrimaryKey(Integer remainId);

    int insert(Remain record);

    int insertSelective(Remain record);

    List<Remain> selectByExample(RemainExample example);

    List<RemainResultDTO> selectWithUser(Integer remainReceiverId);

    Remain selectByPrimaryKey(Integer remainId);

    int updateByExampleSelective(@Param("record") Remain record, @Param("example") RemainExample example);

    int updateByExample(@Param("record") Remain record, @Param("example") RemainExample example);

    int updateByPrimaryKeySelective(Remain record);

    int updateByPrimaryKey(Remain record);

    List<Remain> getAll(@Param("page")Integer page, @Param("limit")Integer limit);
}