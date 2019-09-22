package com.yuanzhi.tourism.dao.admin;

import com.yuanzhi.tourism.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/22 13:23
 */
@Mapper
public interface AdminMapper {

    Admin getAdminByExam(@Param("adminAccount") String adminAccount, @Param("adminPassword") String adminPassword);

}
