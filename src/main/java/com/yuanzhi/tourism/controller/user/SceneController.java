package com.yuanzhi.tourism.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.common.SceneApi;
import com.yuanzhi.tourism.entity.Scene;
import com.yuanzhi.tourism.service.SceneService;
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
 * @Date: created in  2019/12/1 14:20
 */

@Controller
public class SceneController {

    @Autowired
    SceneService sceneService;

    @GetMapping("/scene/select")
    @ResponseBody
    public Map<String,Object> getScene(){
        Map<String,Object>map = new HashMap<String,Object>();
        List<Scene>list = sceneService.getScene();
        map.put("data",list);
        return map;
    }

    /**
     * 获取所有景点(分页)
     * @param page
     * @param size
     * @return
     */
    @PostMapping("/scene/getAll")
    @ResponseBody
    public Map<String,Object> getAll(@RequestParam(value = "page",defaultValue = "1")int page,
                                     @RequestParam(value = "size",defaultValue = "16")int size){
        Map<String,Object>map = new HashMap<String,Object>();
        PageHelper.startPage(page,size);
        List<Scene>sceneList = sceneService.getAll();
        List<Integer> pages = getIntegers(page, map, sceneList);
        map.put("pages",pages);
        return map;
    }
    private List<Integer> getIntegers(@RequestParam(value = "page", defaultValue = "1") int page, Map<String, Object> map, List<Scene> sceneList) {
        PageInfo<Scene> pageInfo = new PageInfo<>(sceneList);
        List<Integer>pages = new ArrayList<>();
        map.put("total_size",pageInfo.getTotal());//总条数
        map.put("total_page",pageInfo.getPages());//总页数
        map.put("current_page",page);//当前页
        map.put("sceneList",pageInfo.getList());//数据
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

    @GetMapping("/scene/{sid}.html")
    public String toOtherUser(@PathVariable(name = "sid")Integer sid, Model model){
        Scene scene = sceneService.getById(sid);
        model.addAttribute("scene",scene);
        return "user/routeDetail";
    }

    @PostMapping("/scene/getOneDetail")
    @ResponseBody
    public Map<String ,Object> getOneDetail(Map<String ,String> data){
        Map<String,Object> map = new HashMap<String,Object>();
        Scene scene = sceneService.selectById(Integer.parseInt(data.get("sceneId")));
        map.put("scene",scene);
        return map;
    }

    @GetMapping("/scene/getAll")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<Scene> strategyDTOS = sceneService.getAllScene(page,limit);
        Long companyNum = sceneService.countNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",companyNum);
        map.put("data",strategyDTOS);
        return map;
    }

}
