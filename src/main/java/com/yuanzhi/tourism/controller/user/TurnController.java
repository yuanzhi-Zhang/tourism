package com.yuanzhi.tourism.controller.user;

import com.yuanzhi.tourism.entity.Turn;
import com.yuanzhi.tourism.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuanzhi...
 * @Date: created in  2019/12/2 17:26
 */

@Controller
public class TurnController {

    @Autowired
    TurnService turnService;

    /**
     * 根据页面类型查询不同轮播图或视频
     * @param turnType
     * @return
     */
    @PostMapping("/turn")
    @ResponseBody
    public Map<String,Object> getTypeTurn(@RequestParam(value = "turnType")String turnType){
        Map<String,Object> map = new HashMap<String, Object>();
        List<Turn> turnList = turnService.getTypeTurn(turnType);
        map.put("turnList",turnList);
        return map;
    }

    //后台页面请求
    /**
     * 分页获取所有
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/turn/getAll")
    @ResponseBody
    public Map<String,Object> userList(@RequestParam(value="page")Integer page,
                                       @RequestParam(value="limit")Integer limit){
        Map<String,Object> map = new HashMap<>();
        page = (page-1) * limit;
        List<Turn> users = turnService.getAll(page,limit);
        Long total = turnService.getTurnNum();
        map.put("code",0);
        map.put("msg","查询成功");
        map.put("count",total);
        map.put("data",users);
        return map;
    }

    /**
     * 单个删除
     * @param data
     * @return
     */
    @PostMapping("/turn/deleteTurn")
    @ResponseBody
    public Map<String,Object> delUser(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer turnId = Integer.parseInt(data.get("userId"));
        turnService.delTurn(turnId);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 批量删除
     * @param data
     * @return
     */
    @PostMapping("/turn/batchDelTurn")
    @ResponseBody
    public Map<String,Object> batchDelUser(@RequestBody Map<String,Object> data){
        Map<String, Object>map = new HashMap<String, Object>();
        List<Integer>uidLst = (List<Integer>) data.get("userLists");
        turnService.batchDelTurn(uidLst);
        map.put("msg","删除成功");
        return map;
    }

    /**
     * 更改
     * @param data
     * @return
     */
    @PostMapping("/turn/updateTurn")
    @ResponseBody
    public Map<String,Object> updateTurn(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        Integer turnId = Integer.parseInt(data.get("turnId"));
        String type = data.get("type");
        String remarks = data.get("remarks");
        String url = data.get("turnUrl");
        Integer typeId = Integer.parseInt(data.get("typeId"));
        Turn turn = new Turn();
        turn.setTurnId(turnId);
        turn.setTurnType(type);
        turn.setTurnTypeId(typeId);
        turn.setTurnRemarks(remarks);
        turn.setTurnUrl(url);
        turnService.upTurn(turn);
        map.put("msg","修改成功");
        return map;
    }

    /**
     * 添加
     * @param data
     * @return
     */
    @PostMapping("/turn/addTurn")
    @ResponseBody
    public Map<String,Object> addTurn(@RequestBody Map<String,String> data){
        Map<String,Object> map = new HashMap<>();
        String type = data.get("type");
        String remarks = data.get("remarks");
        String url = data.get("turnUrl");
        Integer typeId = Integer.parseInt(data.get("typeId"));
        Turn turn = new Turn();
        turn.setTurnType(type);
        turn.setTurnTypeId(typeId);
        turn.setTurnRemarks(remarks);
        turn.setTurnUrl(url);
        turnService.addTurn(turn);
        map.put("msg","添加成功");
        return map;
    }

    @GetMapping("/pages/turn/turn-edit.html/{turnId}")
    public String turnEdit1(@PathVariable(name = "turnId") String turnId, Model model){
        Turn turn = turnService.getById(Integer.parseInt(turnId));
        model.addAttribute("turn",turn);
        return "admin/pages/turn/turn-edit";
    }

}
