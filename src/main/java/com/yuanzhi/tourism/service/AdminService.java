package com.yuanzhi.tourism.service;

import com.yuanzhi.tourism.dao.AdminMapper;
import com.yuanzhi.tourism.entity.Admin;
import com.yuanzhi.tourism.entity.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/9/22 13:28
 */
@Service
public class AdminService {

    @Autowired
    AdminMapper adminMapper;

    /**
     * 核对管理员的登录信息是否正确
     * @param admin
     * @return
     */
    public Admin checkAdmin(Admin admin){
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        AdminExample.Criteria account = criteria.andAdminaccountEqualTo(admin.getAdminaccount());
        AdminExample.Criteria password = criteria.andAdminpasswordEqualTo(admin.getAdminpassword());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins.size() == 0){
            return null;
        }else {
            return admins.get(0);
        }
    }

}
