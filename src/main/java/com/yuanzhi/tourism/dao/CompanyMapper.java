package com.yuanzhi.tourism.dao;

import com.yuanzhi.tourism.dto.CompanyDTO;
import com.yuanzhi.tourism.dto.CompanyDTOS;
import com.yuanzhi.tourism.entity.Company;
import com.yuanzhi.tourism.entity.CompanyExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMapper {
    long countByExample(CompanyExample example);

    int deleteByExample(CompanyExample example);

    int deleteByPrimaryKey(Integer companyId);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(Integer companyId);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    List<CompanyDTO> selectWithUser();

    List<CompanyDTO> selectWithUserNew(@Param(value = "companyStartTime") Date companyStartTime, @Param(value = "companyEndTime")Date companyEndTime);

    List<CompanyDTO> selectWithUserNewUp(@Param(value = "companyStartTime") Date companyStartTime, @Param(value = "companyEndTime")Date companyEndTime);

    Long selectWithUserTodayNum();

    List<CompanyDTO> selectWithUserToday();

    List<CompanyDTO> selectWithUserMoreThreeMonth();

    Long selectWithUserMoreThreeMonthNum();

    Long selectWithUserThreeMonthNum();

    Long selectWithUserMonthNum();

    CompanyDTO selectWithUserById(Integer companyId);

    void incView(Integer companyId);

    void incComment(Integer companyId);

    void incEnterNum(Integer companyId);

    void incAttendNum(Integer companyId);

    List<CompanyDTO> selectWithUserThreeNumMost();

    List<CompanyDTO> getAllOwn(Integer companyOwnerId);

    List<CompanyDTOS> getAll(@Param(value = "page")Integer page, @Param(value = "limit")Integer limit);

    List<CompanyDTO> getByDestiny(@Param(value = "companyEndArea")String companyEndArea);

    List<CompanyDTO> selectWithUserThreeAttendNumMost();
}