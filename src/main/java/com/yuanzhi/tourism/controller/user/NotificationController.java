package com.yuanzhi.tourism.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.entity.Notification;
import com.yuanzhi.tourism.enums.NotificationTypeEnum;
import com.yuanzhi.tourism.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/11/6 18:58
 */

@Controller
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    /**
     * 获取用户通知信息
     * @param
     * @return
     */
    @PostMapping("/notification")
    @ResponseBody
    public Map<String,Object> getNote(@RequestParam(value = "userId")Integer userId,
                                      @RequestParam(value = "page",defaultValue = "1")int page,
                                      @RequestParam(value = "size",defaultValue = "7")int size){
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(page,size);
        List<Notification>notifications = notificationService.getByUser(userId);
        List<Integer> pages = getIntegers(page, map, notifications);
        map.put("pages",pages);
        return map;
    }

    private List<Integer> getIntegers(@RequestParam(value = "page", defaultValue = "1") int page, Map<String, Object> map, List<Notification> companyList) {
        PageInfo<Notification> pageInfo = new PageInfo<>(companyList);
        List<Integer>pages = new ArrayList<>();
        map.put("total_size",pageInfo.getTotal());//总条数
        map.put("total_page",pageInfo.getPages());//总页数
        map.put("current_page",page);//当前页
        map.put("notices",pageInfo.getList());//数据
        pages.add(page);
        for (int i = 1; i <= 5; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= pageInfo.getPages()) {
                pages.add(page + i);
            }
        }
        return pages;
    }

    /**
     * 用户通知未读状态更新成已读
     * @param noteId
     * @return
     */
    @PostMapping("/notification/upRead")
    @ResponseBody
    public Map<String,Object> upRead(@RequestParam(value = "noteId")Integer noteId){
        Map<String,Object> map = new HashMap<>();
        notificationService.upRead(noteId);
        map.put("code",200);
        return map;
    }

    /**
     * 用户删除某个通知
     * @param noteId
     * @return
     */
    @PostMapping("/notification/delete")
    @ResponseBody
    public Map<String,Object> upDelete(@RequestParam(value = "noteId")String noteId){
        Map<String,Object> map = new HashMap<>();
        notificationService.upDelete(Integer.parseInt(noteId));
        map.put("code",200);
        return map;
    }

    /**
     * 查询用户未读的通知数量
     * @param userId
     * @return
     */
    @PostMapping("/notification/noteNum")
    @ResponseBody
    public Map<String,Object> noteNum(@RequestParam(value = "userId")Integer userId){
        Map<String,Object> map = new HashMap<>();
        Long num = notificationService.noteNum(userId);
        map.put("unReadNum",num);
        return map;
    }

    /**
     * 通知总数
     * @return
     */
    @PostMapping("/notification/noteTotal")
    @ResponseBody
    public Map<String,Object> noteNum(){
        Map<String,Object> map = new HashMap<>();
        Long num = notificationService.noteTotal();
        map.put("noteTotal",num);
        return map;
    }

    /**
     * 分页获取所有
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/notification/getAll")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<Notification> strategyDTOS = notificationService.getAll(page,limit);
        Long num = notificationService.noteTotal();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",num);
        map.put("data",strategyDTOS);
        return map;
    }

    /**
     * 单个删除
     * @param data
     * @return
     */
    @PostMapping("/notification/deleteNotice")
    @ResponseBody
    public Map<String,Object> deleteStrategy(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer companyId = Integer.parseInt(data.get("companyId"));
        notificationService.deleteNotice(companyId);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 批量删除
     * @param data
     * @return
     */
    @PostMapping("/notification/batchDelNotice")
    @ResponseBody
    public Map<String,Object> batchDelCompany(@RequestBody Map<String,Object> data){
        Map<String, Object>map = new HashMap<String, Object>();
        List<Integer>uidLst = (List<Integer>) data.get("userLists");
        notificationService.batchDelNotice(uidLst);
        map.put("msg","删除成功");
        return map;
    }

}
