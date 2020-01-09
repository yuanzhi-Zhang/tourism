package com.yuanzhi.tourism.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.entity.Hotel;
import com.yuanzhi.tourism.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/2 11:32
 */

@Controller
public class HotelController {

    @Autowired
    HotelService hotelService;

    /**
     * 分页查询用户所在地区酒店
     * @param localCity
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/hotel")
    @ResponseBody
    public Map<String,Object> getHotel(@RequestParam(value = "localCity")String localCity,
                                       @RequestParam(value = "page",defaultValue = "1")int page,
                                       @RequestParam(value = "size",defaultValue = "7")int size){
        Map<String,Object>map = new HashMap<String, Object>();
        PageHelper.startPage(page,size);
        List<Hotel>hotelList = hotelService.getHotel(localCity);
        PageInfo<Hotel>pageInfo = new PageInfo<>(hotelList);
        List<Integer>pages = new ArrayList<>();
        map.put("total_size",pageInfo.getTotal());//总条数
        map.put("total_page",pageInfo.getPages());//总页数
        map.put("current_page",page);//当前页
        map.put("hotelList",pageInfo.getList());//数据
        pages.add(page);
        for (int i = 1; i <= 5; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= pageInfo.getPages()) {
                pages.add(page + i);
            }
        }
        map.put("pages",pages);
        return map;
    }

    /**
     * 跳转到对应的酒店详情页面
     * @param hotelId
     * @param model
     * @return
     */
    @GetMapping("/hotel/{hotelId}.html")
    public String toDetail(@PathVariable(name = "hotelId")String hotelId, Model model){
        hotelService.getDetail(hotelId);
        return "user/hotelDetail";
    }

    @GetMapping("/hotel/getAll")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<Hotel> strategyDTOS = hotelService.getAll(page,limit);
        Long num = hotelService.hotelNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",num);
        map.put("data",strategyDTOS);
        return map;
    }

    @PostMapping("/hotel/deleteHotel")
    @ResponseBody
    public Map<String,Object> deleteHotel(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer companyId = Integer.parseInt(data.get("companyId"));
        hotelService.deleteHotel(companyId);
        map.put("msg","删除成功");
        return map;
    }

    @PostMapping("/hotel/batchDelHotel")
    @ResponseBody
    public Map<String,Object> batchDelHotel(@RequestBody Map<String,Object> data){
        Map<String, Object>map = new HashMap<String, Object>();
        List<Integer>uidLst = (List<Integer>) data.get("userLists");
        hotelService.batchDelHotel(uidLst);
        map.put("msg","删除成功");
        return map;
    }

    @PostMapping("/hotel/hotelNum")
    @ResponseBody
    public Map<String,Object> hotelNum(){
        Map<String, Object>map = new HashMap<String, Object>();
        Long hotelNum = hotelService.hotelNum();
        map.put("hotelNum",hotelNum);
        return map;
    }

}
