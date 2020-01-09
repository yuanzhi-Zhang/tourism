package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.dto.EnterCompanyDTO;
import com.yuanzhi.tourism.dto.EnterDTO;
import com.yuanzhi.tourism.entity.Enter;
import com.yuanzhi.tourism.service.CompanyService;
import com.yuanzhi.tourism.service.EnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/6 13:40
 */

@Controller
public class EnterController {

    @Autowired
    EnterService enterService;
    @Autowired
    CompanyService companyService;

    /**
     * 报名对应的结伴
     * @param data
     * @return
     */
    @PostMapping("/enter/addEnter")
    @ResponseBody
    public Map<String,Object> incView(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Date date1 = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
        String time = dateFormat.format(date1);
        Enter enter = new Enter();
        Integer companyId = Integer.parseInt(data.get("companyId"));
        Integer userId = Integer.parseInt(data.get("userId"));
        Integer companyMaleNum = Integer.parseInt(data.get("companyMaleNum"));
        Integer companyFemaleNum = Integer.parseInt(data.get("companyFemaleNum"));
        String userPhone = data.get("userPhone");
        String enterRemarks = data.get("enterRemarks");
        enter.setCompanyId(companyId);
        enter.setCompanyFemaleNum(companyFemaleNum);
        enter.setCompanyMaleNum(companyMaleNum);
        enter.setEnterRemarks(enterRemarks);
        enter.setEnterTime(time);
        enter.setUserId(userId);
        enter.setUserPhone(userPhone);
        enterService.addEnter(enter);
        companyService.incEnterNum(companyId);
        map.put("code",200);
        return map;
    }

    /**
     * 查询用户是否已经报名对应的结伴
     * @param data
     * @return
     */
    @PostMapping("/enter/isEntered")
    @ResponseBody
    public Map<String ,Object> isEntered(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String,Object>();
        Integer companyId = Integer.parseInt(data.get("companyId"));
        Integer userId = Integer.parseInt(data.get("userId"));
        Long isEntered = enterService.isEntered(companyId,userId);
        map.put("isEntered",isEntered);
        return map;
    }

    /**
     * 根据某个结伴获取所有该结伴的带有报名人的报名信息
     * @param data
     * @return
     */
    @PostMapping("/enter/getWithUser")
    @ResponseBody
    public Map<String ,Object> getWithUser(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String,Object>();
        Integer companyId = Integer.parseInt(data.get("companyId"));
        List<EnterDTO> enterDTOS = enterService.getWithUser(companyId);
        map.put("enterDTOS",enterDTOS);
        return map;
    }

    /**
     * 根据用户获取所有报名
     * @param data
     * @return
     */
    @PostMapping("/enter/getUserEnter")
    @ResponseBody
    public Map<String ,Object> getUserEnter(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String,Object>();
        Integer userId = Integer.parseInt(data.get("userId"));
        List<EnterCompanyDTO> enterDTOS = enterService.getUserEnter(userId);
        map.put("enterDTOS",enterDTOS);
        return map;
    }

}
