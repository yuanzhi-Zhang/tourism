package com.yuanzhi.tourism.service.admin;

import com.yuanzhi.tourism.dao.admin.AdminMapper;
import com.yuanzhi.tourism.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/22 13:28
 */
@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;
    public Admin login(String adminAccount, String adminPassword){
        return adminMapper.getAdminByExam(adminAccount,adminPassword);
    }

}
