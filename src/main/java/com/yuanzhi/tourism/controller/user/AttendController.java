package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.entity.Attend;
import com.yuanzhi.tourism.entity.User;
import com.yuanzhi.tourism.service.AttendService;
import com.yuanzhi.tourism.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/6 17:13
 */

@Controller
public class AttendController {

    @Autowired
    AttendService attendService;
    @Autowired
    CompanyService companyService;

    /**
     * 添加关注
     * @param data
     * @return
     * @throws ParseException
     */
    @PostMapping("/attend/addAttend")
    @ResponseBody
    public Map<String,Object> addAttend(@RequestBody Map<String,String> data) throws ParseException {
        Map<String,Object> map = new HashMap<String, Object>();
        Attend attend = new Attend();
        Integer type = Integer.parseInt(data.get("type"));
        Integer typeId = Integer.parseInt(data.get("typeId"));
        Integer userId = Integer.parseInt(data.get("userId"));
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
        Date publishTime = dateFormat.parse(dateFormat.format(date));
        attend.setAttendTime(publishTime);
        attend.setAttendType(type);
        attend.setAttendTypeId(typeId);
        attend.setAttendUserId(userId);
        attendService.addAttend(attend);
        companyService.incAttendNum(typeId);
        map.put("code",200);
        return map;
    }

    /**
     * 查询用户是否已关注某文章
     * @param data
     * @return
     * @throws ParseException
     */
    @PostMapping("/attend/isAttend")
    @ResponseBody
    public Map<String,Object> isAttend(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Attend attend = new Attend();
        Integer type = Integer.parseInt(data.get("type"));
        Integer typeId = Integer.parseInt(data.get("typeId"));
        Integer userId = Integer.parseInt(data.get("userId"));
        attend.setAttendType(type);
        attend.setAttendTypeId(typeId);
        attend.setAttendUserId(userId);
        Long isAttend = attendService.isAttend(attend);
        map.put("isAttend",isAttend);
        return map;
    }

    /**
     * 查询关注了某篇文章的用户
     * @param data
     * @return
     * @throws ParseException
     */
    @PostMapping("/attend/attendUserSelect")
    @ResponseBody
    public Map<String,Object> attendUserSelect(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer attendType = Integer.parseInt(data.get("type"));
        Integer attendTypeId = Integer.parseInt(data.get("typeId"));
        List<User> userList = attendService.attendUserSelect(attendType,attendTypeId);
        map.put("userList",userList);
        return map;
    }

}
