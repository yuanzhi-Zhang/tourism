package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.dto.EnterCompanyDTO;
import com.yuanzhi.tourism.dto.EnterDTO;
import com.yuanzhi.tourism.entity.Enter;
import com.yuanzhi.tourism.entity.EnterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterMapper {
    long countByExample(EnterExample example);

    int deleteByExample(EnterExample example);

    int deleteByPrimaryKey(Integer enterId);

    int insert(Enter record);

    int insertSelective(Enter record);

    List<Enter> selectByExample(EnterExample example);

    Enter selectByPrimaryKey(Integer enterId);

    int updateByExampleSelective(@Param("record") Enter record, @Param("example") EnterExample example);

    int updateByExample(@Param("record") Enter record, @Param("example") EnterExample example);

    int updateByPrimaryKeySelective(Enter record);

    int updateByPrimaryKey(Enter record);

    List<EnterDTO> selectWithUser(Integer companyId);

    List<EnterCompanyDTO> getByUser(Integer userId);
}