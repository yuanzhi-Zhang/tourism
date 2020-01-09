package com.yuanzhi.tourism.controller.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanzhi.tourism.dto.SearchDTO;
import com.yuanzhi.tourism.entity.Company;
import com.yuanzhi.tourism.entity.Journey;
import com.yuanzhi.tourism.entity.Search;
import com.yuanzhi.tourism.entity.Strategy;
import com.yuanzhi.tourism.service.CompanyService;
import com.yuanzhi.tourism.service.JourneyService;
import com.yuanzhi.tourism.service.SearchService;
import com.yuanzhi.tourism.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/9 11:35
 */

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;
    @Autowired
    JourneyService journeyService;
    @Autowired
    StrategyService strategyService;
    @Autowired
    CompanyService companyService;

    /**
     * 根据关键词查询游记、攻略、结伴
     * @param data
     * @return
     */
    @PostMapping("/search/select")
    @ResponseBody
    public Map<String,Object> refreshNum(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Search search = new Search();
        Integer userId = Integer.parseInt(data.get("userId"));
        String content = data.get("content");
        search.setSearchContent(content);
        search.setUserId(userId);
        search.setSearchTimes(1);
        List<Journey> journeyList = journeyService.selectLike(content);
        List<Strategy> strategyList = strategyService.getStrategyLike(content);
        List<Company> companyList = companyService.selectLike(content);
        if(userId != 0){
            searchService.addSearch(search);
        }
        map.put("journeyList",journeyList);
        map.put("strategyList",strategyList);
        map.put("companyList",companyList);
        return map;
    }

    /**
     * 查询攻略
     * @param data
     * @return
     */
    @PostMapping("/search/selectStrategy")
    @ResponseBody
    public Map<String,Object> selectStrategy(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<String, Object>();
        Search search = new Search();
        int page = Integer.parseInt(data.get("page"));
        int size = Integer.parseInt(data.get("size"));
        Integer userId = Integer.parseInt(data.get("userId"));
        String content = data.get("content");
        search.setSearchContent(content);
        search.setUserId(userId);
        search.setSearchTimes(1);
        PageHelper.startPage(page,size);
        List<Strategy> strategyList = strategyService.getStrategyLike(content);
        List<Integer> pages = getPage(page, map, strategyList);
        map.put("pages",pages);
        if(userId != 0){
            searchService.addSearch(search);
        }
//        map.put("strategyList",strategyList);
        return map;
    }
    /**
     * 分页的公共方法
     * @param page
     * @param map
     * @param strategyList
     * @return
     */
    private List<Integer> getPage(@RequestParam(value = "page", defaultValue = "1") int page, Map<String, Object> map, List<Strategy> strategyList) {
        PageInfo<Strategy> pageInfo = new PageInfo<>(strategyList);
        List<Integer> pages = new ArrayList<>();
        map.put("total_size",pageInfo.getTotal());//总条数
        map.put("total_page",pageInfo.getPages());//总页数
        map.put("current_page",page);//当前页
        map.put("strategyList",pageInfo.getList());//数据
        pages.add(page);
        for (int i = 1; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }

            if (page + i <= pageInfo.getPages()) {
                pages.add(page + i);
            }
        }
        return pages;
    }

    @GetMapping("/search/getAll")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<SearchDTO> strategyDTOS = searchService.getAll(page,limit);
        Long companyNum = searchService.countNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",companyNum);
        map.put("data",strategyDTOS);
        return map;
    }

}
