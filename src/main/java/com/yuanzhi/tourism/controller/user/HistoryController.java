package com.yuanzhi.tourism.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.dto.HistoryDTO;
import com.yuanzhi.tourism.entity.History;
import com.yuanzhi.tourism.entity.Notification;
import com.yuanzhi.tourism.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/11/6 18:58
 */

@Controller
public class HistoryController {

    @Autowired
    HistoryService historyService;

    /**
     * 添加历史足迹
     * @param data
     * @return
     */
    @PostMapping("/history/add")
    @ResponseBody
    public Map<String,Object> addHistory(@RequestBody Map<String,String>data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer type = Integer.parseInt(data.get("type"));
        Integer typeId = Integer.parseInt(data.get("typeId"));
        Integer userId = Integer.parseInt(data.get("userId"));
        String typeName = data.get("typeName");
        String imgUrl = data.get("imgUrl");
        insert(type, typeId, userId,typeName,imgUrl);
        map.put("code",200);
        return map;
    }

    /**
     * 相同的内容则历史记录加一
     * @param data
     * @return
     */
    @PostMapping("/history/incTimes")
    @ResponseBody
    public Map<String,Object> incTimes(@RequestBody Map<String,String>data){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer type = Integer.parseInt(data.get("type"));
        Integer typeId = Integer.parseInt(data.get("typeId"));
        Integer userId = Integer.parseInt(data.get("userId"));
        String typeName = data.get("typeName");
        String imgUrl = data.get("imgUrl");
        List<History> historyList = historyService.isExist(type,typeId,userId);
        if (historyList.size() == 0){
            insert(type, typeId, userId,typeName,imgUrl);
        }else {
            historyService.incTimes(historyList.get(0).getHistoryId());
        }
        map.put("code",200);
        return map;
    }

    private void insert(Integer type, Integer typeId, Integer userId,String typeName,String imgUrl) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH代表24小时制，hh代表12小时制
        String publishTime = dateFormat.format(date);
        History history = new History();
        history.setHistoryTime(publishTime);
        history.setHistoryType(type);
        history.setTypeId(typeId);
        history.setUserId(userId);
        history.setHistoryTimes(1);
        history.setHistoryTypeName(typeName);
        history.setHistoryTypeImgurl(imgUrl);
//        System.out.println(history);
        historyService.addHistory(history);
    }

    /**
     * 获取某个用户历史足迹
     * @param
     * @return
     */
    @PostMapping("/history/getByUser")
    @ResponseBody
    public Map<String,Object> getByUser(@RequestParam(value = "userId")Integer userId,
                                        @RequestParam(value = "page",defaultValue = "1")int page,
                                        @RequestParam(value = "size",defaultValue = "7")int size){
        Map<String,Object> map = new HashMap<String, Object>();
        PageHelper.startPage(page,size);
        List<History> historyList = historyService.getByUser(userId);
        List<Integer> pages = getIntegers(page, map, historyList);
        map.put("pages",pages);
        return map;
    }
    private List<Integer> getIntegers(@RequestParam(value = "page", defaultValue = "1") int page, Map<String, Object> map, List<History> companyList) {
        PageInfo<History> pageInfo = new PageInfo<>(companyList);
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
     * 分页查询所有结伴
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/history/getAll")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<HistoryDTO> strategyDTOS = historyService.getAll(page,limit);
        Long companyNum = historyService.countNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",companyNum);
        map.put("data",strategyDTOS);
        return map;
    }

}
